package com.pm.product.services;

import java.util.List;

import com.pm.product.model.CategoryProductEntity;


public interface CategoryProductService {
	
	
	public List<CategoryProductEntity> findAll();
	public CategoryProductEntity findById(Long id);
	public CategoryProductEntity save(CategoryProductEntity category);
	public void deleteById(Long id);
	public List<CategoryProductEntity> discover();

}
