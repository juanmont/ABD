package abd.p1.model;

import javax.persistence.*;

@Entity
@IdClass(IdOpcion.class)
public class Opcion {
	
	@Id
	@ManyToOne
	private Pregunta preguntaMadre;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Integer idOpcion;
	
	@Column
	private int numeroOrden;
	@Column (length = 150)
	private String texto;
	
	public Opcion() {
		
	}

	public Pregunta getPreguntaMadre() {
		return preguntaMadre;
	}

	public void setPreguntaMadre(Pregunta preguntaMadre) {
		this.preguntaMadre = preguntaMadre;
	}

	public int getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public void setIdOpcion(Integer i){
		this.idOpcion = i;
	}
	
	public Integer getIdOpcion(){
		return this.idOpcion;
	}
	
	@Override
	public String toString() {
		return "(" + numeroOrden + ") " + texto;
	}
}
