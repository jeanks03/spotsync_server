package br.tvon.tvonapp.spotsync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.tvon.tvonapp.service.LocalService;
import br.tvon.tvonapp.service.PlayerService;
import br.tvon.tvonapp.service.TipoPlayerService;
import br.tvon.tvonapp.spotsync.entities.Local;
import br.tvon.tvonapp.spotsync.entities.Player;
import br.tvon.tvonapp.spotsync.entities.TipoPlayer;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/players")
public class PlayerController {
	
	@Autowired
	PlayerService service;
	
	@Autowired
	TipoPlayerService tpService;
	
	@Autowired
	LocalService localService;
	
	@GetMapping(value = {"/",""})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("players/index");
		mv.addObject("players", service.buscaTodos());
		return mv;
	}
	
	
	@GetMapping("/add")
	public String cadastrar(Player player) {
		return "players/add";
	}
	
	@PostMapping("/add")
	public String salvar(@Valid Player player, BindingResult result, RedirectAttributes attr) {
		if ( result.hasErrors()) {
			return "players/add";
		}
		service.salvar(player);
		attr.addFlashAttribute("success", "Player salvo com sucesso!");
		return "redirect:/players";
	}
	
	@GetMapping("/{id}/edit")
	public String editar(@PathVariable int id, ModelMap model) {
		model.addAttribute("player", service.procuraPorId(id));
		return "players/add";
	}
	
	@PostMapping("/edit")
	public String editar(@Valid Player player, BindingResult result, RedirectAttributes attr) {
		if ( result.hasErrors()) {
			return "players/add";
		}
		service.salvar(player);
		attr.addFlashAttribute("success", "Player salvo com sucesso!");
		return "redirect:/players";
	}
	
	@PostMapping("/delete") @ResponseBody
	public ResponseEntity<String> excluirTipoPlayer(@RequestBody IdRequest request) {
		int id = Integer.valueOf(request.getId());
		service.excluir(id);
		return new ResponseEntity<String>("{\"removido\": \"ok\"}",HttpStatus.OK);
		
	}
	
	
	@ModelAttribute("tiposPlayers")
	 public List<TipoPlayer> getTiposPlayer() {
		return tpService.buscaTodos();
	}
	
	@ModelAttribute("locais")
	public List<Local> getLocais() {
		return localService.buscaTodos();
	}

}
