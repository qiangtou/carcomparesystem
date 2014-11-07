package cn.jiuling.comparesystem.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Video entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "video")
public class Video implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String url;
	private Set<Pic> pics;

	// Constructors

	/** default constructor */
	public Video() {
	}

	/** minimal constructor */
	public Video(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public Video(Integer id, String name, String url, Set<Pic> pics) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.pics = pics;
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

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "url", length = 100)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "video")
	public Set<Pic> getPics() {
		return this.pics;
	}

	public void setPics(Set<Pic> pics) {
		this.pics = pics;
	}

}