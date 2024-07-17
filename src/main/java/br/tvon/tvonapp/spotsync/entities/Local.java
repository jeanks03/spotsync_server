package br.tvon.tvonapp.spotsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "spt_locais")
public class Local extends GenericEntity<Integer>{
	
	
	@Column(nullable = false, unique = true)
	@NotBlank(message = "Nome não pode ser vazio")
	@Size(min = 3, max = 255, message = "Nome não pode ter menos que {min} e mais que {max} caracteres")
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
