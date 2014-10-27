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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Brand entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "brand")
public class Brand implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String shortName;
	private Set<Series> serieses = new HashSet<Series>(0);

	// Constructors

	/** default constructor */
	public Brand() {
	}

	/** minimal constructor */
	public Brand(String name, String shortName) {
		this.name = name;
		this.shortName = shortName;
	}

	/** full constructor */
	public Brand(String name, String shortName, Set<Series> serieses) {
		this.name = name;
		this.shortName = shortName;
		this.serieses = serieses;
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

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "shortName", nullable = false, length = 10)
	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "brand")
	public Set<Series> getSerieses() {
		return this.serieses;
	}

	public void setSerieses(Set<Series> serieses) {
		this.serieses = serieses;
	}

}