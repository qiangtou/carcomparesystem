package cn.jiuling.comparesystem.vo;

import java.util.Arrays;

public class CarQuery {
	private Short structure;
	private Short seatNum;
	private Short sideDoorNum;
	private Short openType;
	private Short[] level;

	public Short getStructure() {
		return structure;
	}

	public void setStructure(Short structure) {
		this.structure = structure;
	}

	public Short getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(Short seatNum) {
		this.seatNum = seatNum;
	}

	public Short getSideDoorNum() {
		return sideDoorNum;
	}

	public void setSideDoorNum(Short sideDoorNum) {
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
