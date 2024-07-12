package br.tvon.tvonapp.spotsync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.tvon.tvonapp.service.TipoPlayerService;
import br.tvon.tvonapp.spotsync.entities.TipoPlayer;

@Controller
@RequestMapping("/tipos-players")
public class TipoPlayerController {
	
	@Autowired
	TipoPlayerService service;
	
	
	@GetMapping(value = {"/",""})
	public ModelAndView index() {
		List<TipoPlayer> tipos = service.buscaTodos();
		ModelAndView mv = new ModelAndView("/tipos-players/index");
		mv.addObject("tiposPlayers", tipos);
		return mv;
		
	}
	
	@GetMapping("/add")
	public ModelAndView adicionarTipoPlayer(TipoPlayer tipoPlayer) {
		ModelAndView mv = new ModelAndView("/tipos-players/add");
		return mv;
	}
	
	@PostMapping("/add")
	public String adicionarTipoPlayer(TipoPlayer tipoPlayer, RedirectAttributes attr) {
		service.salvar(tipoPlayer);
		attr.addFlashAttribute("success", "Tipo salvo com sucesso!");
		return "redirect:/tipos-players";
	}
	
	@GetMapping("/{id}/edit")
	public ModelAndView editarTipoPlayer(@PathVariable("id") Integer id) {
		TipoPlayer tp = service.procuraPorId(id);
		ModelAndView mv = new ModelAndView("/tipos-players/add");
		mv.addObject("tipoPlayer", tp);
		return mv;
	}
	
	@PostMapping("/edit")
	public String editarTipoPlayer(TipoPlayer tipoPlayer, RedirectAttributes attr) {
		service.salvar(tipoPlayer);
		attr.addFlashAttribute("success", "Tipo editado com sucesso!");
		return "redirect:/tipos-players"; 
	}
	
	@PostMapping("/{id}/delete") @ResponseBody
	public ResponseEntity<String> excluirTipoPlayer(@PathVariable("id") Integer id) {
		service.excluir(id);
		
		return new ResponseEntity<String>("{\"removido\": \"ok\"}",HttpStatus.OK);
		
	}

}
