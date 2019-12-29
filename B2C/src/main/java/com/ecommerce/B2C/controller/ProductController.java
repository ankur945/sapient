package com.ecommerce.B2C.controller;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecommerce.B2C.model.Product;
import com.ecommerce.B2C.model.Product2;
import com.ecommerce.B2C.service.ProductServiceImpl;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@RestController
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;
	
	@GetMapping("/allproducts/{sortedby}")
	public List<Product> findAllProduct(String sortedby) {
		List<Product> products = productService.findAllProduct(sortedby);
		return products;
	}
	
	@GetMapping("/productBySeller/{Seller}")
	public String findAllProductBySeller(String brand) throws InterruptedException, ExecutionException, TimeoutException {
		List<Product> product = Collections.emptyList();
		Future<List<Product>> productBySeller = productService.findAllProductBySeller(brand);		   
		    try {
		      product = productBySeller.get(20, TimeUnit.SECONDS);
		    } catch (InterruptedException e) {
		      e.printStackTrace();
		    } catch (ExecutionException e) {
		      e.printStackTrace();
		    }
		 
		return product.toString();
	}
	
	@Cacheable(value="ProductCache",key="#productid")
	@GetMapping("/productByProductId/{productid}")
	public Product findAllProductByproductid(Long productid) throws InterruptedException, ExecutionException, TimeoutException {
		Product product = null;
		CompletableFuture<Product> productByProductId = productService.findAllProductByProductId(productid);		   
		    try {
		      product = productByProductId.get(20, TimeUnit.SECONDS);
		    } catch (InterruptedException e) {
		      e.printStackTrace();
		    } catch (ExecutionException e) {
		      e.printStackTrace();
		    }
		 
		return product;
	}

	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		URI path = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/productid")
				.buildAndExpand(product.getProductid())
				.toUri();
		return ResponseEntity.created(path).build();
	}
	
	@CachePut(value="ProductCache",key="#productId")
	@PutMapping("/updatePrice/{productId}/{newPrice}")
	public String updateProductPrice(Long productId, Long newPrice)
	{
		productService.updateProductPrice(productId, newPrice);
		return "Price Updated";
	}
	
	@CacheEvict(value="ProductCache",key="#productid")
	@DeleteMapping("/delete/{productid}")
	public String deleteProductByProductId(@PathVariable Long productid)
	{
		productService.deleteProductByProductId(new Long(productid));
		return "product id " + productid + " deleted successfully.";
	}

}
