package com.pm.product.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category_product")
public class CategoryProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "catprod_id")
	private Long catProd_Id;
	
	@OneToMany(mappedBy = "categoryProduct", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}) 
	@JsonIgnore
	private List<ProductEntity> products;
	// Solo asumira una operacion de cascada para persistir y eliminar los productos
	// Si creas una categoria nueva y le agregas libros y luego la persistes, se persistiran igualmente los libros
	
	@Column(name = "catprod_subcat_id")
	private Integer catProd_SubCat_Id;
	
	@Column(name = "catprod_name")
	private String catProd_name;
	
	@Column(name = "catprod_icon_url")
	private String icon;
	
	@Column(name = "catprod_search_url")
	private String searchUrl;
	
	@Column(name = "catprod_created")
	private LocalDateTime catprod_created;
	
	public CategoryProductEntity(Long catProd_Id, List<ProductEntity> products, Integer catProd_SubCat_Id,
			String catProd_name, String icon, String searchUrl, LocalDateTime catprod_created,
			LocalDateTime catprod_updated) {
		super();
		this.catProd_Id = catProd_Id;
		this.products = products;
		this.catProd_SubCat_Id = catProd_SubCat_Id;
		this.catProd_name = catProd_name;
		this.icon = icon;
		this.searchUrl = searchUrl;
		this.catprod_created = catprod_created;
		this.catprod_updated = catprod_updated;
	}

	@Column(name = "catprod_updated")
	private LocalDateTime catprod_updated;
	
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

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public void addProduct(ProductEntity product) {
		product.setCategoryProduct(this);
		this.products.add(product);
	}
	
	public CategoryProductEntity() {
		super();
	}

	public LocalDateTime getCatprod_created() {
		return catprod_created;
	}

	public void setCatprod_created(LocalDateTime catprod_created) {
		this.catprod_created = catprod_created;
	}

	public LocalDateTime getCatprod_updated() {
		return catprod_updated;
	}

	public void setCatprod_updated(LocalDateTime catprod_updated) {
		this.catprod_updated = catprod_updated;
	}





	

}
