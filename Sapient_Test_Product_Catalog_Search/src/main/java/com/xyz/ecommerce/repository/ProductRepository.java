package com.xyz.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xyz.ecommerce.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	
	List<Product> findByProductName(String name);
	List<Product> findByBrand(String brand);
	List<Product> findByColor(String color);
	List<Product> findByPrice(Double price);
	List<Product> findBySku(String sku);
	List<Product> findBySize(int size);
	
	//@Query(value = "select ud from product ud where ud.price between ?1 and ?2")//JPQL
	//@Query(value = "select * from Product where price between ?1 and ?2", nativeQuery=true)
	//List<Product> getProductByPrices(Double priceRange1, Double priceRange2);
	
	@Query(value = "select * from Product where price between :priceRange1 and :priceRange2", nativeQuery=true)
	List<Product> getProductByPrices(@Param("priceRange1")  Double priceRange1,@Param("priceRange2") Double priceRange2);
	

}
