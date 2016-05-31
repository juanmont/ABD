package abd.p1.view;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JDialog;

import abd.p1.controller.ListUserController;
import abd.p1.controller.UserController;
import abd.p1.model.Usuario;

public class listaUsuarioPreguntas extends JDialog{

	public listaUsuarioPreguntas(Frame parent, boolean modal,UserController controlUsuarios, ListUserController controlListaUsuarios, boolean pregunta, Usuario u){
		super(parent, modal);
		this.setLayout(new BorderLayout());
		this.add(new JPanelUsuario(controlUsuarios, controlListaUsuarios, u, pregunta), BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}
}
