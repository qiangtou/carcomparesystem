package cn.jiuling.comparesystem.web;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import cn.jiuling.comparesystem.utils.CustomTimestampEditor;

public class BaseController {
	protected Logger log = Logger.getLogger(this.getClass());
	protected String SUCCESS = "success";

	protected Integer getUserId(HttpServletRequest request) {
		Object o = WebUtils.getSessionAttribute(request, "user");
		return 1;
	}

	private void log(HttpServletRequest req, Exception e) {
		log.error(e.getMessage(), e);
		log.error("Request: " + req.getRequestURL() + "---" + parameter2String(req) + ", raised: " + e.getMessage(), e.getCause());
	}

	private String parameter2String(HttpServletRequest req) {
		Map m = req.getParameterMap();
		StringBuilder sb = new StringBuilder();
		for (Iterator i = m.keySet().iterator(); i.hasNext();) {
			Object key = i.next();
			Object[] object = (Object[]) m.get(key);
			Object value = object[0];
			if (!StringUtils.isEmpty(value)) {
				sb.append(key + "=" + value + ",");
			}
		}
		return sb.toString();
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object handleError(HttpServletRequest req, Exception e) {
		log(req, e);
		return getExceptionMsg(e);
	}

	private String getExceptionMsg(Exception e) {
		if (e instanceof DataAccessException) {
			return "数据库访问错误";
		}
		return e.getMessage();
	}

	/**
	 * 自定义日期类型数据绑定 将指定时间格式的字符串能自动加载到Timestamp类型的控制层参数中
	 * 如果不加，Controller中的方法无法直接用Timestamp类型接收前台时间数据
	 * 
	 * @param binder
	 *            前台数据绑定器
	 * @throws Exception
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomTimestampEditor dateEditor = new CustomTimestampEditor(df, true);
		binder.registerCustomEditor(Timestamp.class, dateEditor);
	}

}
