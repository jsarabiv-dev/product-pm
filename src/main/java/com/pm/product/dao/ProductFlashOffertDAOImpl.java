package com.pm.product.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pm.product.dao.repository.CategoryProductRepository;
import com.pm.product.dao.repository.ProductFlashOffertRepository;
import com.pm.product.model.CategoryProductEntity;
import com.pm.product.model.ProductEntity;
import com.pm.product.model.ProductFlashOffert;

@Repository
public class ProductFlashOffertDAOImpl implements IProductFlashOffertDAO {

	@Autowired
	ProductFlashOffertRepository productFlashOffertRepository;

	@PersistenceContext
	private EntityManager em;
/*	
	@Override
	public List<ProductFlashOffert> findByProductCategory() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<ProductFlashOffert> query = cb.createQuery(ProductFlashOffert.class);
		Root<ProductFlashOffert> root = query.from(ProductFlashOffert.class);
	

		return null;
	}
*/
	


}
