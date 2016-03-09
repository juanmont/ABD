package p1admin.model;

import java.util.Date;

public class MensajeTexto extends Mensaje{

	private Integer id;
	private String texto;
	
	
	public MensajeTexto(Integer id, boolean leido, Date timestamp) {
		super(id, leido, timestamp);
		this.id = id;
		this.texto = null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "MensajeTexto [id=" + id + ", texto=" + texto + "]";
	}

}
