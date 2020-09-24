package com.bcoder.elearning.controller;

import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bcoder.elearning.dao.CartRepository;
import com.bcoder.elearning.dao.TutorialRepository;
import com.bcoder.elearning.dao.UserRepository;
import com.bcoder.elearning.entity.Cart;
import com.bcoder.elearning.entity.Tutorial;
import com.bcoder.elearning.entity.User;

@Controller
public class MyController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TutorialRepository tutorialRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private HomeController homeController;
	
	@GetMapping("/myProfile")
	public String getProfile(Principal principal,Model model) {
		
    	User user = userRepository.getByUsername(principal.getName());
    	
		Set<Tutorial> tutorials = user.getTutorials();
    	
		model.addAttribute("cartHeader", homeController.getHeader(principal));
    	model.addAttribute("tutorials", tutorials);
    	model.addAttribute("user", user);
    	return "profile";
	}
	@RequestMapping("/getCheckout")
	public String getCheckout(@RequestParam(value = "id") int id, Model model,Principal principal) {
				
    	Tutorial tutorial = tutorialRepository.findById(id);
    	    	
    	User user = userRepository.getByUsername(principal.getName());
		Set<Tutorial> tutorials =  user.getTutorials();

    	Cart cart =  cartRepository.getByUserId(user.getId());
		Set<Tutorial> temptutorials =  cart.getTutorials();

    	tutorials.add(tutorial);
    	temptutorials.remove(tutorial);
    	
    	user.setTutorials(tutorials);
    	cart.setTutorials(temptutorials);

    	userRepository.save(user);
    	cartRepository.save(cart);
    	
		model.addAttribute("cartHeader", homeController.getHeader(principal));
    	model.addAttribute("tutorials", user.getTutorials());
    	model.addAttribute("user", user);
    	return "profile";
	}
	@RequestMapping("/getAllCheckout")
	public String getAllCheckout(Model model,Principal principal) {
				    	    	
    	User user = userRepository.getByUsername(principal.getName());
		Set<Tutorial> tutorials =  user.getTutorials();

    	Cart cart =  cartRepository.getByUserId(user.getId());
		Set<Tutorial> temptutorials =  cart.getTutorials();

    	tutorials.addAll(temptutorials);
    	temptutorials.removeAll(temptutorials);
    	
    	user.setTutorials(tutorials);
    	cart.setTutorials(temptutorials);

    	userRepository.save(user);
    	cartRepository.save(cart);
    	
		model.addAttribute("cartHeader", homeController.getHeader(principal));
    	model.addAttribute("tutorials", user.getTutorials());
    	model.addAttribute("user", user);
    	return "profile";
	}
	@RequestMapping("/removeFromProfil")
	public String removeFromCart(@RequestParam(value = "id") int id, Model model,Principal principal) {
				
    	Tutorial tutorial = tutorialRepository.findById(id);
    	    	
    	User user = userRepository.getByUsername(principal.getName());

		Set<Tutorial> tutorials = user.getTutorials();
    	
		tutorials.remove(tutorial);
		
		user.setTutorials(tutorials);
    	
    	userRepository.save(user);
    	
		model.addAttribute("cartHeader", homeController.getHeader(principal));
    	model.addAttribute("tutorials", user.getTutorials());
    	model.addAttribute("user", user);
    	return "profile";
	}
}
