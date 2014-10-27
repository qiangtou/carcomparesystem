package cn.jiuling.comparesystem.vo;

import org.codehaus.jackson.annotate.JsonIgnore;

public class SeriesVo {
	private Integer id;
	private Integer brandId;
	private String name;
	private String sName;

	@JsonIgnore
	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	private String brandName;

	public Integer getId() {
		return id;
	}

	@JsonIgnore
	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	@JsonIgnore
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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

	public SeriesVo(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public SeriesVo() {
		super();
	}

	public SeriesVo(Integer id, Integer brandId, String name, String sName, String brandName) {
		super();
		this.id = id;
		this.brandId = brandId;
		this.name = name;
		this.sName = sName;
		this.brandName = brandName;
	}

}
