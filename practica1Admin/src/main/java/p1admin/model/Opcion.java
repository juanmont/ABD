package p1admin.model;

public class Opcion {
	private Pregunta preguntaMadre;
	private Integer idOpcion;
	private int numeroOrden;
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
		// TODO Auto-generated method stub
		return "(" + numeroOrden + ") " + texto;
	}
}
