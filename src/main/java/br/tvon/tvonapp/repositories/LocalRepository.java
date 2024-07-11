package br.tvon.tvonapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.tvon.tvonapp.spotsync.entities.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Integer>{

}
