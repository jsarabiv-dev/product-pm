package com.pm.product.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pm.product.model.CategoryProductEntity;

public interface CategoryProductRepository extends JpaRepository<CategoryProductEntity, Long> {

}
