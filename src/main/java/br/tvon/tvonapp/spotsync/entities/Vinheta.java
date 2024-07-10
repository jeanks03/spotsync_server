package br.tvon.tvonapp.spotsync.entities;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "vinhetas")
public class Vinheta extends GenericEntity<Integer>{
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	@Column(nullable = false)
	private String arquivo;
	
	@Column(columnDefinition = "TIME")
	private LocalTime duracao;
	
	private String observacoes;
	
	@OneToMany(mappedBy = "vinheta", cascade = CascadeType.ALL)
	private List<VinhetaPlaylist> playlists;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public LocalTime getDuracao() {
		return duracao;
	}

	public void setDuracao(LocalTime duracao) {
		this.duracao = duracao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public List<VinhetaPlaylist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<VinhetaPlaylist> playlists) {
		this.playlists = playlists;
	}
	
	
	
	

}
