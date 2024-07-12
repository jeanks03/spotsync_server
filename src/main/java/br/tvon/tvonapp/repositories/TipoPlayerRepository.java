package br.tvon.tvonapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.tvon.tvonapp.spotsync.entities.TipoPlayer;


@Repository
public interface TipoPlayerRepository extends JpaRepository<TipoPlayer, Integer>{

}
