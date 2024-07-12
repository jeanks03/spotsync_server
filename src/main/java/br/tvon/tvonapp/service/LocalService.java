package br.tvon.tvonapp.service;

import java.util.List;

import br.tvon.tvonapp.spotsync.entities.Local;

public interface LocalService {
	
	public void salvar(Local local);
	
	public Local procuraPorId(Integer id);
	
	public List<Local> buscaTodos();
	
	public void editar(Local local);
	
	public void excluir(Integer id);

}
