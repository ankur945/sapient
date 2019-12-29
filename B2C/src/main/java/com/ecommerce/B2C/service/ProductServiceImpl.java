package com.ecommerce.B2C.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecommerce.B2C.model.Product;
import com.ecommerce.B2C.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	private ProductRepository productRepository;
	@Override
	public List<Product> findAllProduct(String sortedby) {
		List<Product> products = productRepository.findAll(Sort.by(sortedby));
		return products;
	}

	@Override
	public Future<List<Product>> findAllProductBySeller(String seller) {
		Future<List<Product>> productBySeller = productRepository.getAllProductBySeller(seller);
		return productBySeller;
	}
	
	@Override
	public CompletableFuture<Product> findAllProductByProductId(Long ProductId) {
		CompletableFuture<Product> productByProductId = productRepository.getAllProductByProductId(ProductId);
		return productByProductId;
	}
	
	
	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
		log.info("Product Added "+ product);
		System.out.println("Product Added "+ product);

	}

	@Override
	public void updateProductPrice(Long productId, Long newPrice) {
		productRepository.updatePrice(productId, newPrice);

	}

	@Override
	public void deleteProductByProductId(Long productid) {
		productRepository.deleteById(new Long(productid));
	}

}
