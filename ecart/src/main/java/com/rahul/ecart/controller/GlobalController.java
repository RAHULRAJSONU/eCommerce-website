package com.rahul.ecart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.rahul.ecart.model.UserModel;
import com.rahul.ecartbackend.dto.User;
import com.rahul.ecartbackend.repository.UserRepository;

@ControllerAdvice
public class GlobalController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserRepository userRepository;
	
	private UserModel userModel=null;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		if(session.getAttribute("userModel")==null) {
			//add the userModel
			Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
			
			User user=userRepository.getByEmail(authentication.getName());
			if(user !=null) {
				userModel=new UserModel();
				
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName()+" "+user.getLastName());
				
				if(userModel.getRole().equals("USER")) {
					//set the cart only if user is a buyer
					userModel.setCart(user.getCart());
				}
				
				//set the userModel in the session
				session.setAttribute("userModel", userModel);
				
				return userModel;
			}
		}
		
		return (UserModel) session.getAttribute("userModel");
	}
}
