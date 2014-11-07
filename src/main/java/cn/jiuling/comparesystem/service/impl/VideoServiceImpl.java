package cn.jiuling.comparesystem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jiuling.comparesystem.dao.VideoDao;
import cn.jiuling.comparesystem.model.Video;
import cn.jiuling.comparesystem.service.VideoService;
import cn.jiuling.comparesystem.vo.Pager;

@Service("videoService")
public class VideoServiceImpl implements VideoService {

	@Resource
	private VideoDao videoDao;

	@Override
	public Pager list(Video v, Integer page, Integer rows) {
		return videoDao.list(v, page, rows);
	}

	@Override
	public void save(Video v) {
		videoDao.save(v);
	}

	@Override
	public void update(Video v) {
		videoDao.update(v);
	}
	
	@Override
	public void delete(Integer[] ids) {
		for (int i = 0; i < ids.length; i++) {
			Video v = videoDao.find(ids[i]);
			videoDao.delete(v);
		}
	}

	@Override
	public Video findById(Integer id) {
		return videoDao.find(id);
	}

}
