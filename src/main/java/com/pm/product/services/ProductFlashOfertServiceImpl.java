package com.pm.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.product.dao.repository.ProductFlashOffertRepository;
import com.pm.product.model.CategoryProductEntity;
import com.pm.product.model.ProductEntity;
import com.pm.product.model.ProductFlashOffert;

@Service
public class ProductFlashOfertServiceImpl implements ProductFlashOfertService{

	@Autowired
	ProductFlashOffertRepository productFlashOffertRepository;
	
	@Override
	public List<ProductFlashOffert> findAll() {
		return productFlashOffertRepository.findAll();
	}

	@Override
	public List<ProductFlashOffert> findByProduct(Long id) {
		ProductEntity product = new ProductEntity();
		product.setProduct_Id(id);
		return productFlashOffertRepository.findByProduct(product);
	}
	
	@Override
	public List<ProductFlashOffert> findByProductCategoryName(String name) {
		return productFlashOffertRepository.findByProductCategory(name);
	}

	@Override
	public ProductFlashOffert save(ProductFlashOffert flashOffert) {
		return productFlashOffertRepository.save(flashOffert);
	}

	@Override
	public void deleteById(Long id) {
		productFlashOffertRepository.deleteById(id);
	}


}
