package com.bcoder.elearning.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcoder.elearning.dao.UserRepository;
import com.bcoder.elearning.dto.UserDto;
import com.bcoder.elearning.entity.Cart;
import com.bcoder.elearning.entity.User;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder encoder;
    
    @ModelAttribute("user")
    public UserDto dto(){
        return new UserDto();
    }
	

	@RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }
    
    
    @GetMapping("/registration")
    public String showRegistrationForm(Model model){
        return "registration";
    }
	
	@PostMapping("/registration")
	public String registration(@ModelAttribute("user") @Validated UserDto dto
			,BindingResult result)
	{
		User tempUser = userRepository.getByUsername(dto.getUsername());
		
		if(tempUser!=null)
		{
			result.rejectValue("username", null, "Username is alredy registerd");
		}
		if(result.hasErrors())
		{
			return "registration";
		}
		User user = new User(dto.getUsername(),encoder.encode(dto.getPassword()));
		Cart cart= new Cart(user);
		user.setCart(cart);
		userRepository.save(user);
		return "redirect:/registration?success" ;
	}

}
