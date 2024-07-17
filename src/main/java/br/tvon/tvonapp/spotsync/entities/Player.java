package br.tvon.tvonapp.spotsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name = "players")
public class Player extends GenericEntity<Integer>{
	
	@Column(nullable = false, unique = true)
	@NotBlank(message = "não é possível salvar sem definir o número de patrimônio")
	private String patrimonio;

	@ManyToOne
	@JoinColumn(name = "tipo_player_id")
	private TipoPlayer tipoPlayer;
	
	@ManyToOne
	@JoinColumn(name = "local_id")
	private Local local;
	
	private String observacoes;

	public String getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public TipoPlayer getTipoPlayer() {
		return tipoPlayer;
	}

	public void setTipoPlayer(TipoPlayer tipoPlayer) {
		this.tipoPlayer = tipoPlayer;
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
	
	

}
