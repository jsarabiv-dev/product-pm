package com.pm.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pm.product.model.ProductEntity;
import com.pm.product.model.ProductFlashOffert;
import com.pm.product.services.ProductFlashOfertService;

@Controller
@RequestMapping("/flash-ofert-products")
public class ProductFlashOffertController {
	
	@Autowired
	ProductFlashOfertService productFlashOfertService;
	
	@GetMapping("/find-all")
	public ResponseEntity<List<ProductFlashOffert>>findAll(){
	
		List<ProductFlashOffert> listProducts = productFlashOfertService.findAll();
        if(listProducts.isEmpty()) {
        	return new ResponseEntity<List<ProductFlashOffert>>(listProducts, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ProductFlashOffert>>(listProducts, HttpStatus.OK);
	}
	

	@GetMapping("/find-by-product/{id}")
	public ResponseEntity<List<ProductFlashOffert>>findByProduct(@PathVariable Long id){
	
		List<ProductFlashOffert> productsFlashOffert = productFlashOfertService.findByProduct(id);
        if(productsFlashOffert.isEmpty()) {
        	return new ResponseEntity<List<ProductFlashOffert>>(productsFlashOffert, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ProductFlashOffert>>(productsFlashOffert, HttpStatus.OK);
	}
	

	@GetMapping("/find-by-category-name/{name}")
	public ResponseEntity<List<ProductFlashOffert>>findCatName(@PathVariable String name){
	
		List<ProductFlashOffert> productsFlashOffert = productFlashOfertService.findByProductCategoryName(name);
        if(productsFlashOffert.isEmpty()) {
        	return new ResponseEntity<List<ProductFlashOffert>>(productsFlashOffert, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ProductFlashOffert>>(productsFlashOffert, HttpStatus.OK);
	}

}
