package abd.p1.controller;

import org.hibernate.SessionFactory;

import abd.p1.DAO.DAOLogin;

public class LoginController {

	private DAOLogin dao;
	public LoginController(SessionFactory sf) {
		dao = new DAOLogin(sf);
	}

	public boolean login(String email, String password) {
		return dao.login(email, password);
	}
}
