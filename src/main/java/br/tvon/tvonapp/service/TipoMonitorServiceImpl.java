package br.tvon.tvonapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.tvon.tvonapp.repositories.TipoMonitorRepository;
import br.tvon.tvonapp.spotsync.entities.TipoMonitor;

@Service
public class TipoMonitorServiceImpl implements TipoMonitorService{
	
	@Autowired
	TipoMonitorRepository repository;

	@Override
	public void salvar(TipoMonitor tipoMonitor) {
		repository.save(tipoMonitor);
		
	}

	@Override
	public TipoMonitor procuraPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<TipoMonitor> buscaTodos() {
		return repository.findAll();
	}

	@Override
	public void editar(TipoMonitor tipoMonitor) {
		repository.save(tipoMonitor);
		
	}

	@Override
	public void excluir(Integer id) {
		TipoMonitor tipo = this.procuraPorId(id);
		if(tipo == null) {
			repository.delete(tipo);
		}
		
	}

}
