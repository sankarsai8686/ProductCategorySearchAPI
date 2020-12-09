package com.xyz.ecommerce.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.ecommerce.exception.ProductNotFoundException;
import com.xyz.ecommerce.model.Product;
import com.xyz.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
	
	Logger logger = LoggerFactory.getLogger(ProductService.class);

	
	@Autowired
	private ProductRepository productRepository;
	
	
	public Product saveProduct(Product product)
	{
		Product savedProduct = productRepository.save(product);
		return savedProduct;
	}
	
	public void deleteProduct(Integer id) 
	{
		productRepository.deleteById(id);
	}
	
	public List<Product> getProductByBrand(String brand)
	{
		List<Product> findByBrand = productRepository.findByBrand(brand);
		
		System.out.println("findByBrand : "+findByBrand);
		
		//if(findByBrand != null || findByBrand.size() == 0)
		if(findByBrand != null || findByBrand.isEmpty())
		{
			logger.debug("Product Not Found In Database !!! Product with Brand : "+brand);
			//System.out.println("Product Not Found In Database");
			throw new ProductNotFoundException("Product Not Found In Database !!! Product Brand : "+brand);
		}
		
		return findByBrand;
	}
	
	public List<Product> getProductByPrice(Double price)
	{
		List<Product> findByPrice = productRepository.findByPrice(price);
		
		if(findByPrice !=null || findByPrice.isEmpty())
		{
			logger.debug("Product Not Found In Database !!! Product with price : "+price);
			throw new ProductNotFoundException("Product Not Found In Database !!! Product with price : "+price);
		}
		
		return findByPrice;
	}
	
	public List<Product> getProductByColor(String color)
	{
		List<Product> findByColor = productRepository.findByColor(color);
		
		if(findByColor !=null || findByColor.isEmpty())
		{
			logger.debug("Product Not Found In Database !!! Product with color : "+color);
			throw new ProductNotFoundException("Product Not Found In Database !!! Product with color : "+color);
		}
		return findByColor;
	}
	
	public List<Product> getProductBySize(Integer size)
	{
		return productRepository.findBySize(size);
	}
	
	public List<Product> getProductBySku(String sku)
	{
		return productRepository.findBySku(sku);
	}
	
	public List<Product> findAll()
	{
		return (List<Product>) productRepository.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
