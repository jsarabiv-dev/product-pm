package com.pm.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.product.dao.ProductDAOImpl;
import com.pm.product.dao.repository.ProductRepository;
import com.pm.product.model.ProductEntity;



@Service
public class ProductServiceImpls implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductDAOImpl productDAO;
	
	@Override
	public List<ProductEntity> findAll() {
		return productRepository.findAll();
	}
	
	@Override
	public List<ProductEntity> getProductsOffertToWeek() {
		return productRepository.getProductsOffertToWeek();
	}

	@Override
	public ProductEntity findById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public ProductEntity save(ProductEntity productGeneral) {
		return productRepository.save(productGeneral);
	}

	@Override
	public void deleteById(Long id) {
		 productRepository.deleteById(id);
	}

	@Override
	public List<ProductEntity> productsDiscover() {
		
		List<ProductEntity> products = productRepository.findTop2ByOrderByProductIdDesc();
		return products;
	}

	
	@Override
	public List<ProductEntity> prueba() {
		return productDAO.getProductsWhitCriteria();
	}
	
}
