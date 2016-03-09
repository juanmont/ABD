package p1admin.model;

import java.util.Date;

public class MensajeInvitacion extends Mensaje{
	
	private Integer id;
	
	public MensajeInvitacion(Integer id, boolean leido, Date timestamp) {
		super(id, leido, timestamp);
		
		this.id = id;
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
