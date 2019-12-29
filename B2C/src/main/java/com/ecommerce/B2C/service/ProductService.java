/**
 * 
 */
package com.ecommerce.B2C.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import com.ecommerce.B2C.model.Product;
import com.ecommerce.B2C.model.Product2;

/**
 * @author Ankur
 *
 */
public interface ProductService {
	
	List<Product> findAllProduct(String sortedby);
	
	Future<List<Product>> findAllProductBySeller(String seller);
	
	CompletableFuture<Product> findAllProductByProductId(Long ProductId);
	
	void addProduct(Product product);
	
	void updateProductPrice(Long id, Long newPrice);
	
	void deleteProductByProductId(Long productid);
	
}
