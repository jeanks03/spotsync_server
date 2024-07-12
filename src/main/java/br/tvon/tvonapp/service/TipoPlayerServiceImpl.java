package br.tvon.tvonapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.tvon.tvonapp.repositories.TipoPlayerRepository;
import br.tvon.tvonapp.spotsync.entities.TipoPlayer;


@Service
public class TipoPlayerServiceImpl implements TipoPlayerService{
	
	@Autowired
	TipoPlayerRepository repository;

	@Override
	public void salvar(TipoPlayer tipoPlayer) {
		repository.save(tipoPlayer);
		
	}

	@Override
	public TipoPlayer procuraPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<TipoPlayer> buscaTodos() {
		return repository.findAll();
	}

	@Override
	public void editar(TipoPlayer tipoPlayer) {
		repository.save(tipoPlayer);
		
	}

	@Override
	public void excluir(Integer id) {
		TipoPlayer tp = this.procuraPorId(id);
		if ( tp != null ) {
			if (tp.getPlayers().isEmpty()) {
				repository.delete(tp);
			}
		}
		
	}

}
