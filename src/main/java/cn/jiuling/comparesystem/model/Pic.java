package cn.jiuling.comparesystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Pic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pic")
public class Pic implements java.io.Serializable {

	// Fields

	private Integer id;
	private Video video;
	private String name;
	private String url;
	private Short isShow;

	// Constructors

	/** default constructor */
	public Pic() {
	}

	/** full constructor */
	public Pic(Integer id, Video video, String name, String url, Short isShow) {
		this.id = id;
		this.video = video;
		this.name = name;
		this.url = url;
		this.isShow = isShow;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "videoId", nullable = false)
	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	@Column(name = "name", nullable = false, length = 22)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "url", nullable = false)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "isShow", nullable = false)
	public Short getIsShow() {
		return this.isShow;
	}

	public void setIsShow(Short isShow) {
		this.isShow = isShow;
	}

}