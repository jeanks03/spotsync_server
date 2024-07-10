package br.tvon.tvonapp.spotsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "spt_locais")
public class Local extends GenericEntity<Integer>{
	
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	@OneToOne
	@JoinColumn(name="player_id")
	private Player player;
	
	@OneToOne
	@JoinColumn(name="monitor_id")
	private Monitor monitor;
	
	private String descricao;

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
