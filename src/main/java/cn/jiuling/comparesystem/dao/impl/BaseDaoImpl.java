package cn.jiuling.comparesystem.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.StringUtils;

import cn.jiuling.comparesystem.dao.BaseDao;
import cn.jiuling.comparesystem.queryDTO.QueryObj;
import cn.jiuling.comparesystem.vo.Pager;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	protected Logger log = Logger.getLogger(this.getClass());
	private Class clazz;

	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public Class getClazz() {
		if (null == this.clazz) {
			Class clazz = (Class<T>) getClass();
			ParameterizedType pt = (ParameterizedType) clazz.getGenericSuperclass();
			this.clazz = (Class) pt.getActualTypeArguments()[0];
		}
		return this.clazz;
	}

	public void deleteAll() {
		List<T> entities = getAll();
		getHibernateTemplate().deleteAll(entities);
	}

	public T find(Serializable id) {
		return (T) getHibernateTemplate().get(getClazz(), id);
	}

	public Serializable save(T t) {
		return getHibernateTemplate().save(t);
	}

	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	public void saveOrUpdate(Object t) {
		getHibernateTemplate().saveOrUpdate(t);
	}

	public List<T> getAll() {
		return getHibernateTemplate().find("from " + getClazz().getName());
	}

	public T findByProperty(String name, Object value) {
		String entityName = getClazz().getName();
		DetachedCriteria dc = DetachedCriteria.forEntityName(entityName);
		dc.add(Restrictions.eq(name, value));
		List<T> list = getHibernateTemplate().findByCriteria(dc, 0, 1);
		return list.size() > 0 ? (T) list.get(0) : null;
	}

	public List findByPropertyList(String name, Object value) {
		String entityName = getClazz().getName();
		return getHibernateTemplate().find("from " + entityName + " n where n." + name + "=?", value);
	}

	public Pager list(Integer page, Integer rows) {
		return list(new Object(), page, rows);
	}

	public Pager list(Object exampleEntity, Integer page, Integer rows) {
		return list(exampleEntity, page, rows, "");
	}

	public Pager list(Object exampleEntity, Integer page, Integer rows, String query) {
		String entityName = getClazz().getName();
		String hql = "from " + entityName + " where 1=1 " + query + " ";
		Class<? extends Object> clz = exampleEntity.getClass();
		Field[] fs = clz.getDeclaredFields();
		List<Object> paramList = new ArrayList<Object>();
		// 这个循环用于处理exampleEntity中的属性，如果有非null值，就加入hql中去
		for (int i = 0; i < fs.length; i++) {
			Field f = fs[i];
			f.setAccessible(true);
			String name = f.getName();
			Object value = null;
			try {
				getClazz().getDeclaredField(name);
				value = f.get(exampleEntity);
			} catch (Exception e) {
				continue;
			}

			if (value != null && !value.equals("")) {
				// 待处理更多条件
				if (name.equals("startTime")) {
					hql += "and startTime >=? ";
				} else if (name.equals("endTime")) {
					hql += "and startTime <=? ";
				} else if (value instanceof Number) {
					hql += "and " + name + "=? ";
				} else if (value instanceof Date) {
					hql += "and " + name + "=? ";
				} else if (name.equals("citedNum")) {
					hql += "and " + name + ">=? ";
				} else {
					// 默认使用like模糊查询
					hql += "and " + name + " like ? ";
					value = "%" + value + "%";
				}
				paramList.add(value);
			}
		}

		final Object[] paramArr = paramList.toArray();
		// 查询总记录数
		Long total = (Long) getHibernateTemplate().find("select count(*) " + hql, paramArr).get(0);

		try {
			// 如果有createTime属性,则按createTime倒序
			getClazz().getDeclaredField("createTime");
			hql = hql + " order by createTime desc";
		} catch (Exception e) {
		}
		List list = find(hql, paramArr, page, rows);
		return new Pager(total, list);
	}

	public List findByExample(Object example) {
		return super.getHibernateTemplate().findByExample(example);
	};

	public Long count(String hql, Object[] paramArr) {
		return (Long) getHibernateTemplate().find(hql, paramArr).get(0);
	}

	public Long count(String hql) {
		return (Long) getHibernateTemplate().find(hql).get(0);
	}

	public List find(String queryString, Object[] values, Integer page, Integer rows) {
		final String newHql = queryString;

		final Integer firstResult = page == null ? -1 : (page - 1) * rows;
		final Integer maxResults = rows == null ? -1 : rows;
		final Object[] paramArr = values;
		// 查询一页
		List<T> list = getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
			@Override
			public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
				Query q = session.createQuery(newHql);
				if (firstResult >= 0) {
					q.setFirstResult(firstResult);
				}
				if (maxResults > 0) {
					q.setMaxResults(maxResults);
				}
				if (paramArr != null) {
					for (int i = 0; i < paramArr.length; i++) {
						q.setParameter(i, paramArr[i]);
					}
				}
				return q.list();
			}
		});
		return list;
	};

	/**
	 * 用于多表查询where语句的构造.
	 * 
	 * 忽略null,空值属性,构造where语句,Model的别名使用类名的小写形式
	 * 
	 * @param objs
	 *            传入多个待构造的对象,
	 * @return QueryObj query:生成的hql字符串;list:参数值列表
	 * 
	 */
	public QueryObj generateQuery(Object... objs) {
		Object o;
		QueryObj q = new QueryObj();
		StringBuilder sb = new StringBuilder();
		String className;
		String fieldName;
		Field[] fs;
		Field f;
		Object value;
		Class<? extends Object> clz;
		try {
			for (int i = 0; i < objs.length; i++) {
				o = objs[i];
				clz = o.getClass();
				className = clz.getSimpleName().toLowerCase();
				fs = clz.getDeclaredFields();
				for (int j = 0; j < fs.length; j++) {
					f = fs[j];
					f.setAccessible(true);
					fieldName = "_" + className + "." + f.getName();
					value = f.get(o);
					if (!StringUtils.isEmpty(value)) {
						if (value instanceof Number) {
							sb.append(" and " + fieldName + "=?");
						} else if (fieldName.endsWith("startTime")) {
							sb.append(" and " + fieldName + ">=? ");
						} else if (fieldName.endsWith("endTime")) {
							sb.append(" and " + "_" + className + ".startTime" + "<=? ");
						} else if (value instanceof Date) {
							sb.append(" and " + fieldName + "=?");
						} else if (value instanceof Boolean) {
							sb.append(" and " + fieldName + "=?");
						} else if (fieldName.endsWith("citedNum")) {
							sb.append(" and " + fieldName + ">=? ");
						} else {
							sb.append(" and " + fieldName + " like ?");
							value = "%" + value + "%";
						}
						q.getList().add(value);
					}
				}
			}
			q.setQuery(sb.toString());
		} catch (Exception e) {
			q = new QueryObj();
		}
		return q;
	}

	@Override
	public void count(T t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}

}
