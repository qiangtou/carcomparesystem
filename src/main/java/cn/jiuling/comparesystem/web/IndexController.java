package cn.jiuling.comparesystem.web;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;

import cn.jiuling.comparesystem.utils.PropertiesUtils;

@Controller
public class IndexController {

	@RequestMapping("index.action")
	public void index(Model m) {
		String resServerIpKey = "resServerIp";
		String resServerIp = PropertiesUtils.get(resServerIpKey);
		m.addAttribute(resServerIpKey, resServerIp);

		String root = ContextLoader.getCurrentWebApplicationContext()
				.getServletContext().getRealPath("/");

		String resPathKey = "resPath";
		String resPath = PropertiesUtils.get(resPathKey);
		m.addAttribute(resPathKey, resPath);
		String resAbsolutePath = root + File.separator + resPath;
		resAbsolutePath = resAbsolutePath.replace("\\", "\\\\");
		m.addAttribute("resAbsolutePath", resAbsolutePath);
	}
}
