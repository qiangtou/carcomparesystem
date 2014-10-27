package cn.jiuling.comparesystem.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.comparesystem.dao.CarDao;
import cn.jiuling.comparesystem.model.Car;
import cn.jiuling.comparesystem.vo.CarQuery;
import cn.jiuling.comparesystem.vo.CarVo;
import cn.jiuling.comparesystem.vo.Pager;

@Repository("carDao")
public class CarDaoImpl extends BaseDaoImpl<Car> implements CarDao {

	@Override
	public List<CarVo> findCar(Integer seriesId) {
		/*CarVo(Integer seriesId, String name, Integer year, Integer price)*/
		String queryString = "select new cn.jiuling.comparesystem.vo.CarVo(c.series.id,c.name,c.year,c.price) " +
				"from Car c where c.series.id=?";
		return super.getHibernateTemplate().find(queryString, seriesId);
	}

	@Override
	public Pager findCar(CarQuery c, Integer page, Integer size) {
		StringBuilder hql = new StringBuilder("from Car where 1=1");
		List param=new ArrayList();
		Short[] level = c.getLevel();
		if (level != null && level.length > 0) {
			hql.append(" and level in(");
			for (int i = 0; i < level.length; i++) {
				hql.append(level[i] + ",");
			}
			hql.deleteCharAt(hql.length() - 1).append(")");
		}
		Short openType = c.getOpenType();
		if (null != openType && openType > 0) {
			hql.append(" and openType =?");
			param.add(openType);
		}
		Integer seatNum = c.getSeatNum();
		if (null != seatNum && seatNum > 0) {
			hql.append(" and seatNum =?");
			param.add(seatNum);
		}
		Integer sideDoorNum = c.getSideDoorNum();
		if (null != sideDoorNum && sideDoorNum > 0) {
			hql.append(" and sideDoorNum =?");
			param.add(sideDoorNum);
		}
		Short structure = c.getStructure();
		if (null != structure && structure > 0) {
			hql.append(" and structure =?");
			param.add(structure);
		}
		Object[] paramArr = param.toArray();
		Long total = count("select count(*) " + hql.toString(),paramArr);
		List list =find(hql.toString(), paramArr, page, size);
		return new Pager(total, list);
	}
}
