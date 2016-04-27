package abd.p1.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import abd.p1.model.Usuario;

public class DAOListaUsuarios {
	private SessionFactory sf;
	
	public DAOListaUsuarios(SessionFactory sf) {
		this.sf = sf;
	}

	public List<Usuario> getAllUsers() {
		Session sesion = this.sf.openSession();
		Query query = sesion.createQuery("From Usuario");
		List<Usuario> l = query.list();
		sesion.close();
		return l;
	}

	public List<Usuario> getAllUsersWithName(String name) {
		Session sesion = this.sf.openSession();
		Query query = sesion.createQuery("From Usuario As u WHERE u.nombre = :name");
		query.setString("name", name);
		List<Usuario> l = query.list();
		sesion.close();
		return l;
	}

}
