package abd.p1.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Mensaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	@Column
	protected boolean leido;
	@Temporal(TemporalType.DATE)
	protected Date timestamp;
	@OneToOne
	protected Usuario usuarioEnvia;
	@OneToOne
	protected Usuario usuarioRecibe;
	
	public Mensaje(){
	}
	
	public Mensaje(Usuario usu, Usuario amigo){
		usuarioEnvia = usu;
		usuarioRecibe = amigo;
		leido = false;
		timestamp = new Date();
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
