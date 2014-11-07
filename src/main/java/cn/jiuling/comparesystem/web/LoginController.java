package cn.jiuling.comparesystem.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.jiuling.comparesystem.model.User;
import cn.jiuling.comparesystem.service.UserService;

@Controller
public class LoginController extends BaseController {

	@Resource
	private UserService userService;

	@RequestMapping(value = "login.action", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView m) {

		return m;
	}

	@RequestMapping(value = "login.action", method = RequestMethod.POST)
	@ResponseBody
	public Boolean valid(
			@RequestParam(defaultValue = "") String loginName,
			String pwd,
			HttpSession session) {
		User user = userService.findUser(loginName);
		Boolean valid = userService.validUser(user, pwd);
		if (valid) {
			session.setAttribute("user", user);
		}
		return valid;
	}

	@RequestMapping(value = "logout.action")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login.action";
	}
}
