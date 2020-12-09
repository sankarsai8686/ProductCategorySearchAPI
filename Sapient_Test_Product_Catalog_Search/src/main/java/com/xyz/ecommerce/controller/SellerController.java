package com.xyz.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.ecommerce.dto.SellerDTO;
import com.xyz.ecommerce.model.Product;
import com.xyz.ecommerce.model.Seller;
import com.xyz.ecommerce.service.SellerService;

@RestController
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@PostMapping("/seller/save")
	public Seller save(@RequestBody SellerDTO sellerDto)
	{
		return sellerService.save(sellerDto);
	}
	
	@DeleteMapping("/seller/delete/{id}")
	public void delete(@PathVariable(value="id") Integer id)
	{
		sellerService.delete(id);
	}
	
	@GetMapping("/product/{sellerName}/{productId}")
	public long getQuantityBySeller
	(
			@PathVariable(value = "sellerName") String sellerName,
			@PathVariable(value = "productId") Integer productId
	)
	{
		return sellerService.getQuantityBySeller(sellerName, productId);
	}
	
	@GetMapping("/product/inventory/{productId}")
	public long getInventory(@PathVariable(value="productId") Integer productId)
	{
		return sellerService.getInventory(productId);
	}
	
	
	@GetMapping("/seller")
	public Iterable<Seller> getAllProducts()
	{
		return sellerService.findAll();
	}

}
