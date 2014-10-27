package cn.jiuling.comparesystem.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiuling.comparesystem.service.CarService;
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
			@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="10")Integer size) {
		Pager p = carService.findCarType(c, page, size);
		return p;
	}

}
