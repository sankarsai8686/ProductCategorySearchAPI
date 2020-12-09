package com.xyz.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.ecommerce.model.Product;
import com.xyz.ecommerce.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product/save")
	public Product saveProduct(@RequestBody Product product)
	{
		return productService.saveProduct(product);
	}
	
	@DeleteMapping("/product/delete/{id}")
	public void deleteProduct(@PathVariable(value = "id") Integer id)
	{
		productService.deleteProduct(id);
	}
	
	@GetMapping("/product/getByBrand/{brand}")
	public List<Product> getProductByBrand(@PathVariable(value = "brand") String brand)
	{
		return productService.getProductByBrand(brand);
	}
	 
	@GetMapping("/product/getByPrice/{price}")
	public List<Product> getProductByPrice(@PathVariable(value = "price") Double price)
	{
		return productService.getProductByPrice(price);
	}
	
	@GetMapping("/product/getByColor/{color}")
	public List<Product> getProductByColor(@PathVariable(value = "color") String color)
	{
		return productService.getProductByColor(color);
	}
	
	@GetMapping("/product/getBySize/{size}")
	public List<Product> getProductBySize(@PathVariable(value = "size") Integer size)
	{
		return productService.getProductBySize(size);
	}
	
	@GetMapping("/product/getBySku/{sku}")
	public List<Product> getProductBySku(@PathVariable(value = "sku") String sku)
	{
		return productService.getProductBySku(sku);
	}
	
	
	
	@GetMapping("/product")
	public List<Product> getAllProducts()
	{
		return productService.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
