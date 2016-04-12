package abd.p1.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class MensajeInvitacion extends Mensaje{
	
	//@Column
	//@OneToOne
	//private Pregunta pregunta;
	
	public MensajeInvitacion(){
		super();
	}
	public MensajeInvitacion(Integer id, boolean leido, Date timestamp) {
		super(id, leido, timestamp);
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
