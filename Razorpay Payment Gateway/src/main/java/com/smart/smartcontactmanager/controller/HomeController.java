package com.smart.smartcontactmanager.controller;

import com.smart.smartcontactmanager.helper.Message;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.smartcontactmanager.dao.UserRepository;
import com.smart.smartcontactmanager.entities.User;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home-smart contact  manage");
		return "home";
	}
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("about", "Home-smart contact  manage");
		return "about";
	}
	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("about", "signup-smart contact  manage");
		model.addAttribute("user",new User());
		
		return "signup";


	
	}
	//this handler for ragistering user
		@RequestMapping(value = "/do_register", method = RequestMethod.POST)
		public String registerUser(@Valid @ModelAttribute("user") User user  ,BindingResult result1,
		                            @RequestParam(value = "agreement", defaultValue = "false") boolean agreement,
		                            Model model, HttpSession session) {
		    try {
		    	
		    	/*if(result1.hasErrors()) {
		    		System.out.println("Error"+result1.toString());
		    		
		    		model.addAttribute("user",user);
		    		
		    		return "signup";
		    	}*/
		    	
		    	
		        user.setRole("Role USER");
		        user.setEnabled(true);
		        user.setImageUrl("default.png");

		        User result = this.userRepository.save(user);
		        System.out.println(result);
		        model.addAttribute("User", result);

		        // Store success message in session
		        session.setAttribute("message", new Message("Successfully registered", "alert-success"));

		        // Add session message to the model explicitly
		        model.addAttribute("message", session.getAttribute("message"));

		        return "signup";
		    } catch (Exception e) {
		        e.printStackTrace();
		        model.addAttribute("user", user);

		        // Store error message in session
		        session.setAttribute("message", new Message("Something went wrong: " + e.getMessage(), "alert-danger"));

		        // Add session message to the model explicitly
		        model.addAttribute("message", session.getAttribute("message"));

		        return "signup";
		    }
		}

	


}
