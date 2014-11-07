package cn.jiuling.comparesystem.service.impl;

import java.io.File;
import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

import cn.jiuling.comparesystem.dao.PicDao;
import cn.jiuling.comparesystem.model.Pic;
import cn.jiuling.comparesystem.service.PicService;
import cn.jiuling.comparesystem.utils.PropertiesUtils;

@Service("picService")
public class PicServiceImpl implements PicService {

	@Resource
	private PicDao picDao;
	
	@Override
	public Pic upload(MultipartFile file) throws Exception {
		String root = ContextLoader.getCurrentWebApplicationContext()
		.getServletContext().getRealPath("/");
		String path = PropertiesUtils.get("resPath");
		String fileName = createFileName(file.getOriginalFilename());
		String filePath = root + "\\" + path + "\\" + fileName;
		String url = path + "/" + fileName;
		File urlFile = new File(filePath);
		file.transferTo(urlFile);
		Pic pic = new Pic();
		pic.setName(fileName);
		pic.setIsShow((short)1);
		pic.setUrl(url);
		return pic;
	}
	public String createFileName(String fileName) {

		String suffix = fileName.substring(fileName.lastIndexOf('.'), fileName
				.length());

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);// 得到年
		int month = cal.get(Calendar.MONTH) + 1;// 得到月，因为从0开始的，所以要加1
		int day = cal.get(Calendar.DAY_OF_MONTH);// 得到天
		int hour = cal.get(Calendar.HOUR_OF_DAY);// 得到小时
		int minute = cal.get(Calendar.MINUTE);// 得到分钟
		int second = cal.get(Calendar.SECOND);// 得到秒
		int millsecond = cal.get(Calendar.MILLISECOND);// 得到毫秒

		fileName = "" + year + month + day + hour + minute + second + millsecond + suffix;
		return fileName;
	}
	@Override
	public void save(Pic pic) {
		picDao.save(pic);
	}
}
