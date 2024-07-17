package br.tvon.tvonapp.spotsync.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "spt_tipos_players")
public class TipoPlayer extends GenericEntity<Integer>{
	
	@Column(nullable = false, unique = true)
	@NotBlank(message = "Nome não pode ser vazio")
	@Size(min = 3, max = 255, message = "Nome não pode ter menos que {min} e mais que {max} caracteres")
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
