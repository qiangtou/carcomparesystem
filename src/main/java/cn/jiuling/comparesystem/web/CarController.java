package cn.jiuling.comparesystem.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiuling.comparesystem.service.CarService;
import cn.jiuling.comparesystem.vo.CarQuery;
import cn.jiuling.comparesystem.vo.CarVo;

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
	public List query(CarQuery c) {
		List list = carService.findCarType(c);
		return list;
	}

}
