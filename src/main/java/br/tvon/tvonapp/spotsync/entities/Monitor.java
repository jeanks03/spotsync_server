package br.tvon.tvonapp.spotsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "spt_monitores")
public class Monitor extends GenericEntity<Integer>{
	
	@Column(nullable = false, unique = true)
	private String patrimonio;
	
	@ManyToOne
	@JoinColumn(name = "tipo_monitor_id")
	private TipoMonitor tipoMonitor;
	
	@Column(name = "is_offine")
	private boolean isOffline;
	
	@OneToOne
	@JoinColumn(name = "player_id")
	private Player player;
	
	@OneToOne
	@JoinColumn(name = "local_id")
	private Local local;
	
	private String observacoes;

	public String getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public TipoMonitor getTipoMonitor() {
		return tipoMonitor;
	}

	public void setTipoMonitor(TipoMonitor tipoMonitor) {
		this.tipoMonitor = tipoMonitor;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public boolean isOffline() {
		return isOffline;
	}

	public void setOffline(boolean isOffline) {
		this.isOffline = isOffline;
	}
	
	
	
	

}
