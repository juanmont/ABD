package abd.p1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
public class Contesta implements Serializable{
	@Id
	@ManyToOne
	private Usuario usuario;
	@Id
	@ManyToOne
	private Opcion opcionMadre;
	@Column
	private int relevancia;
	

	public Contesta(){
		opcionMadre = null;
	}
	
	public Contesta(Usuario u, Opcion o, int relev){
		this.usuario = u;
		this.opcionMadre = o;
		this.relevancia = relev;
	}

	public Opcion getOpcionMadre() {
		return opcionMadre;
	}

	public void setOpcionMadre(Opcion opcionMadre) {
		this.opcionMadre = opcionMadre;
	}

	public int getRelevancia() {
		return relevancia;
	}

	public void setRelevancia(int relevancia) {
		this.relevancia = relevancia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
