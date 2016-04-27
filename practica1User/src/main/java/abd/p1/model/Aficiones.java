package abd.p1.model;

import javax.persistence.*;

@Entity
public class Aficiones {
	
	
	private String email;
	
	private String aficiones;
	
	public Aficiones(String email, String aficiones) {
		this.email = email;
		this.aficiones = aficiones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAficiones() {
		return aficiones;
	}

	public void setAficiones(String aficiones) {
		this.aficiones = aficiones;
	}

	@Override
	public String toString() {
		return "Aficiones [email=" + email + ", aficiones=" + aficiones + "]";
	}
	
}
