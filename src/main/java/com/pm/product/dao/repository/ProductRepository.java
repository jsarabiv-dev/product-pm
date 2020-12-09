package com.pm.product.dao.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pm.product.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

	  @Query(value = "SELECT * FROM product WHERE WEEK(Product_Last_Update) = WEEK(NOW()) AND  Product_Offer  > 0", nativeQuery = true)
	  List<ProductEntity> getProductsOffertToWeek();
	  
	  @Query(value = "SELECT * FROM product WHERE DAY(Product_Last_Update) = DAY(NOW())", nativeQuery = true)
	  List<ProductEntity> getProductsOffTheDay();
	  
	  List<ProductEntity> findTop2ByOrderByProductIdDesc();
	
}
