package br.tvon.tvonapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.tvon.tvonapp.spotsync.entities.TipoMonitor;


@Repository
public interface TipoMonitorRepository extends JpaRepository<TipoMonitor, Integer>{

}
