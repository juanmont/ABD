package abd.p1.model;

import java.io.Serializable;

public class IdOpcion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pregunta preguntaMadre;
	private Integer idOpcion;
	
	public boolean equals(Object o){
		return o instanceof IdOpcion && preguntaMadre.getId() == ((IdOpcion) o).getPregunta().getId() && ((IdOpcion) o).getIdOpcion() == this.idOpcion;
	}
	
	public int hashCode() {
		
		return idOpcion;
		
	}
	
	public Pregunta getPregunta(){
		return preguntaMadre;
	}
	
	public Integer getIdOpcion(){
		return idOpcion;
	}

}
