package cn.jiuling.comparesystem.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private final Logger log = Logger.getLogger(LoginInterceptor.class);
	private static final String LOGIN_PATH = "/login.action";

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		Object user = WebUtils.getSessionAttribute(request, "user");

		if (null == user) {
			response.sendRedirect(LOGIN_PATH);
			return false;
		}
		/*User u = (User) user;
		if (handler instanceof HandlerMethod) {
			HandlerMethod hm = (HandlerMethod) handler;
			Privilege p = hm.getMethodAnnotation(Privilege.class);
			if (null != p) {
				log.info("访问权限" + p.value() + "," + request.getRequestURI());
			}
		}*/
		return true;
	}
}
