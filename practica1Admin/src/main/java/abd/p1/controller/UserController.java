package abd.p1.controller;

import java.util.List;

import org.hibernate.SessionFactory;

import abd.p1.DAO.DAOUsuarios;
import abd.p1.model.Usuario;


public class UserController {


	private DAOUsuarios dao;
	public UserController(SessionFactory sf) {
		dao = new DAOUsuarios(sf);
	}
	
	public Usuario selectUsuarioByEmail(String email){
		return dao.selectUsuariobyEmail(email);
	}

	public List<String> selectAficionesByUsuario(String email) {
		return dao.selectAficionesByUsuario(email);
	}
}
