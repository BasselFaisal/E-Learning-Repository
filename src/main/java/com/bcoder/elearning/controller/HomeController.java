package com.bcoder.elearning.controller;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bcoder.elearning.dao.CartRepository;
import com.bcoder.elearning.dao.CategoryRepository;
import com.bcoder.elearning.dao.TutorialRepository;
import com.bcoder.elearning.dao.UserRepository;
import com.bcoder.elearning.dto.CartHeaderDto;
import com.bcoder.elearning.entity.Cart;
import com.bcoder.elearning.entity.Tutorial;
import com.bcoder.elearning.entity.TutorialCategory;
import com.bcoder.elearning.entity.User;



@Controller
public class HomeController {
	
	@Autowired
	private UserRepository UserRepository;
	
	@Autowired
	private TutorialRepository tutorialRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	public CartHeaderDto getHeader(Principal principal) {
		
		User user = UserRepository.getByUsername(principal.getName());
    	Cart cart =  cartRepository.getByUserId(user.getId());
    	
    	CartHeaderDto cartHeaderDto = new CartHeaderDto();
    	
    	cartHeaderDto.setNumerOfTutorials(cart.getTutorials().size());
    	
    	double tboct = 0;
    	
    	for(Tutorial temptutorial : cart.getTutorials())
    	{ tboct = tboct + temptutorial.getUnitprice();}
    	
    	cartHeaderDto.setTotalPriceOfTutorials(tboct);
    	
		return cartHeaderDto;
	}
	
    @GetMapping("/")
    public String root(Principal principal, Model model) throws UnsupportedEncodingException {
        if (principal != null){
        	
    		List<Tutorial> tutorials = tutorialRepository.findAll();
    		
    		model.addAttribute("cartHeader", getHeader(principal));
    		model.addAttribute("tutorials", tutorials);
    		
            return "home";
        } else {
            return "redirect:/root";
        }
    }
	
    @RequestMapping("/root")
	public String index(Model model) {		
		List<Tutorial> tutorials = tutorialRepository.findAll();
		model.addAttribute("tutorials", tutorials);
		return "root";
	}
    
    @GetMapping("/product")
    public String getProduct(@RequestParam(value = "id") int id, Model model) {
    	Tutorial tutorial = tutorialRepository.findById(id);
    	model.addAttribute("tutorial", tutorial);
    	return "product";
    }
    @GetMapping("/product_1")
    public String getProduct_(@RequestParam(value = "id") int id, Model model, Principal principal) {
    	Tutorial tutorial = tutorialRepository.findById(id);
    	
		model.addAttribute("cartHeader", getHeader(principal));
    	model.addAttribute("tutorial", tutorial);
    	return "product_1";
    }

    @GetMapping("/filter")
    public String filter(@RequestParam(value = "id") int id ,Principal principal, Model model) throws UnsupportedEncodingException {
		
		  if (principal != null){
		  
		  TutorialCategory tutorialCategory = categoryRepository.findById(id);
			  
		  List<Tutorial> tutorials = tutorialRepository.findByCategoryId(tutorialCategory.getId());
		  
		  model.addAttribute("cartHeader", getHeader(principal));
		  model.addAttribute("tutorials", tutorials);
		  
		  return "home"; 
		  }
		  else 
		  { 
			  return "redirect:/"; 
		  }
    	}
	    @RequestMapping("/rootFilter")
		public String index(@RequestParam(value = "id") int id, Model model) {	
	    	
			  TutorialCategory tutorialCategory = categoryRepository.findById(id);
			  
			  List<Tutorial> tutorials = tutorialRepository.findByCategoryId(tutorialCategory.getId());
			  
			  model.addAttribute("tutorials", tutorials);
			  
			return "root";
		}
	    @GetMapping("/search")
	    public String search(@Param("keyword") String keyword ,Principal principal, Model model) throws UnsupportedEncodingException {
			
			  if (principal != null){
			  				  
			  List<Tutorial> tutorials = tutorialRepository.search(keyword);
			  
			  model.addAttribute("cartHeader", getHeader(principal));
			  model.addAttribute("tutorials", tutorials);
			  
			  return "home"; 
			  }
			  else 
			  { 
				  return "redirect:/"; 
			  }
	    	}
	    @RequestMapping("/rootSearch")
		public String rootSearch(@Param("keyword") String keyword, Model model) {	
	    	
			  List<Tutorial> tutorials = tutorialRepository.search(keyword);
			  
			  model.addAttribute("tutorials", tutorials);
			  
			return "root";
		}
}
