package abd.p1.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import abd.p1.model.Usuario;

public class DAOUsuarios {
	private SessionFactory sf;
	public DAOUsuarios(SessionFactory sf) {
		this.sf = sf;
	}
	
	public Usuario selectUsuariobyEmail(String email){
		Session sesion = this.sf.openSession();
		Usuario u = (Usuario) sesion.get(Usuario.class, email);
		sesion.close();
		return u;
		
	}

	public List<String> selectAficionesByUsuario(String email) {
		Session sesion = this.sf.openSession();
		Query query = sesion.createQuery("select elements(u.aficiones) from Usuario u Where u.email = :email");
		query.setString("email", email);
		List<String> l = query.list();
		sesion.close();
		return l;
	}
	
	public List<Usuario> selectAmigosByEmail(String email) {
		Session sesion = this.sf.openSession();
		Query query = sesion.createQuery("select elements(u.amigos) from Usuario u Where u.email = :email");
		query.setString("email", email);
		List<Usuario> l = query.list();
		sesion.close();
		return l;
	}
	
	public void insertUser(Usuario u){
		Session sesion = this.sf.openSession();
		Transaction tr = sesion.beginTransaction();
		sesion.save(u);
		tr.commit();
		sesion.close();
	}
	
	public void deleteUser(String email){
		Session sesion = this.sf.openSession();
		Transaction tr = sesion.beginTransaction();
		 Usuario u = (Usuario) sesion.get(Usuario.class, email);
		 sesion.delete(u);
		 tr.commit();
		 sesion.close();
	}
	
	public void updateUser(String email, Usuario cambio){
		Session sesion = this.sf.openSession();
		Transaction tr = sesion.beginTransaction();
		Usuario u = (Usuario) sesion.get(Usuario.class, email);
		
		//CAMBIAMOS LOS VALORES QUE EL USUARIO HA DECIDIDO CAMBIAR
		if(cambio.getContacto() != null)
			u.setContacto(cambio.getContacto());
		
		if(cambio.getDescripcion() != null)
			u.setDescripcion(cambio.getDescripcion());
		
		if(cambio.getFecha_nacimiento()!= null)
			u.setFecha_nacimiento(cambio.getFecha_nacimiento());
		
		if(cambio.getGenero() != null)
			u.setGenero(cambio.getGenero());
		
		if(cambio.getImagen() != null)
			u.setImagen(cambio.getImagen());
		
		if(cambio.getLatitud() != 0.0)
			u.setLatitud(cambio.getLatitud());
		
		if(cambio.getLongitud() != 0.0)
			u.setLongitud(cambio.getLongitud());
		
		if(cambio.getNombre() != null)
			u.setNombre(cambio.getNombre());
		
		if(cambio.getPassword() != null)
			u.setPassword(cambio.getPassword());
		////////////////////////////////////////////////////////////
		
		tr.commit();
	}

	public void updateAficionesUser(String email, List<String> lista) {
		Session sesion = this.sf.openSession();
			Query query = sesion.createQuery("Update elements(u.aficiones) from Usuario u SET elements(u.:lista) Where u.email = :email");
			query.setParameterList("lista", lista);
			query.setString("email", email);
		sesion.close();
	}
	
}