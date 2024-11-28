package com.proj.thymeleafPractical.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	
	@RequestMapping(value = "/about",method = RequestMethod.GET)
	public String about(Model model) {
		System.out.println("going inside about handler");
		model.addAttribute("name","sahil");
		model.addAttribute("currentdate", new Date().toString());
		return "about";
	}
	
	@GetMapping("example-loop")
	public String iterateHandler(Model m) {
	   List<String> name= List.of("Ankit","laxmi","karan","john");
	   m.addAttribute("name", name);
	   return "iterate";
		
	}
	@GetMapping("/condition")
	public String conditionHandler(Model m) {
		
		System.out.println("condiotion handler finally executes");
		m.addAttribute("isActive",false);
		m.addAttribute("gender",'M');
		
		List<Integer> num=List.of(1);
		
		m.addAttribute("mylist",num);
		
		
		
		
		return"condition";
	}
	@GetMapping("/service")
	public String serviceHandler( Model m) {
		m.addAttribute("title","i want to eat chicken");
		m.addAttribute("subtitle",LocalDateTime.now().toString());
		return "services";
	}
	@GetMapping("/newabout")
	public String newAbout() {
		
		
		return "aboutnew";
	}
	@GetMapping("/contact")
	public String ontact() {
		
		
		return "contact";
	}
	
	
	
}
