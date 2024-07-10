package br.tvon.tvonapp.spotsync.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "vinhetas_playlists")
public class VinhetaPlaylist extends GenericEntity<Long>{
	
	@ManyToOne
	@JoinColumn(name = "vinheta_id")
	private Vinheta vinheta;
	
	@ManyToOne
	@JoinColumn(name = "playlist_id")
	private Playlist playlist;
	
	private int ordem;

	public Vinheta getVinheta() {
		return vinheta;
	}

	public void setVinheta(Vinheta vinheta) {
		this.vinheta = vinheta;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	
	

}
