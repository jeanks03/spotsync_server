package br.tvon.tvonapp.spotsync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.tvon.tvonapp.service.TipoMonitorService;
import br.tvon.tvonapp.spotsync.entities.TipoMonitor;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/tipos-monitores")
public class TipoMonitorController {
	
	@Autowired
	TipoMonitorService service;
	
	
	@GetMapping(value = {"/",""})
	public ModelAndView index() {
		List<TipoMonitor> tipos = service.buscaTodos();
		ModelAndView mv = new ModelAndView("/tipos-monitores/index");
		mv.addObject("tiposMonitores", tipos);
		return mv;
		
	}
	
	@GetMapping("/add")
	public ModelAndView adicionarTipoMonitor(TipoMonitor tipoMonitor) {
		ModelAndView mv = new ModelAndView("/tipos-monitores/add");
		return mv;
	}
	
	@PostMapping("/add")
	public String adicionarTipoMonitor(@Valid TipoMonitor tipoMonitor, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "/tipos-monitores/add";
		}
		service.salvar(tipoMonitor);
		attr.addFlashAttribute("success", "Tipo salvo com sucesso!");
		return "redirect:/tipos-monitores";
	}
	
	@GetMapping("/{id}/edit")
	public ModelAndView editarTipoMonitor(@PathVariable("id") Integer id) {
		TipoMonitor tm = service.procuraPorId(id);
		ModelAndView mv = new ModelAndView("/tipos-monitores/add");
		mv.addObject("tipoMonitor", tm);
		return mv;
	}
	
	@PostMapping("/edit")
	public String editarTipoMonitor(@Valid TipoMonitor tipoMonitor, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "/tipos-monitores/add";
		}
		service.salvar(tipoMonitor);
		attr.addFlashAttribute("success", "Tipo editado com sucesso!");
		return "redirect:/tipos-monitores"; 
	}
	
	@PostMapping("/delete") @ResponseBody
	public ResponseEntity<String> excluirTipoPlayer(@RequestBody IdRequest request) {
		int id = Integer.valueOf(request.getId());
		service.excluir(id);
		return new ResponseEntity<String>("{\"removido\": \"ok\"}",HttpStatus.OK);
		
	}

}
