package br.tvon.tvonapp.spotsync.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spotsync")
public class HomeController {
	
	@GetMapping(value = {"/",""})
	public String indexAction() {
		return "index";
	}

}
