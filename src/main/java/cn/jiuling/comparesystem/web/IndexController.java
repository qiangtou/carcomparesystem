package cn.jiuling.comparesystem.web;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.ModelAndView;

import cn.jiuling.comparesystem.service.CarService;
import cn.jiuling.comparesystem.utils.Privilege;
import cn.jiuling.comparesystem.utils.PropertiesUtils;

@Controller
public class IndexController {

	@Resource
	private CarService carService;

	@Privilege
	@RequestMapping("index.action")
	public void index(ModelAndView m) {
		String resServerIpKey = "resServerIp";
		String resServerIp = PropertiesUtils.get(resServerIpKey);
		m.addObject(resServerIpKey, resServerIp);

		String root = ContextLoader.getCurrentWebApplicationContext()
				.getServletContext().getRealPath("/");

		String resPathKey = "resPath";
		String resPath = PropertiesUtils.get(resPathKey);
		m.addObject(resPathKey, resPath);
		String resAbsolutePath = root + File.separator + resPath;
		resAbsolutePath = resAbsolutePath.replace("\\", "\\\\");
		m.addObject("resAbsolutePath", resAbsolutePath);
	}

	@RequestMapping("input.action")
	public ModelAndView input(ModelAndView m) {
		String brandData = carService.findCarData();
		m.addObject("brandData", brandData);
		m.setViewName("input");
		return m;
	}
}
