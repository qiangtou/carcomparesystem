package cn.jiuling.comparesystem.web;

import java.io.StringWriter;
import java.io.Writer;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.jiuling.comparesystem.model.Pic;
import cn.jiuling.comparesystem.service.PicService;
import cn.jiuling.comparesystem.service.VideoService;

@Controller
@RequestMapping("pic")
public class PicController extends BaseController{

	@Resource
	private PicService picService;
	@Resource
	private VideoService videoService;
	
	@RequestMapping(value = "add.action")
	@ResponseBody
	public String add(MultipartFile file,Integer id) throws Exception {
		if (file!=null && !file.isEmpty()) {
			if(file.getContentType().contains("image")) {
				Pic pic = picService.upload(file);
				pic.setVideo(videoService.findById(id));
				
				Writer out = new StringWriter();
				ObjectMapper m = new ObjectMapper();
				JsonGenerator g = m.getJsonFactory().createJsonGenerator(out);
				g.writeObject(pic);
				
				return out.toString();
			}
			return "typeError";
		}
		return "fail";
	}
	
}
