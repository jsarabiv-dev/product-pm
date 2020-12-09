package com.pm.product.dao;

import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pm.product.dao.repository.CategoryProductRepository;
import com.pm.product.dao.repository.ProductRepository;
import com.pm.product.dao.repository.PymeUserProfileRepository;
import com.pm.product.model.CategoryProductEntity;
import com.pm.product.model.ProductEntity;
import com.pm.product.model.PymeUserProfileEntity;

@Repository
public class ProductDAOImpl implements IProductDAO {
	
	@Autowired
	private ProductRepository productRepository;
	
	@PersistenceContext
	private EntityManager em;


	@Override
	@Transactional
	public List<ProductEntity> getProductsOffertToWeek() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@Transactional
	public List<ProductEntity> getProductsOffTheDay() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ProductEntity> getProductsWhitCriteria() {
		
	
		return null;
	}

	

}
	



































