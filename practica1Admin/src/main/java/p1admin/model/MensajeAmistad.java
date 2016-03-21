package p1admin.model;

import java.util.Date;

public class MensajeAmistad extends Mensaje{
	private Integer id;
	private boolean aceptado;
	
	public MensajeAmistad(Integer id, boolean leido, Date timestamp) {
		super(id, leido, timestamp);
		
		this.id = id;
		this.aceptado = false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	@Override
	public String toString() {
		return "MensajeAmistad [id=" + id + ", aceptado=" + aceptado + "]";
	}
	
	
	

}
