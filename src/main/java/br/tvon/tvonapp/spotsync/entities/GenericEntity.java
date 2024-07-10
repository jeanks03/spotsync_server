package br.tvon.tvonapp.spotsync.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class GenericEntity <PK extends Serializable> implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private PK id;

	public PK getId() {
		return id;
	}

	public void setId(PK id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "GenericEntity [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenericEntity<?> other = (GenericEntity<?>) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	

}
