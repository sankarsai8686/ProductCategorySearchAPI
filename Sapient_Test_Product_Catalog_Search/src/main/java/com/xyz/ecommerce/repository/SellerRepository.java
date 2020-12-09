package com.xyz.ecommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.xyz.ecommerce.model.Seller;

public interface SellerRepository extends CrudRepository<Seller, Integer>{
	
	
	List<Seller> findBySellerNameAndProductId(String sellerName, int productId);
	List<Seller> findByProductId(int productId);

}
