package com.pm.product.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_flash_offert")
public class ProductFlashOffert {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "Pfo_id")
	private Long pfo_id;
	
	@ManyToOne
	@JoinColumn( name = "Pfo_Product_Id" )
	private ProductEntity product;
	
	private Integer Pfo_Offert;
	
	private LocalDateTime Pfo_Date_Created;
	
	private LocalDateTime Pfo_Date_Until;
	
	private Integer Pfo_Status;

	public Long getPfo_id() {
		return pfo_id;
	}

	public void setPfo_id(Long pfo_id) {
		this.pfo_id = pfo_id;
	}

	public Integer getPfo_Offert() {
		return Pfo_Offert;
	}

	public void setPfo_Offert(Integer pfo_Offert) {
		Pfo_Offert = pfo_Offert;
	}

	public LocalDateTime getPfo_Date_Created() {
		return Pfo_Date_Created;
	}

	public void setPfo_Date_Created(LocalDateTime pfo_Date_Created) {
		Pfo_Date_Created = pfo_Date_Created;
	}

	public LocalDateTime getPfo_Date_Until() {
		return Pfo_Date_Until;
	}

	public void setPfo_Date_Until(LocalDateTime pfo_Date_Until) {
		Pfo_Date_Until = pfo_Date_Until;
	}

	public Integer getPfo_Status() {
		return Pfo_Status;
	}

	public void setPfo_Status(Integer pfo_Status) {
		Pfo_Status = pfo_Status;
	}

	public ProductFlashOffert(Long pfo_id, ProductEntity product, Integer pfo_Offert, LocalDateTime pfo_Date_Created,
			LocalDateTime pfo_Date_Until, Integer pfo_Status) {
		super();
		this.pfo_id = pfo_id;
		this.product = product;
		Pfo_Offert = pfo_Offert;
		Pfo_Date_Created = pfo_Date_Created;
		Pfo_Date_Until = pfo_Date_Until;
		Pfo_Status = pfo_Status;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public ProductFlashOffert() {
		super();
	}


	

}
