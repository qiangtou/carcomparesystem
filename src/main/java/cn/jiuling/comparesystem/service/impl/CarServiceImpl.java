package cn.jiuling.comparesystem.service.impl;

import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import cn.jiuling.comparesystem.dao.CarDao;
import cn.jiuling.comparesystem.dao.CarpicDao;
import cn.jiuling.comparesystem.dao.SeriesDao;
import cn.jiuling.comparesystem.model.Car;
import cn.jiuling.comparesystem.service.CarService;
import cn.jiuling.comparesystem.vo.BrandVo;
import cn.jiuling.comparesystem.vo.CarQuery;
import cn.jiuling.comparesystem.vo.CarVo;
import cn.jiuling.comparesystem.vo.Pager;
import cn.jiuling.comparesystem.vo.SeriesVo;

@Service("carService")
public class CarServiceImpl implements CarService {
	@Resource
	private CarDao carDao;
	@Resource
	private SeriesDao seriesDao;
	@Resource
	private CarpicDao carpicDao;

	@Override
	public List<CarVo> findCarType(Integer seriesId) {
		return carDao.findCar(seriesId);
	}

	@Override
	public String findCarData() {
		List<SeriesVo> list = seriesDao.fetchSeries();
		BrandVo bVo;
		Integer brandId;
		List<BrandVo> brandList = new ArrayList<BrandVo>();
		Map<Integer, BrandVo> brandMap = new HashMap<Integer, BrandVo>();
		for (SeriesVo s : list) {
			brandId = s.getBrandId();
			if (null == brandMap.get(brandId)) {
				bVo = new BrandVo();
				bVo.setName(s.getBrandName());
				bVo.setId(brandId);
				bVo.setsName(s.getsName());
				brandMap.put(brandId, bVo);
				brandList.add(bVo);
			} else {
				bVo = brandMap.get(brandId);
			}
			bVo.getSeries().add(s);
		}
		brandMap.clear();
		Writer out = new StringWriter();
		try {
			ObjectMapper m = new ObjectMapper();
			JsonGenerator g = m.getJsonFactory().createJsonGenerator(out);
			g.writeObject(brandList);
		} catch (Exception e) {
		}
		return out.toString();
	}

	@Override
	public Pager findCarType(CarQuery c, Integer page, Integer size) {
		Pager p = carDao.findCar(c, page, size);
		return p;
	}

	@Override
	public List findPic(Integer carTypeId) {
		return carpicDao.findPic(carTypeId);
	}

	@Override
	public Car add(Car c) {
		carDao.save(c);
		return c;
	}
}
