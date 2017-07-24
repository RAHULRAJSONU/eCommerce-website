package com.rahul.ecartbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rahul.ecartbackend.dto.Product;
import com.rahul.ecartbackend.repository.ProductRepository;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	private static ProductRepository productRepository;
	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.rahul.ecartbackend");
		context.refresh();
		productRepository = (ProductRepository) context.getBean("productRepository");
	}

	/*@Test
	public void productCrud() {
		product = new Product();

		product.setName("Oppo Selfie s53");
		product.setBrand("Oppo");
		product.setDescription("description for Oppo mobile");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(2);
		product.setSupplierId(3);

		assertEquals("something went wrong!", true, productRepository.add(product));

		product = productRepository.get(3);
		product.setName("Google Pixel updated");
		assertEquals("something went wrong!", true, productRepository.update(product));

		assertEquals("something went wrong!", true, productRepository.delete(product));

		assertEquals("something went wrong!", 8, productRepository.list().size());

	}*/
	
	/*@Test
	public void testActiveProduct() {
		assertEquals("something went wrong!",5,productRepository.listActiveProducts().size());
		
		assertEquals("something went wrong!",3,productRepository.listActiveProductsByCategory(3).size());
		
		assertEquals("something went wrong!",1,productRepository.listActiveProductsByCategory(1).size());
		
		assertEquals("something went wrong!",1,productRepository.listActiveProductsByCategory(2).size());
		
	}*/
	
	/*@Test
	public void testLatestActive() {
		assertEquals("Something went wrong!",3,productRepository.getLatestActiveProducts(3).size());
	}*/
}
