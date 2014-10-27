package cn.jiuling.comparesystem.vo;

import java.util.Arrays;

public class CarQuery {
	private Short structure;
	private Integer seatNum;
	private Integer sideDoorNum;
	private Short openType;
	private Short[] level;

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

}
