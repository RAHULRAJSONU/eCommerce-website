package com.rahul.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rahul.ecartbackend.dto.Product;
import com.rahul.ecartbackend.repository.ProductRepository;

@Controller
@RequestMapping(value="/json/data")
public class JsonDataController {
	
	@Autowired
	public ProductRepository productRepository;
	
	@RequestMapping(value="/all/product")
	@ResponseBody
	public List<Product> getAllProduct(){
		return productRepository.listActiveProducts();
	}
	
	@RequestMapping(value="/admin/all/product")
	@ResponseBody
	public List<Product> getAllProductForAdmin(){
		return productRepository.list();
	}
	
	@RequestMapping(value="/category/{id}/product")
	@ResponseBody
	public List<Product> getProductByCategory(@PathVariable int id){
		return productRepository.listActiveProductsByCategory(id);
	}
}
