package cn.jiuling.comparesystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Carpic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "carpic")
public class Carpic implements java.io.Serializable {

	// Fields

	private Integer id;
	private Car car;
	private Short color;
	private String picUrl;

	// Constructors

	/** default constructor */
	public Carpic() {
	}

	/** minimal constructor */
	public Carpic(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Carpic(Integer id, Car car, Short color, String picUrl) {
		this.id = id;
		this.car = car;
		this.color = color;
		this.picUrl = picUrl;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typeId")
	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Column(name = "color")
	public Short getColor() {
		return this.color;
	}

	public void setColor(Short color) {
		this.color = color;
	}

	@Column(name = "picUrl", length = 100)
	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

}