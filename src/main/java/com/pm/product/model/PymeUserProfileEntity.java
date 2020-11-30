package com.pm.product.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pyme_profile")
public class PymeUserProfileEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pymeprof_id")
	private Long pymeId;
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pymeUserProfile")
//	@Column(name = "products")
//	private Set<ProductEntity> products;
	
	@Column(name = "pymeprof_name")
	private String pymeName;
	
	@Column(name = "pymeprof_tags")
	private String pymeTags;
	
	@Column(name = "pymeprof_icon_url")
	private String pymeIconUrl;
	
	@Column(name = "pymeprof_img_url")
	private String pymeImgUrl;
	
	@Column(name = "pymeprof_search_url")
	private String pymeSearchUrl;

	
	/* Getters and Setters*/
	
	public Long getPymeId() {
		return pymeId;
	}

	public void setPymeId(Long pymeId) {
		this.pymeId = pymeId;
	}

	public String getPymeName() {
		return pymeName;
	}

	public void setPymeName(String pymeName) {
		this.pymeName = pymeName;
	}

	public String getPymeTags() {
		return pymeTags;
	}

	public void setPymeTags(String pymeTags) {
		this.pymeTags = pymeTags;
	}

	public String getPymeIconUrl() {
		return pymeIconUrl;
	}

	public void setPymeIconUrl(String pymeIconUrl) {
		this.pymeIconUrl = pymeIconUrl;
	}

	public String getPymeImgUrl() {
		return pymeImgUrl;
	}

	public void setPymeImgUrl(String pymeImgUrl) {
		this.pymeImgUrl = pymeImgUrl;
	}

	public String getPymeSearchUrl() {
		return pymeSearchUrl;
	}

	public void setPymeSearchUrl(String pymeSearchUrl) {
		this.pymeSearchUrl = pymeSearchUrl;
	}
	

	
	

}
