package abd.p1.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class ListaUsuariosPregunta extends JDialog{

	public ListaUsuariosPregunta(java.awt.Frame parent, boolean modal,JPanel p){
		this.setLayout(new BorderLayout());
		this.add(p, BorderLayout.CENTER);
		this.setVisible(true);
	}
}
