package com.rahul.ecartbackend.repository;

import java.util.List;

import com.rahul.ecartbackend.dto.Product;

public interface ProductRepository {

	public Product get(int productId);

	public List<Product> list();

	public boolean add(Product product);

	public boolean update(Product product);

	public boolean delete(Product product);

	// business methods

	public List<Product> listActiveProducts();

	public List<Product> listActiveProductsByCategory(int categoryId);

	public List<Product> getLatestActiveProducts(int count);
}
