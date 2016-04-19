package abd.p1.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DAOLogin {
	private SessionFactory sesion;
	public DAOLogin(SessionFactory sf) {
		sesion = sf;
	}
	
	public boolean login(String email, String password) {
		
		Session sesion = this.sesion.openSession();
		Query query = sesion.createQuery("SELECT email FROM Usuario AS a WHERE a.email = :email AND a.password = :password");
		query.setString("email", email);
		query.setString("password", password);
		if(query.uniqueResult() != null) {
			sesion.close();
			return true;
		}
		sesion.close();
		return false;
	}

}
