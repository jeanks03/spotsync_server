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
@Table(name = "playlists")
public class Playlist extends GenericEntity<Integer>{
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	@Column(columnDefinition = "TIME", name = "hora_inicio")
	private LocalTime horaInicio;
	
	@Column(columnDefinition = "TIME", name = "hora_fim")
	private LocalTime horaFim;
	
	private String observacoes;
	
	@OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
	private List<VinhetaPlaylist> vinhetas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(LocalTime horaFim) {
		this.horaFim = horaFim;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public List<VinhetaPlaylist> getVinhetas() {
		return vinhetas;
	}

	public void setVinhetas(List<VinhetaPlaylist> vinhetas) {
		this.vinhetas = vinhetas;
	}
	
	
	

}
