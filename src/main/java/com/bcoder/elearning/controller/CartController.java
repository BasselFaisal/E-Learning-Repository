package com.bcoder.elearning.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bcoder.elearning.dao.CartRepository;
import com.bcoder.elearning.dao.TutorialRepository;
import com.bcoder.elearning.dao.UserRepository;
import com.bcoder.elearning.entity.Cart;
import com.bcoder.elearning.entity.Tutorial;
import com.bcoder.elearning.entity.User;

@Controller()
public class CartController {
	
	@Autowired
	private TutorialRepository tutorialRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private HomeController homeController;
	
	 @RequestMapping("/myCart")
	 public String myCart(Principal principal,Model model) {
	  
	    	User user = userRepository.getByUsername(principal.getName());
	    	
	    	Cart cart =  cartRepository.getByUserId(user.getId());
	    	
    		model.addAttribute("cartHeader", homeController.getHeader(principal));
	    	model.addAttribute("tutorials", cart.getTutorials());
	  
	 return "cart";
	 }
	 
	@RequestMapping("/addToCart")
	public String addToCart(@RequestParam(value = "id") int id, Model model,Principal principal) {
		
		Set<Tutorial> tutorials = new HashSet<>();
		
    	Tutorial tutorial = tutorialRepository.findById(id);
    	    	
    	User user = userRepository.getByUsername(principal.getName());
    	    	
    	Cart cart =  cartRepository.getByUserId(user.getId());
    	
		model.addAttribute("cartHeader", homeController.getHeader(principal));

    	tutorials.add(tutorial);
    	tutorials.addAll(cart.getTutorials());
    	    	
    	cart.setTutorials(tutorials);
    	
    	cartRepository.save(cart);
    	
		model.addAttribute("cartHeader", homeController.getHeader(principal));
    	model.addAttribute("tutorials", cart.getTutorials());
    	
    	return "cart";
	}
	@RequestMapping("/removeFromCart")
	public String removeFromCart(@RequestParam(value = "id") int id, Model model,Principal principal) {
				
    	Tutorial tutorial = tutorialRepository.findById(id);
    	    	
    	User user = userRepository.getByUsername(principal.getName());
    	    	
    	Cart cart =  cartRepository.getByUserId(user.getId());
    	
		Set<Tutorial> tutorials = cart.getTutorials();
    	
		tutorials.remove(tutorial);
		
    	cart.setTutorials(tutorials);
    	
    	cartRepository.save(cart);
    	
		model.addAttribute("cartHeader", homeController.getHeader(principal));
    	model.addAttribute("tutorials", cart.getTutorials());
    	
    	return "cart";
	}

}
