package br.tvon.tvonapp.service;

import java.util.List;

import br.tvon.tvonapp.spotsync.entities.TipoMonitor;

public interface TipoMonitorService {
	
	public void salvar(TipoMonitor tipoMonitor);

	public TipoMonitor procuraPorId(Integer id);

	public List<TipoMonitor> buscaTodos();

	public void editar(TipoMonitor tipoMonitor);

	public void excluir(Integer id);

}
