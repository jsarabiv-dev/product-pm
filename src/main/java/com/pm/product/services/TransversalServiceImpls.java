package com.pm.product.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pm.product.model.ProductEntity;

@Service
public class TransversalServiceImpls implements TransversalService {

	@Override
	public List<ProductEntity> calculateFees(List<ProductEntity> listProduct) {

		listProduct.forEach( p-> {
			// Se calcula la cantidad de cuotas segun su precio, luego es dividido el precio por la cuota para sacar el valor de cada cuota
			p.setCuotas((p.getProductUnitPrice() > 800000f ? 10 : 6));
			p.setPrecioCuota(p.getProductUnitPrice() / (p.getCuotas()));
		});
	
		return listProduct;
	}

}
