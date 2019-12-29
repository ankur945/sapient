package com.ecommerce.B2C.repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ecommerce.B2C.model.Product;
import com.ecommerce.B2C.model.Product2;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Transactional
	@Modifying
	//here in query we should use entity class name & indexed query
	//@Query("update Product p set p.price = ?2 where p.productid = ?1")
	//here in query we should use entity class name & named query
	@Query("update Product p set p.price = :price where p.productid = :productid")
	void updatePrice(Long productid, Long price);
	
	// Here we use native query so whatever you mentioned with @ annotation will work
	@Async
	@Query(value = "select * from products where seller = :seller" , nativeQuery = true)
	//@Query(value = "select p from Product p where p.brand = :brand")
	CompletableFuture<List<Product>> getAllProductBySeller(@Param("seller") String sellerName);
	
	@Async
	@Query(value = "select * from products where productid = :productId" , nativeQuery = true)
	CompletableFuture<Product>  getAllProductByProductId(Long productId);

}
