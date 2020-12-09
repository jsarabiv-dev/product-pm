package com.pm.product.dao;

import java.util.List;


import com.pm.product.model.ProductEntity;

public interface IProductDAO{

	  List<ProductEntity> getProductsOffertToWeek();
	  List<ProductEntity> getProductsOffTheDay();
	  List<ProductEntity> getProductsWhitCriteria();
	  
	  
}
