package cn.jiuling.comparesystem.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.comparesystem.dao.CarpicDao;
import cn.jiuling.comparesystem.model.Carpic;

@Repository("carpicDao")
public class CarpicDaoImpl extends BaseDaoImpl<Carpic> implements CarpicDao {

	@Override
	public List findPic(Integer carTypeId) {
		String queryString = "from Carpic c where c.car.id=?";
		return super.getHibernateTemplate().find(queryString, carTypeId);
	}

}
