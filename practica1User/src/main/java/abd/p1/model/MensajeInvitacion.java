package abd.p1.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class MensajeInvitacion extends Mensaje{
	
	@ManyToOne
	private Pregunta pregunta;
	
	public MensajeInvitacion(){
		super();
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MensajeInvitacion [id=" + id + "]";
	}
}
