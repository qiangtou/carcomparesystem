package cn.jiuling.comparesystem.vo;

public class CarTypeVo extends CarVo {
	private Integer brandId;
	private Short level;
	private Short structure;
	private String seriesName;
	private String brandName;

	private Integer sideDoorNum;
	private Integer seatNum;
	private Short openType;
	private String extendProperty;

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public CarTypeVo() {
		super();
	}

	public Short getLevel() {
		return level;
	}

	public void setLevel(Short level) {
		this.level = level;
	}

	public Short getStructure() {
		return structure;
	}

	public void setStructure(Short structure) {
		this.structure = structure;
	}

	public Integer getSideDoorNum() {
		return sideDoorNum;
	}

	public void setSideDoorNum(Integer sideDoorNum) {
		this.sideDoorNum = sideDoorNum;
	}

	public Integer getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(Integer seatNum) {
		this.seatNum = seatNum;
	}

	public Short getOpenType() {
		return openType;
	}

	public void setOpenType(Short openType) {
		this.openType = openType;
	}

	public String getExtendProperty() {
		return extendProperty;
	}

	public void setExtendProperty(String extendProperty) {
		this.extendProperty = extendProperty;
	}

	public CarTypeVo(Integer seriesId, Integer id, String name, Integer year, Integer price, Integer brandId, Short level, Short structure, String seriesName,
			String brandName, Integer sideDoorNum, Integer seatNum, Short openType, String extendProperty) {
		super(seriesId, id, name, year, price);
		this.brandId = brandId;
		this.level = level;
		this.structure = structure;
		this.seriesName = seriesName;
		this.brandName = brandName;
		this.sideDoorNum = sideDoorNum;
		this.seatNum = seatNum;
		this.openType = openType;
		this.extendProperty = extendProperty;
	}

}
