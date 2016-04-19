package abd.p1.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import abd.p1.model.Usuario;

public class DAOUsuarios {
	private SessionFactory sesion;
	public DAOUsuarios(SessionFactory sf) {
		sesion = sf;
	}
	
	public Usuario selectUsuariobyEmail(String email){
		Session sesion = this.sesion.openSession();
		Query query = sesion.createQuery("FROM Usuario AS a WHERE a.email = :email");
		query.setString("email", email);
		Usuario u = (Usuario) query.uniqueResult();
		return u;
	}

	public List<String> selectAficionesByUsuario(String email) {
		Session sesion = this.sesion.openSession();
		Query query = sesion.createQuery("select elements(u.aficiones) from Usuario u Where u.email = :email");
		query.setString("email", email);
		return query.list();	
	}
	
}
