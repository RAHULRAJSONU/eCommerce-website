package com.rahul.ecartbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rahul.ecartbackend.dto.Address;
import com.rahul.ecartbackend.dto.Cart;
import com.rahul.ecartbackend.dto.User;
import com.rahul.ecartbackend.repository.UserRepository;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserRepository userRepository;
	private User user = null;
	private Address address = null;
	private Cart cart = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.rahul.ecartbackend");
		context.refresh();

		userRepository = (UserRepository) context.getBean("userRepository");
	}

	/*
	  @Test public void testAdd() {
	  
	  user = new User();
	  user.setFirstName("Rahul"); 
	  user.setLastName("Raj");
	  user.setEmail("rajrahul9939@gmail.com"); 
	  user.setContactNumber("9255511109");
	  user.setRole("USER"); 
	  user.setPassword("123456");
	  
	  // add the user 
	  assertEquals("Failed to add user!", true, userRepository.addUser(user));
	  
	  address = new Address(); 
	  address.setAddressLineOne("Btm");
	  address.setAddressLineTwo("stage 2"); 
	  address.setCity("Bangalore");
	  address.setState("Karnataka"); 
	  address.setCountry("India");
	  address.setPostalCode("560076"); 
	  address.setBilling(true);
	  
	  // link to the user 
	  address.setUserId(user.getId());
	  
	  // add the address and 
	  assertEquals("Failed to add address!", true,userRepository.addAddress(address));
	  
	  if (user.getRole().equals("USER")) { 
	  // create a cart for this user 
	  
	  cart = new Cart(); 
	  cart.setUser(user);
	  
	  // add the cart 
	  assertEquals("Failed to add cart!", true,userRepository.addCart(cart));
	  
	  // add a shipping address 
	  address = new Address();
	  address.setAddressLineOne("Durga Vihar");
	  address.setAddressLineTwo("phase 1"); 
	  address.setCity("southwest delhi");
	  address.setState("new Delhi"); 
	  address.setCountry("India");
	  address.setPostalCode("110043"); 
	  address.setBilling(false);
	  
	  // link it with the user 
	  address.setUserId(user.getId());
	  
	  // add the shipping address 
	  assertEquals("Failed to add shipping address!",true, userRepository.addAddress(address));
	  
	  }
	  
	  }
	 */

	/*@Test
	public void testAdd() {

		user = new User();
		user.setFirstName("Rahul");
		user.setLastName("Raj");
		user.setEmail("rajrahul9939@gmail.com");
		user.setContactNumber("9255511109");
		user.setRole("USER");
		user.setPassword("123456");

		if (user.getRole().equals("USER")) {
			// create a cart for this user
			cart = new Cart();
			cart.setUser(user);			
			//attach the cart to the user
			user.setCart(cart);
		}
		// add the user
		assertEquals("Failed to add user!", true, userRepository.addUser(user));

	}*/
	
	/*@Test
	public void testUpdateCart() {
		//get the user by email
		user=userRepository.getByEmail("rajrahul9939@gmail.com");
		
		//get the cart
		cart=user.getCart();
		
		cart.setGrandTotal(8479);
		cart.setCartLines(2);
		
		assertEquals("failed to update the cart!", true, userRepository.updateCart(cart));
	}*/
	
	/*@Test
	public void testAddAddress() {
		//we need to add an user
		user = new User();
		user.setFirstName("Rahul");
		user.setLastName("Raj");
		user.setEmail("rajrahul9939@gmail.com");
		user.setContactNumber("9255511109");
		user.setRole("USER");
		user.setPassword("123456");
		
		assertEquals("Failed to add user!", true, userRepository.addUser(user));
		//we are going to add the address
		address = new Address(); 
		address.setAddressLineOne("Btm");
		address.setAddressLineTwo("stage 2"); 
		address.setCity("Bangalore");
		address.setState("Karnataka"); 
		address.setCountry("India");
		address.setPostalCode("560076"); 
		address.setBilling(true);
		
		address.setUserId(user.getId());
		
		assertEquals("Failed to add billing address!", true, userRepository.addAddress(address));
		//we are also going to add the shipping address
		  address = new Address();
		  address.setAddressLineOne("Durga Vihar");
		  address.setAddressLineTwo("phase 1"); 
		  address.setCity("southwest delhi");
		  address.setState("new Delhi"); 
		  address.setCountry("India");
		  address.setPostalCode("110043"); 
		  address.setShipping(true);
		  
		  address.setUserId(user.getId());
		  
		  assertEquals("Failed to add shipping address!", true, userRepository.addAddress(address));
		  
	}*/
	
	/*@Test
	public void addAddressAndCart() {
		user=userRepository.getByEmail("rajrahul9939@gmail.com");
		address = new Address();
		address.setAddressLineOne("Himmatpur");
		address.setAddressLineTwo("Sidhwalia"); 
		address.setCity("Gopalganj");
		address.setState("Bihar"); 
		address.setCountry("India");
		address.setPostalCode("841423"); 
		address.setShipping(true);
		  
		address.setUserId(user.getId());
		  
		assertEquals("Failed to add shipping address!", true, userRepository.addAddress(address));

	}*/
    
	
	@Test
	public void testGetAddress() {
		user =userRepository.getByEmail("rajrahul9939@gmail.com");
		assertEquals("Failed to fetch the list of address and size does not match",2,userRepository.listShippingAddress(user.getId()).size());
		
		assertEquals("Failed to fetch the list of address and size does not match","Bangalore",userRepository.getBillingAddress(user.getId()).getCity());
	}
}
