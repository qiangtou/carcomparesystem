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
		String queryString = "select new cn.jiuling.comparesystem.vo.CarVo(c.series.id,c.id,c.name,c.year,c.price) " +
				"from Car c where c.series.id=?";
		return super.getHibernateTemplate().find(queryString, seriesId);
	}

	@Override
	public Pager findCar(CarQuery c, Integer page, Integer size) {

		StringBuilder hql = new StringBuilder(" from Car c left join c.series s left join s.brand b  where 1=1");
		List param = new ArrayList();

		Integer carTypeId = c.getCarTypeId();
		Integer seriesId = c.getSeriesId();
		Integer brandId = c.getBrandId();
		if (null != carTypeId && carTypeId > 0) {
			hql.append(" and c.id =?");
			param.add(carTypeId);
		} else if (null != seriesId && seriesId > 0) {
			hql.append(" and s.id =?");
			param.add(seriesId);
		} else if (null != brandId && brandId > 0) {
			hql.append(" and b.id =?");
			param.add(brandId);
		}

		Short[] level = c.getLevel();
		if (level != null && level.length > 0) {
			hql.append(" and c.level in(");
			for (int i = 0; i < level.length; i++) {
				hql.append(level[i] + ",");
			}
			hql.deleteCharAt(hql.length() - 1).append(")");
		}
		Short openType = c.getOpenType();
		if (null != openType && openType > 0) {
			hql.append(" and c.openType =?");
			param.add(openType);
		}
		Integer seatNum = c.getSeatNum();
		if (null != seatNum && seatNum > 0) {
			hql.append(" and c.seatNum =?");
			param.add(seatNum);
		}
		Integer sideDoorNum = c.getSideDoorNum();
		if (null != sideDoorNum && sideDoorNum > 0) {
			hql.append(" and c.sideDoorNum =?");
			param.add(sideDoorNum);
		}
		Short structure = c.getStructure();
		if (null != structure && structure > 0) {
			hql.append(" and c.structure =?");
			param.add(structure);
		}
		Object[] paramArr = param.toArray();
		Long total = count("select count(c.id)" + hql.toString(), paramArr);
		/*
		Integer seriesId, Integer id, String name, Integer year, Integer price, Integer brandId, Short level, Short structure, String seriesName,
			String brandName, Integer sideDoorNum, Integer seatNum, Short openType, String extendProperty
					*/
		List list = find("select new cn.jiuling.comparesystem.vo.CarTypeVo(" +
				"s.id,c.id,c.name,c.year,c.price,b.id,c.level,c.structure,s.name,b.name,c.sideDoorNum,c.seatNum,c.openType,c.extendProperty)"
						+ hql.toString(), paramArr,
				page, size);
		return new Pager(total, list);
	}
}
