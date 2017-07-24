package com.rahul.ecart.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rahul.ecartbackend.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {
		
		Product product=(Product)target;
		
		//whether file has been selected or not
		if(product.getFile()==null||product.getFile().getOriginalFilename().equals("")) {
			error.rejectValue("file", null, "Please select an image file");
			return;
		}
		
		if(!(
			product.getFile().getContentType().equals("image/jpeg")||
			product.getFile().getContentType().equals("image/png")||
			product.getFile().getContentType().equals("image/gif"))
			) {
			error.rejectValue("file", null,"Please select a valid image file-:Jpeg/png/gif");
			return;
		}
	}

}
