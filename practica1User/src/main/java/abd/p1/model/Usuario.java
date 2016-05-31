package abd.p1.model;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {
	@Id
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String nombre;
	@Enumerated(EnumType.ORDINAL)
	private Genero genero;
	@Enumerated(EnumType.ORDINAL)
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
	@ElementCollection
	private Set<Usuario> amigos;
	
	public Usuario(){
		aficiones = new ArrayList<String>();
		amigos = new HashSet<Usuario>();
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
	
	public int getEdad(){
		return calcularEdad(fecha_nacimiento);
	}
	
	public void addAficion(String a){
		aficiones.add(a);
	}
	
	public void deleteAficion(String a){
		aficiones.remove(a);
	}
	
	public void updateAficion(String aOld, String aNew){
		aficiones.add(aficiones.indexOf(aOld), aNew);
	}

	public List<String> getAficiones() {
		return aficiones;
	}

	public void setAficiones(List<String> aficiones) {
		this.aficiones = aficiones;
	}
	
	public Set<Usuario> getAmigos() {
		return amigos;
	}
	
	public void addAmigo(Usuario amigo){
		amigos.add(amigo);
	}
	
	public void removeAmigo(Usuario amigo){
		amigos.remove(amigo);
	}

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
	
	public int calcularEdad(Date fecha) {
		if(fecha != null){
		Calendar birth = new GregorianCalendar();
		Calendar today = new GregorianCalendar();
		int age=0;
		int factor=0;
		Date birthDate=fecha;
		Date currentDate=new Date(); //current date
		birth.setTime(birthDate);
		today.setTime(currentDate);
		if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
			if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
				if (today.get(Calendar.DATE) > birth.get(Calendar.DATE)) {
					factor = -1; //Aun no celebra su cumpleaÃ±os
				}
			} else {
				factor = -1; //Aun no celebra su cumpleaÃ±os
			}
		}
			age=(today.get(Calendar.YEAR)-birth.get(Calendar.YEAR))+factor;
			if(age < 0)
				return 0;
			return age;
		}
		return 0;
		}

	public void setAmigos(Set<Usuario> selectAmigosByEmail) {
		// TODO Auto-generated method stub
			for(Usuario u: selectAmigosByEmail)
				this.amigos.add(u);

	}

}
