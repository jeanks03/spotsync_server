package br.tvon.tvonapp.service;

import java.util.List;

import br.tvon.tvonapp.spotsync.entities.Player;

public interface PlayerService {
	
	public void salvar(Player player);

	public Player procuraPorId(Integer id);

	public List<Player> buscaTodos();

	public void editar(Player player);

	public void excluir(Integer id);

}
