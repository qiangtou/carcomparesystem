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
 * Series entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "series", catalog = "carcomparesystem")
public class Series implements java.io.Serializable {

	// Fields

	private Integer id;
	private Brand brand;
	private String name;
	private String brandName;
	private Set<Car> cars = new HashSet<Car>(0);

	// Constructors

	/** default constructor */
	public Series() {
	}

	/** minimal constructor */
	public Series(Brand brand, String name) {
		this.brand = brand;
		this.name = name;
	}

	/** full constructor */
	public Series(Brand brand, String name, String brandName, Set<Car> cars) {
		this.brand = brand;
		this.name = name;
		this.brandName = brandName;
		this.cars = cars;
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
	@JoinColumn(name = "brandId", nullable = false)
	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "brandName", length = 50)
	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "series")
	public Set<Car> getCars() {
		return this.cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

}