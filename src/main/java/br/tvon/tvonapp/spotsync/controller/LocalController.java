package br.tvon.tvonapp.spotsync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.tvon.tvonapp.service.LocalService;
import br.tvon.tvonapp.spotsync.entities.Local;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/locais")
public class LocalController {
	
	@Autowired
	LocalService service;
	
	@GetMapping(value = {"/",""})
	public ModelAndView index() {
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
	public String saveLocal(Local local, RedirectAttributes attr) {
		service.salvar(local);
		attr.addFlashAttribute("success", "Local salvo com sucesso!");
		return "redirect:/locais/";
	}
	
	@GetMapping("/{id}/edit")
	public String editarLocal(@PathVariable("id") Integer id, ModelMap model) {
		Local local = service.procuraPorId(id);
		model.addAttribute("local", local);
		return "/locais/add";
		
	}
	
	@PostMapping("/edit")
	public String editarLocal(Local local, RedirectAttributes attr) {
		service.editar(local);
		attr.addFlashAttribute("success", "Local editado com sucesso!");
		return "redirect:/locais/";
		
	}
	
	@PostMapping("/{id}/delete") @ResponseBody
	public ResponseEntity<String> excluirLocal(@PathVariable("id") Integer id, HttpServletRequest request) {
		service.excluir(id);
		return new ResponseEntity<String>("{\"removido\": \"ok\"}",HttpStatus.OK);
		
	}

}
