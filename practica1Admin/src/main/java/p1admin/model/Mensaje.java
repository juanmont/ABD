package p1admin.model;

import java.util.Date;

public abstract class Mensaje {
	protected Integer id;
	protected boolean leido;
	protected Date timestamp;
	
	public Mensaje(Integer id, boolean leido, Date timestamp) {
		this.id = id;
		this.leido = leido;
		this.timestamp = timestamp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isLeido() {
		return leido;
	}

	public void setLeido(boolean leido) {
		this.leido = leido;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", leido=" + leido + ", timestamp=" + timestamp + "]";
	}
	
}
