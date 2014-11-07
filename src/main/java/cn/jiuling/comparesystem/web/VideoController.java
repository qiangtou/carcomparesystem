package cn.jiuling.comparesystem.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiuling.comparesystem.model.Video;
import cn.jiuling.comparesystem.service.VideoService;

@Controller
@RequestMapping("video")
public class VideoController extends BaseController {

	@Resource
	private VideoService videoService;

	@RequestMapping("index.action")
	public void index() {
	}

	@RequestMapping("list.action")
	@ResponseBody
	public Object list(Video v,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows) {
		return videoService.list(v, page, rows);
	}

	@RequestMapping("add.action")
	public void add(Video v) {
		videoService.save(v);
	}

	@RequestMapping("update.action")
	public void update(Video v) {
		videoService.update(v);
	}

	@RequestMapping("delete.action")
	public void delete(Integer[] ids) {
		videoService.delete(ids);
	}

}
