package cn.jiuling.comparesystem.service;

import cn.jiuling.comparesystem.model.Video;
import cn.jiuling.comparesystem.vo.Pager;

public interface VideoService {
	public Pager list(Video v, Integer page, Integer rows);
	public void save(Video v);
	public void update(Video v);
	public void delete(Integer [] ids);
	public Video findById(Integer id);
}
