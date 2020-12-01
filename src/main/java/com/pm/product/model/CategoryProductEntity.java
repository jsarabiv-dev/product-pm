package com.pm.product.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "category_product")
public class CategoryProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "catprod_id")
	private Long catProd_Id;
	
	@OneToMany(mappedBy = "categoryProduct")
	private Set<ProductEntity> products;
	
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

	public Set<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductEntity> products) {
		this.products = products;
	}

	public CategoryProductEntity(Long catProd_Id, Set<ProductEntity> products, Integer catProd_SubCat_Id,
			String catProd_name, String icon, String searchUrl) {
		super();
		this.catProd_Id = catProd_Id;
		this.products = products;
		this.catProd_SubCat_Id = catProd_SubCat_Id;
		this.catProd_name = catProd_name;
		this.icon = icon;
		this.searchUrl = searchUrl;
	}

	@Override
	public String toString() {
		return "CategoryProductEntity [catProd_Id=" + catProd_Id + ", products=" + products + ", catProd_SubCat_Id="
				+ catProd_SubCat_Id + ", catProd_name=" + catProd_name + ", icon=" + icon + ", searchUrl=" + searchUrl
				+ "]";
	}


	

}
