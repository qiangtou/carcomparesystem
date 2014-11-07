package cn.jiuling.comparesystem.service;

import org.springframework.web.multipart.MultipartFile;

import cn.jiuling.comparesystem.model.Pic;

public interface PicService {
	public Pic upload(MultipartFile file) throws Exception;
	public String createFileName(String fileName);
	public void save(Pic pic);
}
