package com.pm.product.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pm.product.dao.repository.CategoryProductRepository;
import com.pm.product.model.CategoryProductEntity;
import com.pm.product.model.ProductEntity;

@Repository
public class CategoryProductDAOImpl implements ICategoryProductDAO{

	@Autowired
	private CategoryProductRepository categoryProductRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	public List<ProductEntity> prueba() {
		
		
		return null;
	}
	
	@Override	
	public List<CategoryProductEntity> discover() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CategoryProductEntity> cq = cb.createQuery(CategoryProductEntity.class);
		Root<CategoryProductEntity> from = cq.from(CategoryProductEntity.class);
		cq.orderBy(cb.asc(from.get("catprod_created")));
		return em.createQuery(cq).setMaxResults(8).getResultList();
		}
	
}

























