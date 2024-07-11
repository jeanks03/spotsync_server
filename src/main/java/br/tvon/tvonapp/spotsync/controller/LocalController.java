package br.tvon.tvonapp.spotsync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.tvon.tvonapp.service.LocalService;
import br.tvon.tvonapp.spotsync.entities.Local;

@Controller
@RequestMapping("/locais")
public class LocalController {
	
	@Autowired
	LocalService service;
	
	@GetMapping(value = {"/",""})
	public ModelAndView index(ModelMap model) {
		ModelAndView mv = new ModelAndView("/locais/index");
		mv.addObject("locais", service.buscaTodos());
		return mv;
		
	}
	
	@GetMapping("/add")
	public ModelAndView addLocal(Local local) {
		ModelAndView mv = new ModelAndView("/locais/add");
		return mv;
	}
	
	@PostMapping("/add")
	public ModelAndView saveLocal(Local local, ModelMap model) {
		service.salvar(local);
		return index(model);
	}

}
