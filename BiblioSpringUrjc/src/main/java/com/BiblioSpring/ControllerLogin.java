package com.BiblioSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerLogin {
	@RequestMapping("/Login")
	public String greeting(Model model) {
		// model.addAttribute("name", "Login");
		return "Login";
	}

	@RequestMapping("/Admin")
	public String admin(Model model) {
		// model.addAttribute("name", "admin");
		return "Admin";
	}

}
