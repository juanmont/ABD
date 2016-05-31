package abd.p1.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class MensajeAmistad extends Mensaje{
	
	@Column
	private boolean aceptado;
	
	public MensajeAmistad(){
		super();
	}
	public MensajeAmistad(Usuario usu, Usuario amigo){
		super(usu, amigo);
		aceptado = true;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	@Override
	public String toString() {
		return "MensajeAmistad [aceptado=" + aceptado + "]";
	}
	
	
	

}
