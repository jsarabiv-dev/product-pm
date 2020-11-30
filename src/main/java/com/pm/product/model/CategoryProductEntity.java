package com.pm.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category_product")
public class CategoryProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "catprod_id")
	private Long catProd_Id;
	
	@Column(name = "catprod_subcat_id")
	private Integer catProd_SubCat_Id;
	
	@Column(name = "catprod_name")
	private String catProd_name;
	
	
	@Column(name = "catprod_icon_url")
	private String icon;
	
	@Column(name = "catprod_search_url")
	private String searchUrl;
	
	//TODO: Crear modo para obtener las categorias mas compradas
	
	
	/* Getters and Setters*/

	public Long getCatProd_Id() {
		return catProd_Id;
	}

	public void setCatProd_Id(Long catProd_Id) {
		this.catProd_Id = catProd_Id;
	}

	public String getCatProd_name() {
		return catProd_name;
	}

	public void setCatProd_name(String catProd_name) {
		this.catProd_name = catProd_name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getSearchUrl() {
		return searchUrl;
	}

	public void setSearchUrl(String searchUrl) {
		this.searchUrl = searchUrl;
	}


	

}
