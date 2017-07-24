package com.rahul.ecartbackend.repository;

import java.util.List;

import com.rahul.ecartbackend.dto.Address;
import com.rahul.ecartbackend.dto.User;
import com.rahul.ecartbackend.dto.Cart;

public interface UserRepository {
	
	//add an user
	public boolean addUser(User user);
	
	//get user by email
	public User getByEmail(String email);
	
	//add an address
	
	public boolean addAddress(Address address);
	
	public Address getBillingAddress(int userId);
	
	public List<Address> listShippingAddress(int userId);
	
	//update a cart
	
	public boolean updateCart(Cart cart);
}
