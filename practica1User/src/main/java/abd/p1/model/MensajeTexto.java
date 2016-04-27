package abd.p1.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class MensajeTexto extends Mensaje{

	@Column
	private String texto;
	
	public MensajeTexto(){
		super();
	}
	
	public MensajeTexto(Integer id, boolean leido, Date timestamp) {
		super(id, leido, timestamp);
		this.texto = null;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "MensajeTexto [texto=" + texto + "]";
	}

}
