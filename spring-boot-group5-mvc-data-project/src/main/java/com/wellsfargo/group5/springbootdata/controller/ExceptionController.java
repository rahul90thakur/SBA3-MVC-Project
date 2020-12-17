package com.wellsfargo.group5.springbootdata.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.group5.springbootdata.exception.AddressBookException;
import com.wellsfargo.group5.springbootdata.model.AddressGroupModel;

@ControllerAdvice
public class ExceptionController {
@ExceptionHandler(AddressBookException.class)
public ModelAndView handleException(AddressBookException exp) {
	return new ModelAndView("error-page","errMsg", exp.getMessage());
	
}

}
