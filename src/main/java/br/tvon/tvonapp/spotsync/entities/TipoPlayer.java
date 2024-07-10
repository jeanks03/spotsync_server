package br.tvon.tvonapp.spotsync.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "spt_tipos_players")
public class TipoPlayer extends GenericEntity<Integer>{
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	private String descricao;
	
	@OneToMany(mappedBy = "tipoPlayer")
	private List<Player> players;

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

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	
	
	
	

}
