package cn.jiuling.comparesystem.service;

import java.util.List;

import cn.jiuling.comparesystem.model.Car;
import cn.jiuling.comparesystem.vo.CarQuery;
import cn.jiuling.comparesystem.vo.CarVo;
import cn.jiuling.comparesystem.vo.Pager;

public interface CarService {
	public List<CarVo> findCarType(Integer seriesId);

	public String findCarData();

	public Pager findCarType(CarQuery c, Integer page, Integer size);

	public List findPic(Integer carTypeId);

	public Car add(Car c);
}
