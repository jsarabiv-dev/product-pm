package com.pm.product.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pm.product.model.ProductEntity;
import com.pm.product.model.ProductFlashOffert;

public interface ProductFlashOffertRepository extends JpaRepository<ProductFlashOffert, Long> {

	List<ProductFlashOffert> findByProduct(ProductEntity product);

	@Query(value = "SELECT product_flash_offert.*  FROM product_flash_offert JOIN product ON product_flash_offert.Pfo_Product_Id = product.Product_Id JOIN category_product ON category_product.CatProd_Id = product.Product_CatProd_Id WHERE category_product.CatProd_Name LIKE %?1%", nativeQuery = true)
	public List<ProductFlashOffert> findByProductCategory(String name);

}
