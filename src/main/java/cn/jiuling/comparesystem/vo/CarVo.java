package cn.jiuling.comparesystem.vo;

public class CarVo {
	private Integer seriesId;
	private String name;
	private Integer year;
	private Integer price;

	public Integer getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public CarVo(Integer seriesId, String name, Integer year, Integer price) {
		super();
		this.seriesId = seriesId;
		this.name = name;
		this.year = year;
		this.price = price;
	}

	public CarVo() {
		super();
	}

}
