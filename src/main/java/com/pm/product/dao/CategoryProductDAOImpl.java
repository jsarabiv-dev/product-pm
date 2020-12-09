package com.pm.product.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pm.product.dao.repository.CategoryProductRepository;
import com.pm.product.model.ProductEntity;

@Repository
public class CategoryProductDAOImpl {

	private List<ProductEntity> products = new ArrayList<>();
	
	@Autowired
	private CategoryProductRepository categoryProductRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	public List<ProductEntity> prueba() {
		
		
		return null;
	}
	
}
