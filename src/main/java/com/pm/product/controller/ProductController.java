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

import com.pm.product.model.ProductEntity;
import com.pm.product.model.ProductFlashOffert;
import com.pm.product.services.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/products")
public class ProductController {
	

	@Autowired
	ProductService productService;
	
	
	@GetMapping("/prueba")
	public ResponseEntity<List<ProductFlashOffert>>prueba(){
	
		List<ProductFlashOffert> listProducts = productService.prueba();
        if(listProducts.isEmpty()) {
        	return new ResponseEntity<List<ProductFlashOffert>>(listProducts, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ProductFlashOffert>>(listProducts, HttpStatus.OK);
	}
	
	
	@GetMapping("/find-all")
	public ResponseEntity<List<ProductEntity>>findAll(){
	
		List<ProductEntity> listProducts = productService.findAll();
        if(listProducts.isEmpty()) {
        	return new ResponseEntity<List<ProductEntity>>(listProducts, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ProductEntity>>(listProducts, HttpStatus.OK);
	}
	
	@GetMapping("/products-offer-week")
	public ResponseEntity<List<ProductEntity>>getProductsOffertToWeek(){
		List<ProductEntity> listProducts = productService.findAll();
        if(listProducts.isEmpty()) {
        	return new ResponseEntity<List<ProductEntity>>(listProducts, HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<List<ProductEntity>>(listProducts, HttpStatus.OK);
	}
	
	@GetMapping("/products-discover")
	public ResponseEntity<List<ProductEntity>>productsDiscover(){
		List<ProductEntity> listProducts = productService.productsDiscover();
        if(listProducts.isEmpty()) {
        	return new ResponseEntity<List<ProductEntity>>(listProducts, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ProductEntity>>(listProducts, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> finByIdl(@PathVariable Long id){
		ProductEntity product = null;
		Map<String, Object> response = new HashMap<>();
		try {
			product = productService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(product == null) {
			response.put("mensaje", "El Producto ID: ".concat((id.toString().concat(" no existe en la base de datos!"))));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProductEntity>(product, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody ProductEntity product){
		ProductEntity productCreated = null;
		Map<String, Object> response = new HashMap<>();
		try {
			productCreated = productService.save(product);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el save en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente ha sido creado con exito!");
		response.put("cliente", productCreated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<?>  edit(@RequestBody ProductEntity product,@PathVariable Long id) {
		ProductEntity productDB = null;
		ProductEntity productUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			productDB =  productService.findById(id);
			if(productDB == null) {
				response.put("mensaje", "El Producto ID: ".concat((id.toString().concat(" no existe en la base de datos!"))));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			//TODO: Agregar metodo para mergear
			productDB.setProductName(product.getProductName());
			productDB.setProductUnitPrice(product.getProductUnitPrice());
			
			productUpdated = productService.save(productDB);
			
			response.put("mensaje", "El product ha sido actualizado con exito!");
			response.put("cliente", productUpdated);
			
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
			productService.deleteById(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar al eliminar producto");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El producto ha sido eliminado con exito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
