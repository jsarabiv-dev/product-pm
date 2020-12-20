package com.pm.product.dao;

import java.util.List;

import com.pm.product.model.CategoryProductEntity;

public interface ICategoryProductDAO {
	
	public List<CategoryProductEntity> discover();
	
}
