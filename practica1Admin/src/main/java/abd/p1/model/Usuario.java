package abd.p1.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuario {
	@Id
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private Genero genero;
	@Column(nullable = false)
	private Contacto contacto;
	@Column(nullable = false)
	private double latitud;
	@Column(nullable = false)
	private double longitud;
	@Temporal(TemporalType.DATE)
	private Date fecha_nacimiento;
	@Lob
	private byte[] imagen;
	@ElementCollection
	private List<String> aficiones;
	@Column(nullable = true, length = 200)
	private String descripcion;
	
	public Usuario(){
		aficiones = new ArrayList<String>();
	}
	public Usuario(String email, String password, String nombre, Genero genero, Contacto contacto, double latitud,
			 double longitud, Date fecha_nacimiento, byte[] imagen, List<Aficiones> aficiones, String descripcion) {
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.genero = genero;
		this.contacto = contacto;
		this.latitud = latitud;
		this.longitud = longitud;
		this.fecha_nacimiento = fecha_nacimiento;
		this.imagen = imagen;
		//this.aficiones = aficiones;
		this.descripcion = descripcion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	/*public List<Aficiones> getAficiones() {
		return aficiones;
	}

	public void setAficiones(List<Aficiones> aficiones) {
		this.aficiones = aficiones;
	}*/

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Usuario [email=" + email + ", password=" + password + ", nombre=" + nombre + ", genero=" + genero
				+ ", contacto=" + contacto + ", latitud=" + latitud + ", longitud=" + longitud + ", fecha_nacimiento="
				+ fecha_nacimiento + ", imagen=" + Arrays.toString(imagen) + ", aficiones=" + aficiones
				+ ", descripcion=" + descripcion + "]";
	}

}
