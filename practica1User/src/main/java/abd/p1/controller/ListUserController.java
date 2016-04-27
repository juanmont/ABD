package abd.p1.controller;

import java.util.List;

import org.hibernate.SessionFactory;

import abd.p1.DAO.DAOListaUsuarios;
import abd.p1.model.Contacto;
import abd.p1.model.Usuario;

public class ListUserController {
	
	private DAOListaUsuarios dao;

	
	public ListUserController(SessionFactory sf){
		dao = new DAOListaUsuarios(sf);

	}
	
	public List<Usuario> getAllUsers(){
		return dao.getAllUsers();
	}
	
	public List<Usuario> getAllUsersWithName(String name, Contacto contacto){
		return dao.getAllUsersWithName(name, contacto);
	}
	

}
