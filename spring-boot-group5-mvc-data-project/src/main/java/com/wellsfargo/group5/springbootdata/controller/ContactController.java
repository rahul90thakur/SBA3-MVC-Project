package com.wellsfargo.group5.springbootdata.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.group5.springbootdata.exception.AddressBookException;
import com.wellsfargo.group5.springbootdata.model.AddressGroupModel;
import com.wellsfargo.group5.springbootdata.model.ContactModel;
import com.wellsfargo.group5.springbootdata.service.AddressGroupService;
import com.wellsfargo.group5.springbootdata.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {
	@Autowired
	private ContactService contactservice;
	
	@Autowired
	private AddressGroupService groupService;
	
@GetMapping
public ModelAndView contactsAction() throws AddressBookException  {
	return new ModelAndView("contacts/contact-page","contacts",contactservice); 
}
@GetMapping("/delete")
public String deleteAction(@RequestParam("cid")long cId) throws AddressBookException {
	contactservice.delete(cId);
	return "redirect:/contacts";
}
 
@ModelAttribute("groups")
public List<AddressGroupModel> getAllGroups() throws AddressBookException{
	return groupService.getAll();
}

@GetMapping("/new")
public ModelAndView newContactAction() {
	ModelAndView mv = new ModelAndView("contacts/contact-form-page","contact",new ContactModel());
	mv.addObject("isNew",true);
	return mv;
}

@GetMapping("/edit")
public ModelAndView editContactAction(@RequestParam("cid")long cId) throws AddressBookException {
	ContactModel contact = contactservice.get(cId);
	ModelAndView mv = new ModelAndView("contacts/contact-form-page","contact",contact);
	mv.addObject("isNew",false);
	return mv;
}

@PostMapping("/add")
public ModelAndView addContactAction(
		@ModelAttribute("contact") @Valid ContactModel contact,
		BindingResult result
		) throws AddressBookException {
	ModelAndView mv=null;	
	
	if(result.hasErrors()) {
		mv = new ModelAndView("contacts/contact-form-page","contact",contact);
		mv.addObject("isNew",true);
	}else {
		contactservice.add(contact);
		mv = new ModelAndView("redirect:/contacts");
	}
	
	return mv;
}

@PostMapping("/update")	
public ModelAndView updateContactAction(
		@ModelAttribute("contact") @Valid ContactModel contact,
		BindingResult result
		) throws AddressBookException {
	ModelAndView mv=null;	
	
	if(result.hasErrors()) {
		mv = new ModelAndView("contacts/contact-form-page","contact",contact);
		mv.addObject("isNew",false);
	}else {
		contactservice.update(contact);
		mv = new ModelAndView("redirect:/contacts");
	}
	
	return mv;
}
/*
 * @GetMapping("/delete")
 * 
 * @GetMapping("/new")
 * 
 * @PostMapping("/add")
 * 
 * @GetMapping("/edit")
 * 
 * @PostMapping("/update")
 */
}
