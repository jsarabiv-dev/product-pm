package com.pm.product.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "Product_Id")
	private Long productId;
	
	@ManyToOne
	@JoinColumn( name = "product_pymeprof_id" )
	private PymeUserProfileEntity pymeUserProfile;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name ="product_catprod_id")
	private CategoryProductEntity categoryProduct;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_description")
	private String productDescription;
	
	@Column(name = "product_img_url")
	private String productImgUrl;
	
	@Column(name = "product_search_url")
	private String productSearchUrl;
	
	@Column(name = "product_unit_price")
	private Float productUnitPrice;
	
	@Column(name = "product_offer")
	private Float productOffer;
	
	@Column(name = "product_date_created")
	private Date productDateCreated;
	
	@Column(name = "product_last_update")
	private Date productLastUpdate;

	@Column(name = "Product_Is_Free_Shipping")
	private Boolean productIsFreeShipping;
	
	@Transient
	private Float precioCuota = 0f;
	
	@Transient
	private int cuotas = 0;
	
	/* Getters and Setters*/

	public Long getProduct_Id() {
		return productId;
	}

	public void setProduct_Id(Long product_Id) {
		productId = product_Id;
	}

	public PymeUserProfileEntity getPymeUserProfile() {
		return pymeUserProfile;
	}

	public void setPymeUserProfile(PymeUserProfileEntity pymeUserProfile) {
		this.pymeUserProfile = pymeUserProfile;
	}

	public CategoryProductEntity getCategoryProduct() {
		return categoryProduct;
	}

	public void setCategoryProduct(CategoryProductEntity categoryProduct) {
		this.categoryProduct = categoryProduct;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImgUrl() {
		return productImgUrl;
	}

	public void setProductImgUrl(String productImgUrl) {
		this.productImgUrl = productImgUrl;
	}

	public String getProductSearchUrl() {
		return productSearchUrl;
	}

	public void setProductSearchUrl(String productSearchUrl) {
		this.productSearchUrl = productSearchUrl;
	}

	public Float getProductUnitPrice() {
		return productUnitPrice;
	}

	public void setProductUnitPrice(Float productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}

	public Float getProductOffer() {
		return productOffer;
	}

	public void setProductOffer(Float productOffer) {
		this.productOffer = productOffer;
	}

	public Date getProductDateCreated() {
		return productDateCreated;
	}

	public void setProductDateCreated(Date productDateCreated) {
		this.productDateCreated = productDateCreated;
	}

	public Date getProductLastUpdate() {
		return productLastUpdate;
	}

	public void setProductLastUpdate(Date productLastUpdate) {
		this.productLastUpdate = productLastUpdate;
	}

	public Boolean getProductIsFreeShipping() {
		return productIsFreeShipping;
	}

	public void setProductIsFreeShipping(Boolean productIsFreeShipping) {
		this.productIsFreeShipping = productIsFreeShipping;
	}

	public ProductEntity(PymeUserProfileEntity pymeUserProfile, CategoryProductEntity categoryProduct,
			String productName, String productDescription, String productImgUrl, String productSearchUrl,
			Float productUnitPrice, Float productOffer, Date productDateCreated, Date productLastUpdate,
			Boolean productIsFreeShipping) {
		super();
		this.pymeUserProfile = pymeUserProfile;
		this.categoryProduct = categoryProduct;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productImgUrl = productImgUrl;
		this.productSearchUrl = productSearchUrl;
		this.productUnitPrice = productUnitPrice;
		this.productOffer = productOffer;
		this.productDateCreated = productDateCreated;
		this.productLastUpdate = productLastUpdate;
		this.productIsFreeShipping = productIsFreeShipping;
	}
	
	public ProductEntity() {
		super();
	}

	public void getPrecioCuota() {
		this.cuotas = productUnitPrice> 800000f ? 10 : 6;
		this.precioCuota = productUnitPrice / cuotas;
	}

	public void setPrecioCuota(Float precioCuota) {
		this.precioCuota = precioCuota;
	}

	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", pymeUserProfile=" + pymeUserProfile + ", categoryProduct="
				+ categoryProduct + ", productName=" + productName + ", productDescription=" + productDescription
				+ ", productImgUrl=" + productImgUrl + ", productSearchUrl=" + productSearchUrl + ", productUnitPrice="
				+ productUnitPrice + ", productOffer=" + productOffer + ", productDateCreated=" + productDateCreated
				+ ", productLastUpdate=" + productLastUpdate + ", productIsFreeShipping=" + productIsFreeShipping
				+ ", precioCuota=" + precioCuota + ", cuotas=" + cuotas + "]";
	}


	
	


	
	
}
