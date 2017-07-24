package com.rahul.ecart.controller;

import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rahul.ecart.exception.CategoryNotFoundException;
import com.rahul.ecart.exception.ProductNotFoundException;
import com.rahul.ecartbackend.dto.Category;
import com.rahul.ecartbackend.dto.Product;
import com.rahul.ecartbackend.repository.CategoryRepository;
import com.rahul.ecartbackend.repository.ProductRepository;


@Controller
public class PageController {
	
	private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "home");
		
		logger.info("Inside PageController index method- INFO");
		logger.debug("Inside PageController index method- DEBUG");
		mv.addObject("userClickHome", true);
		mv.addObject("categoryList", categoryRepository.listCategory());
		return mv;
	}
	
	@RequestMapping(value= "/contact")
	public ModelAndView contact() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "contact");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	@RequestMapping(value= "/about")
	public ModelAndView about() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "about");
		mv.addObject("userClickabout", true);
		return mv;
	}
	
	@RequestMapping(value= "/services")
	public ModelAndView services() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "services");
		mv.addObject("userClickServices", true);
		return mv;
	}
	
	@RequestMapping(value= "/show/category/{id}/products")
	public ModelAndView findProductByCategory(@PathVariable("id") int id)throws CategoryNotFoundException {
		ModelAndView mv=new ModelAndView("page");
		Category cat=null;
		cat=categoryRepository.findById(id);
		if(cat==null)throw new CategoryNotFoundException();
		mv.addObject("title", cat.getName());
		mv.addObject("category", cat);
		mv.addObject("userClickCategoryProduct", true);
		mv.addObject("categoryList", categoryRepository.listCategory());
		return mv;
	}
	
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView viewProduct(@PathVariable("id")int id) throws ProductNotFoundException {
		ModelAndView mv=new ModelAndView("page");		
		
		Product product=productRepository.get(id);
		if(product==null)throw new ProductNotFoundException();
		//updating the product view
		product.setViews(product.getViews()+1);
		productRepository.update(product);
		Category category=categoryRepository.findById(product.getCategoryId());
		
		mv.addObject("category", category);
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickViewProduct", true);
		
		return mv;
	}
	
	/*login*/ 
	@RequestMapping(value= "/login")
	public ModelAndView login(@RequestParam(name="error", required=false)String error,
			@RequestParam(name="logout", required=false)String logout
			) {
		ModelAndView mv=new ModelAndView("login");
		if(error!=null) {
			mv.addObject("message", "Invalid Credential!");
		}
		if(logout!=null) {
			mv.addObject("logout", "User has Successfully Logged out!");
		}
		mv.addObject("title", "Login");
		return mv;
	}
	
	/* access denied page*/
	@RequestMapping(value= "/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("title", "403 - Access Denied");
		mv.addObject("errorTitle", "Aha!, Caught you.");
		mv.addObject("errorDescription", "You are not authorized to view this page!");
		return mv;
	}
	
	/*Logout*/
	@RequestMapping(value="/perform-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		//first fetch the authentication
		
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

}
