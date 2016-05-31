package abd.p1.controller;

import java.util.List;

import org.hibernate.SessionFactory;

import abd.p1.DAO.DAOUsuarios;
import abd.p1.model.MensajeAmistad;
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
	
	public List<Usuario> selectAmigosByEmail(String email) {
		return dao.selectFriendsPerUser(email);
	}
	
	public void insertUser(Usuario u){
		dao.insertUser(u);
	}
	
	public void deleteUser(String email){
		dao.deleteUser(email);
	}
	
	public void updateUser(String email, Usuario c){
		dao.updateUser(email, c);
	}

	public void nuevoMensajeAmistad(MensajeAmistad mensajeAmistad) {
		dao.nuevoMensajeAmistad(mensajeAmistad);
		
	}

}
