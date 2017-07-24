package com.rahul.ecartbackend.repository;

import java.util.List;

import com.rahul.ecartbackend.dto.Category;

public interface CategoryRepository {
	
	public boolean addCategory(Category category);
	
	public List<Category> listCategory();
	
	public Category findById(int id);
	
	public boolean updateCategory(Category category);
	
	public boolean deleteCategory(Category category);
	
}
