package com.xyz.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.ecommerce.dto.SellerDTO;
import com.xyz.ecommerce.exception.ProductNotFoundException;
import com.xyz.ecommerce.model.Product;
import com.xyz.ecommerce.model.Seller;
import com.xyz.ecommerce.repository.ProductRepository;
import com.xyz.ecommerce.repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public Seller save(SellerDTO sellerDto)
	{
		List<Product> findByProductName = productRepository.findByProductName(sellerDto.getProductName());
		if(findByProductName.size() > 0)
		{
			throw new ProductNotFoundException("Product not found in DB!! PRODUCT NAME : "+sellerDto.getProductName());
		}
		else
		{
			Seller seller = new Seller();
			seller.setProductId(findByProductName.get(0).getProductId());
			seller.setSellerName(sellerDto.getSellerName());
			seller.setQuantity(sellerDto.getQuantity());
			
			return sellerRepository.save(seller);
		}
	}
	
	public void delete(Integer id)
	{
		sellerRepository.deleteById(id);
	}
	
	
	public long getQuantityBySeller(String sellerName, Integer productId)
	{
		List<Seller> findBySellerNameAndProductId = sellerRepository.findBySellerNameAndProductId(sellerName, productId);
		System.out.println("findBySellerNameAndProductId : "+findBySellerNameAndProductId);
	
		//return findBySellerNameAndProductId.stream().map(i->i.getQuantity()).reduce(0,(x,y)->x+y);
		return findBySellerNameAndProductId.stream().map(i->i.getQuantity()).reduce(0, Integer::sum);
	}
	
	
	public long getInventory(Integer productId)
	{
		List<Seller> findByProductId = sellerRepository.findByProductId(productId);
		return findByProductId.stream().map(i->i.getQuantity()).reduce(0,Integer::sum);
	}

	public Iterable<Seller> findAll() {
		return sellerRepository.findAll();
	}
	
	
}
