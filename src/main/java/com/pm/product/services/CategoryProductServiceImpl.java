package com.pm.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.product.dao.ICategoryProductDAO;
import com.pm.product.dao.repository.CategoryProductRepository;
import com.pm.product.model.CategoryProductEntity;


@Service
public class CategoryProductServiceImpl implements CategoryProductService{

	@Autowired
	CategoryProductRepository categoryProductRepository;
	
	@Autowired
	ICategoryProductDAO categoryProductDAO;
	
	@Override
	public List<CategoryProductEntity> findAll() {
		return categoryProductRepository.findAll();
	}

	@Override
	public CategoryProductEntity findById(Long id) {
		return categoryProductRepository.findById(id).orElse(null);
	}

	@Override
	public CategoryProductEntity save(CategoryProductEntity category) {
		return categoryProductRepository.save(category);
	}

	@Override
	public void deleteById(Long id) {
		categoryProductRepository.deleteById(id);
	}

	@Override
	public List<CategoryProductEntity> discover() {
		// TODO Auto-generated method stub
		return categoryProductDAO.discover();
	}

}
