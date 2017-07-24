package com.rahul.ecart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rahul.ecart.utility.FileUploadUtility;
import com.rahul.ecart.validator.ProductValidator;
import com.rahul.ecartbackend.dto.Category;
import com.rahul.ecartbackend.dto.Product;
import com.rahul.ecartbackend.repository.CategoryRepository;
import com.rahul.ecartbackend.repository.ProductRepository;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Product");

		Product nProduct = new Product();

		nProduct.setSupplierId(1);
		nProduct.setActive(true);

		mv.addObject("product", nProduct);
		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Product Added Successfully!");
			}else if(operation.equals("category")) {
				mv.addObject("message", "Category Added Successfully!");
			}
		}
		return mv;
	}

	@RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
	public ModelAndView showEditProducts(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Product");
		// fetch product from db
		Product nProduct = productRepository.get(id);
		// set the product fetched from db

		mv.addObject("product", nProduct);

		return mv;
	}

	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
	public String handleProductActivation(@PathVariable int id) {

		Product product = productRepository.get(id);
		// fetch data from database
		boolean isActive = product.isActive();

		// activating and deactivating based on the value of active field
		product.setActive(!product.isActive());
		// updateing the product
		productRepository.update(product);
		return (isActive) ? "You have successfully deactivated the product with id" + product.getId()
				: "You have successfully activated the product with id" + product.getId();
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product nProduct, BindingResult results,
			Model model, HttpServletRequest request) {

		if (nProduct.getId() == 0) {
			new ProductValidator().validate(nProduct, results);
		} else {
			if (!nProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(nProduct, results);
			}
		}
		// check if there are any errors
		if (results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Product");
			model.addAttribute("message", "Form validation failed!");
			return "page";
		}

		logger.info(nProduct.toString());
		// create new product
		if (nProduct.getId() == 0) {
			productRepository.add(nProduct);
		} else {
			// update new product
			productRepository.update(nProduct);
		}
		if (!nProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, nProduct.getFile(), nProduct.getCode());
		}
		return "redirect:/manage/products?operation=product";
	}

	// to handle category submission
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {

		// add new category
		categoryRepository.addCategory(category);

		return "redirect:/manage/products?operation=category";
	}

	// returning category for all the mapping
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryRepository.listCategory();
	}

	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}

}
