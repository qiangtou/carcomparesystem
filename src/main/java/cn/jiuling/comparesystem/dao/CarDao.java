package cn.jiuling.comparesystem.dao;

import java.util.List;

import cn.jiuling.comparesystem.model.Car;
import cn.jiuling.comparesystem.vo.CarQuery;
import cn.jiuling.comparesystem.vo.CarVo;
import cn.jiuling.comparesystem.vo.Pager;

public interface CarDao extends BaseDao<Car> {

	public List<CarVo> findCar(Integer seriesId);

	public Pager findCar(CarQuery c, Integer page, Integer size);

}
