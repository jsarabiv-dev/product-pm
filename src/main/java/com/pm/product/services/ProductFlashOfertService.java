package com.pm.product.services;

import java.util.List;

import com.pm.product.model.ProductEntity;
import com.pm.product.model.ProductFlashOffert;

public interface ProductFlashOfertService {
	
	public List<ProductFlashOffert> findAll();
	public List<ProductFlashOffert> findByProduct(Long id);
	public List<ProductFlashOffert> findByProductCategoryName(String name);
	public ProductFlashOffert save(ProductFlashOffert flashOffert);
	public void deleteById(Long id);
}
