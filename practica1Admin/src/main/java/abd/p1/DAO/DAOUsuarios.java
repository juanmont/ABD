package abd.p1.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import abd.p1.model.Usuario;

public class DAOUsuarios {
	private SessionFactory sesion;
	public DAOUsuarios(SessionFactory sf) {
		sesion = sf;
	}
	
	public Usuario selectUsuariobyEmail(String email){
		Session sesion = this.sesion.openSession();
		Usuario u = (Usuario) sesion.get(Usuario.class, email);
		return u;
	}

	public List<String> selectAficionesByUsuario(String email) {
		Session sesion = this.sesion.openSession();
		Query query = sesion.createQuery("select elements(u.aficiones) from Usuario u Where u.email = :email");
		query.setString("email", email);
		return query.list();	
	}
	
	public List<Usuario> selectAmigosByEmail(String email) {
		Session sesion = this.sesion.openSession();
		Query query = sesion.createQuery("select elements(u.amigos) from Usuario u Where u.email = :email");
		query.setString("email", email);
		return query.list();	
	}
	
	public void insertUser(Usuario u){
		Session sesion = this.sesion.openSession();
		Transaction tr = sesion.beginTransaction();
		sesion.save(u);
		tr.commit();
	}
	
	public void deleteUser(String email){
		Session sesion = this.sesion.openSession();
		Transaction tr = sesion.beginTransaction();
		 Usuario u = (Usuario) sesion.get(Usuario.class, email);
		 sesion.delete(u);
		 tr.commit();
	}
	
	public void updateUser(String email, Usuario cambio){
		Session sesion = this.sesion.openSession();
		Transaction tr = sesion.beginTransaction();
		Usuario u = (Usuario) sesion.get(Usuario.class, email);
		
		//CAMBIAMOS LOS VALORES QUE EL USUARIO HA DECIDIDO CAMBIAR
		if(cambio.getContacto() != null)
			u.setContacto(cambio.getContacto());
		
		if(cambio.getDescripcion() != "")
			u.setDescripcion(cambio.getDescripcion());
		
		if(cambio.getFecha_nacimiento()!= null)
			u.setFecha_nacimiento(cambio.getFecha_nacimiento());
		
		if(cambio.getGenero() != null)
			u.setGenero(cambio.getGenero());
		
		if(cambio.getImagen() != null)
			u.setImagen(cambio.getImagen());
		
		if(cambio.getLatitud() != -1)
			u.setLatitud(cambio.getLatitud());
		
		if(cambio.getLongitud() != -1)
			u.setLongitud(cambio.getLongitud());
		
		if(cambio.getNombre() != "")
			u.setNombre(cambio.getNombre());
		
		if(cambio.getPassword() != "")
			u.setPassword(cambio.getPassword());
		////////////////////////////////////////////////////////////
		
		tr.commit();
	}
	
}
