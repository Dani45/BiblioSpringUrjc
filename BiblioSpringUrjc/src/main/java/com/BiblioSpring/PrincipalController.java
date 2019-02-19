package com.BiblioSpring;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrincipalController {
	@RequestMapping("/")
	public String page(Model model) {
		// model.addAttribute("atribute", "value");
		return ("Index");
	}

}