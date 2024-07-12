package br.tvon.tvonapp.service;

import java.util.List;

import br.tvon.tvonapp.spotsync.entities.TipoPlayer;

public interface TipoPlayerService {
	
public void salvar(TipoPlayer tipoPlayer);
	
	public TipoPlayer procuraPorId(Integer id);
	
	public List<TipoPlayer> buscaTodos();
	
	public void editar(TipoPlayer tipoPlayer);
	
	public void excluir(Integer id);
	

}
