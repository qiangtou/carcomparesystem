package cn.jiuling.comparesystem.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Car entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "car")
public class Car implements java.io.Serializable {

	// Fields

	private Integer id;
	private Series series;
	private String name;
	private Short structure;
	private Short level;
	private Integer seatNum;
	private Integer sideDoorNum;
	private Short openType;
	private Integer price;
	private Integer year;
	private String extendProperty;
	private Set<Carpic> carpics = new HashSet<Carpic>(0);

	// Constructors

	/** default constructor */
	public Car() {
	}

	/** minimal constructor */
	public Car(String name) {
		this.name = name;
	}

	/** full constructor */
	public Car(Series series, String name, Short structure, Short level, Integer seatNum, Integer sideDoorNum, Short openType, Integer price, Integer year,
			String extendProperty, Set<Carpic> carpics) {
		this.series = series;
		this.name = name;
		this.structure = structure;
		this.level = level;
		this.seatNum = seatNum;
		this.sideDoorNum = sideDoorNum;
		this.openType = openType;
		this.price = price;
		this.year = year;
		this.extendProperty = extendProperty;
		this.carpics = carpics;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "seriesId")
	public Series getSeries() {
		return this.series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "structure")
	public Short getStructure() {
		return this.structure;
	}

	public void setStructure(Short structure) {
		this.structure = structure;
	}

	@Column(name = "level")
	public Short getLevel() {
		return this.level;
	}

	public void setLevel(Short level) {
		this.level = level;
	}

	@Column(name = "seatNum")
	public Integer getSeatNum() {
		return this.seatNum;
	}

	public void setSeatNum(Integer seatNum) {
		this.seatNum = seatNum;
	}

	@Column(name = "sideDoorNum")
	public Integer getSideDoorNum() {
		return this.sideDoorNum;
	}

	public void setSideDoorNum(Integer sideDoorNum) {
		this.sideDoorNum = sideDoorNum;
	}

	@Column(name = "openType")
	public Short getOpenType() {
		return this.openType;
	}

	public void setOpenType(Short openType) {
		this.openType = openType;
	}

	@Column(name = "price")
	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "year")
	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Column(name = "extendProperty", length = 500)
	public String getExtendProperty() {
		return this.extendProperty;
	}

	public void setExtendProperty(String extendProperty) {
		this.extendProperty = extendProperty;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "car")
	public Set<Carpic> getCarpics() {
		return this.carpics;
	}

	public void setCarpics(Set<Carpic> carpics) {
		this.carpics = carpics;
	}

}