package br.tvon.tvonapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.tvon.tvonapp.repositories.PlayerRepository;
import br.tvon.tvonapp.spotsync.entities.Player;

@Service
public class PlayerServiceImpl implements PlayerService{
	
	@Autowired
	PlayerRepository repository;

	@Override
	public void salvar(Player player) {
		repository.save(player);
		
	}

	@Override
	public Player procuraPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Player> buscaTodos() {
		return repository.findAll();
	}

	@Override
	public void editar(Player player) {
		repository.save(player);
		
	}

	@Override
	public void excluir(Integer id) {
		repository.deleteById(id);
		
	}
	
	

}
