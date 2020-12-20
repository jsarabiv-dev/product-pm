package com.pm.product.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.product.dao.ProductDAOImpl;
import com.pm.product.dao.repository.ProductFlashOffertRepository;
import com.pm.product.dao.repository.ProductRepository;
import com.pm.product.model.ProductEntity;
import com.pm.product.model.ProductFlashOffert;



@Service
public class ProductServiceImpls implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductFlashOffertRepository productFlashOffertRepository;
	
	@Autowired
	ProductDAOImpl productDAO;
	
	@Autowired
	TransversalService transversalService;
	
	
	
	@Override
	public List<ProductEntity> findAll() {
		List<ProductEntity> listProducts = new ArrayList<>();
		listProducts = productRepository.findAll();
		listProducts = this.deleteCategoryRecursive(listProducts);
		return transversalService.calculateFees(listProducts);
	}
	
	@Override
	public List<ProductEntity> getProductsOffertToWeek() {
		List<ProductEntity> listProducts = new ArrayList<>();
		listProducts = productRepository.getProductsOffertToWeek();
		listProducts = this.deleteCategoryRecursive(listProducts);
		return transversalService.calculateFees(listProducts);
	}

	@Override
	public ProductEntity findById(Long id) {
		List<ProductEntity> listProducts = new ArrayList<>();
		listProducts.add(productRepository.findById(id).orElse(null));
		listProducts = this.deleteCategoryRecursive(listProducts);
		return transversalService.calculateFees(listProducts).get(0);
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
		products = this.deleteCategoryRecursive(products);
		return transversalService.calculateFees(products);
	}

	
	@Override
	public List<ProductFlashOffert> prueba() {
		return productFlashOffertRepository.findAll();
	}

	@Override
	public List<ProductEntity> deleteCategoryRecursive(List<ProductEntity> listProducts) {

		listProducts.forEach( p -> {
        	p.getCategoryProduct().setProducts(null);
        	p.getPrecioCuota();
        });
		
		return listProducts;
	}
	
}
