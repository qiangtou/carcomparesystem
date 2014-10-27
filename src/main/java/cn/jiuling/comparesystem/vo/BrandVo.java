package cn.jiuling.comparesystem.vo;

import java.util.ArrayList;
import java.util.List;

public class BrandVo {
	private Integer id;
	private String name;
	private String sName;
	private List<SeriesVo> series = new ArrayList<SeriesVo>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SeriesVo> getSeries() {
		return series;
	}

	public void setSeries(List<SeriesVo> series) {
		this.series = series;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}
}
