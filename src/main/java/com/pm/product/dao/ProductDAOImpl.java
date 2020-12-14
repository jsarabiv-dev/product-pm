package com.pm.product.dao;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.pm.product.dao.repository.ProductRepository;
import com.pm.product.model.ProductEntity;

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
