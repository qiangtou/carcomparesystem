package cn.jiuling.comparesystem.utils.autohome;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

public @JsonIgnoreProperties(ignoreUnknown = true)
class CarType {
	private Integer I;
	private String N;
	private String L;
	private Integer P;
	private List<CarType> List;

	@JsonProperty("I")
	public Integer getI() {
		return I;
	}

	@JsonProperty("P")
	public Integer getP() {
		return P;
	}

	public void setP(Integer p) {
		P = p;
	}

	public void setI(Integer i) {
		I = i;
	}

	@JsonProperty("N")
	public String getN() {
		return N;
	}

	public void setN(String n) {
		N = n;
	}

	@JsonProperty("List")
	public List<CarType> getList() {
		return List;
	}

	public void setList(List<CarType> list) {
		List = list;
	}

	@JsonProperty("L")
	public String getL() {
		return L;
	}

	public void setL(String l) {
		L = l;
	}

}