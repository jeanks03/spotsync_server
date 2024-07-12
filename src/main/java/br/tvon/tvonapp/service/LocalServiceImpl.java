package br.tvon.tvonapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.tvon.tvonapp.repositories.LocalRepository;
import br.tvon.tvonapp.spotsync.entities.Local;


@Service @Transactional(readOnly = true)
public class LocalServiceImpl implements LocalService{

	@Autowired
	private LocalRepository repository;
	
	@Override
	@Transactional(readOnly = false)
	public void salvar(Local local) {
		repository.save(local);
		
	}

	@Override
	public Local procuraPorId(Integer id) {
		return repository.findById(id).orElse(null);
		
	}

	@Override
	@Transactional(readOnly = false)
	public void editar(Local local) {
		repository.save(local);
		
	}

	@Override
	@Transactional(readOnly = false)
	public void excluir(Integer id) {
		Local l = repository.findById(id).orElse(null);
		repository.delete(l);
	
	}

	@Override
	public List<Local> buscaTodos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
