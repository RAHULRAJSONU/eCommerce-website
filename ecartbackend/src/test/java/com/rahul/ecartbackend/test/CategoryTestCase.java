package com.rahul.ecartbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rahul.ecartbackend.dto.Category;
import com.rahul.ecartbackend.repository.CategoryRepository;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	private static CategoryRepository categoryRepository;
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.rahul.ecartbackend");
		context.refresh();
		categoryRepository = (CategoryRepository) context.getBean("categoryRepository");
	}

	/*
	 * @Test public void testAddCategory() { category=new Category();
	 * category.setName("Laptop"); category.setDescription("this is Laptop desc");
	 * category.setImageUrl("Cat_3");
	 * assertEquals("Successfully added a category inside table!", true,
	 * categoryRepository.addCategory(category)); }
	 */

	/*
	 * @Test public void get() { category =categoryRepository.findById(1);
	 * assertEquals("Successfully get category by id","Mobile",category.getName());
	 * }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * category=categoryRepository.findById(3); category.setName("TV");
	 * assertEquals("Successfully added a category inside table!", true,
	 * categoryRepository.updateCategory(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() {
	 * category=categoryRepository.findById(4);
	 * assertEquals("Successfully added a category inside table!", true,
	 * categoryRepository.deleteCategory(category)); }
	 */

	/*
	 * @Test public void testListCategory() {
	 * assertEquals("Successfully added a category inside table!", 2,
	 * categoryRepository.listCategory().size()); }
	 */

}
