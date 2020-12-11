package com.pm.product.services;
import java.util.*;

import com.pm.product.model.ProductEntity;

public interface TransversalService {
	
	List<ProductEntity> calculateFees(List<ProductEntity> listProduct);

}
