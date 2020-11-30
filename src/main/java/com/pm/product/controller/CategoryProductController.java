package com.pm.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.product.model.CategoryProductEntity;
import com.pm.product.services.CategoryProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/category-products")
public class CategoryProductController {

	@Autowired
	CategoryProductService categoryProductService;
	
	@GetMapping("/find-all")
	public ResponseEntity<List<CategoryProductEntity>>findAll(){
		List<CategoryProductEntity> listProducts = categoryProductService.findAll();
        if(listProducts.isEmpty()) {
        	return new ResponseEntity<List<CategoryProductEntity>>(listProducts, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CategoryProductEntity>>(listProducts, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> finByIdl(@PathVariable Long id){
		CategoryProductEntity categoryProduct = null;
		Map<String, Object> response = new HashMap<>();
		try {
			categoryProduct = categoryProductService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(categoryProduct == null) {
			response.put("mensaje", "El Producto ID: ".concat((id.toString().concat(" no existe en la base de datos!"))));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CategoryProductEntity>(categoryProduct, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody CategoryProductEntity category){
		CategoryProductEntity categoryProduct = null;
		Map<String, Object> response = new HashMap<>();
		try {
			categoryProduct = categoryProductService.save(category);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el save en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La categoria ha sido creado con exito!");
		response.put("cliente", categoryProduct);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<?>  edit(@RequestBody CategoryProductEntity category, @PathVariable Long id) {
		CategoryProductEntity categoryProductDB = null;
		CategoryProductEntity categoryProductUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			categoryProductDB =  categoryProductService.findById(id);
			if(categoryProductDB == null) {
				response.put("mensaje", "El Producto ID: ".concat((id.toString().concat(" no existe en la base de datos!"))));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			//TODO: Agregar metodo para mergear
			categoryProductDB.setCatProd_name(category.getCatProd_name());
			
			categoryProductUpdated = categoryProductService.save(categoryProductDB);
			
			response.put("mensaje", "La categoria ha sido actualizado con exito!");
			response.put("cliente", categoryProductUpdated);
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el update en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			categoryProductService.deleteById(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la categoria");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La categoria ha sido eliminado con exito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}
