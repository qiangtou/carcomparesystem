package cn.jiuling.comparesystem.web;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiuling.comparesystem.model.Brand;
import cn.jiuling.comparesystem.model.Car;
import cn.jiuling.comparesystem.model.Series;
import cn.jiuling.comparesystem.service.CarService;
import cn.jiuling.comparesystem.vo.CarExtendPropertyVo;
import cn.jiuling.comparesystem.vo.CarQuery;
import cn.jiuling.comparesystem.vo.CarVo;
import cn.jiuling.comparesystem.vo.Pager;

@Controller
@RequestMapping("/car")
public class CarController extends BaseController {
	@Resource
	private CarService carService;

	@RequestMapping("index.action")
	public void queryIndex(Model m) {
		String brandData = carService.findCarData();
		m.addAttribute("brandData", brandData);
	}

	@RequestMapping("findType.action")
	@ResponseBody
	public List queryIndex(Integer seriesId) {
		List<CarVo> carTypeList = carService.findCarType(seriesId);
		return carTypeList;
	}

	@RequestMapping("query.action")
	@ResponseBody
	public Pager query(CarQuery c,
			@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer size) {
		Pager p = carService.findCarType(c, page, size);
		return p;
	}

	@RequestMapping("showPic.action")
	@ResponseBody
	public List showPic(Integer carTypeId) {
		List list = carService.findPic(carTypeId);
		return list;
	}

	@RequestMapping("add.action")
	@ResponseBody
	public Object add(Car c, CarExtendPropertyVo v, Integer seriesId, Integer brandId) throws Exception {

		Series series = new Series();
		series.setId(seriesId);
		Brand brand = new Brand();
		series.setBrand(brand);
		c.setSeries(series);
		
		if(v != null) {
			Writer out = new StringWriter();
			ObjectMapper m = new ObjectMapper();
			JsonGenerator g = m.getJsonFactory().createJsonGenerator(out);
			g.writeObject(v);
		
			c.setExtendProperty(out.toString());
		}
		c = carService.add(c);
		return c;
	}

}
