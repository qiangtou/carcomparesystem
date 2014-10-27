package cn.jiuling.comparesystem.service;

import java.util.List;

import cn.jiuling.comparesystem.vo.CarQuery;
import cn.jiuling.comparesystem.vo.CarVo;

public interface CarService {
	public List<CarVo> findCarType(Integer seriesId);

	public String findCarData();

	public List findCarType(CarQuery c);
}
