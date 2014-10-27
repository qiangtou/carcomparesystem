package cn.jiuling.comparesystem.dao.impl;

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
	public Pager findCar(CarQuery c) {
		StringBuilder wQuery = new StringBuilder();
		Short[] level = c.getLevel();
		if (level != null && level.length > 0) {
			wQuery.append(" and level in(");
			for (int i = 0; i < level.length; i++) {
				wQuery.append(level[i] + ",");
			}
			wQuery.deleteCharAt(wQuery.length() - 1).append(")");
		}
		Short openType = c.getOpenType();
		if (null != openType && openType > 0) {
			wQuery.append(" and openType =" + openType);
		}
		Short seatNum = c.getSeatNum();
		if (null != seatNum && seatNum > 0) {
			wQuery.append(" and seatNum =" + seatNum);
		}
		Short sideDoorNum = c.getSideDoorNum();
		if (null != sideDoorNum && sideDoorNum > 0) {
			wQuery.append(" and sideDoorNum =" + sideDoorNum);
		}
		Short structure = c.getStructure();
		if (null != structure && structure > 0) {
			wQuery.append(" and structure =" + structure);
		}
		Long total = count("select count(*) from Car where 1=1" + wQuery.toString());
		List list = super.getHibernateTemplate().find("from Car where 1=1" + wQuery.toString());
		Pager p = new Pager(total, list);
		return p;
	}
}
