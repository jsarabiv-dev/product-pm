package com.pm.product.services;

import java.util.List;

import com.pm.product.model.ProductEntity;

public interface ProductService {
	
	public List<ProductEntity> findAll();
	public List<ProductEntity> getProductsOffertToWeek();
	public ProductEntity findById(Long id);
	public ProductEntity save(ProductEntity productGeneral);
	public void deleteById(Long id);
	public List<ProductEntity> productsDiscover();
	public List<ProductEntity> deleteCategoryRecursive(List<ProductEntity> listProducts);
	
	public List<ProductEntity> prueba();
	/*
	public List<ProductEntity> findByCategoryId(Long categoryId);
	public List<ProductEntity> findByName(String name);
	
	*/

}
