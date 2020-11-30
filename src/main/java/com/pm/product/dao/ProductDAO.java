package com.pm.product.dao;

import java.sql.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pm.product.model.ProductEntity;

@Repository
public class ProductDAO {
	
	private List<ProductEntity> products = new ArrayList<>();
	
	@Autowired
	private ProductRepository productRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void prueba() {
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		CriteriaQuery<ProductEntity> query= cb.createQuery(ProductEntity.class);
//		Root<ProductEntity> root = query.from(ProductEntity.class);
//		
		
		
		List<ProductEntity> product = productRepository.findTop2ByOrderByProductIdDesc();
		
		System.out.println(product.get(1).getProduct_Id());
		System.out.println();
		
	}
	
	
	

	}
	

