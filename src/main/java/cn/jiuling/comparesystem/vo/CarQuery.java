package cn.jiuling.comparesystem.vo;

import java.util.Arrays;

public class CarQuery {
	private Short structure;
	private Integer seatNum;
	private Integer sideDoorNum;
	private Short openType;
	private Short[] level;

	private Integer brandId;
	private Integer seriesId;
	private Integer carTypeId;

	public Short getStructure() {
		return structure;
	}

	public void setStructure(Short structure) {
		this.structure = structure;
	}

	public Integer getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(Integer seatNum) {
		this.seatNum = seatNum;
	}

	public Integer getSideDoorNum() {
		return sideDoorNum;
	}

	public void setSideDoorNum(Integer sideDoorNum) {
		this.sideDoorNum = sideDoorNum;
	}

	public Short getOpenType() {
		return openType;
	}

	public void setOpenType(Short openType) {
		this.openType = openType;
	}

	public Short[] getLevel() {
		return level;
	}

	public void setLevel(Short[] level) {
		this.level = level;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CarQuery [level=").append(Arrays.toString(level)).append(", openType=").append(openType).append(", seatNum=").append(seatNum).append(
				", sideDoorNum=").append(sideDoorNum).append(", structure=").append(structure).append("]");
		return builder.toString();
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public Integer getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}

	public Integer getCarTypeId() {
		return carTypeId;
	}

	public void setCarTypeId(Integer carTypeId) {
		this.carTypeId = carTypeId;
	}

}
