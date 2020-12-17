package com.wellsfargo.group5.springbootdata.controller;

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
import com.wellsfargo.group5.springbootdata.service.AddressGroupService;

@Controller
@RequestMapping("/groups")
public class AddressGroupController {
	@Autowired
	private AddressGroupService agservice;
	
	@GetMapping
	public ModelAndView groupsAction() throws AddressBookException {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("groups/groups-page");
		mv.addObject("group",new AddressGroupModel());
		return mv;
	}
	@GetMapping("/delete")
	public String deleteAction(@RequestParam ("gid") int groupId) throws AddressBookException {
		agservice.delete(groupId);
		return "redirect:/groups";
	}
	@PostMapping("/add")
	public ModelAndView addAction(@ModelAttribute("group") @Valid AddressGroupModel group, BindingResult result) throws AddressBookException {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("groups/groups-page");
		if (result.hasErrors()) {
			mv.addObject("group",group);
		}
		else {
			agservice.add(group);
		mv.addObject("group",new AddressGroupModel());
		}
		mv.addObject("groups",agservice.getAll());
		return mv;
		
	}

}
