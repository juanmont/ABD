package abd.p1.view;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import abd.p1.controller.UserController;
import abd.p1.model.CalculadorDistancias;
import abd.p1.model.Usuario;

import javax.swing.JButton;

public class VentanaUsuario extends javax.swing.JDialog{

	private JLabel labelDistancia;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentanaUsuario(Frame parent, boolean modal, Usuario u, boolean miPerfil, UserController c, Usuario uSesion) {
		
		JTabbedPane jTabbedPaneUsuario = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(jTabbedPaneUsuario, BorderLayout.NORTH);
		
		UserPanel jPanelPerfil = new UserPanel(u, miPerfil, c, uSesion);
		jPanelPerfil.setVisible(true);
		jPanelPerfil.setSize(new Dimension(500,500));
		
		jTabbedPaneUsuario.addTab("Perfil", jPanelPerfil);
		
		JPanel jPanelCompatibilidad = new JPanel();
		jTabbedPaneUsuario.addTab("Compatibilidad", null, jPanelCompatibilidad, null);
		
		JPanel jPanelChat = new JPanel();
		jTabbedPaneUsuario.addTab("Chat", null, jPanelChat, null);
		
		int d = (int) CalculadorDistancias.calculaDistanca(uSesion.getLatitud(), uSesion.getLongitud(), u.getLatitud(), u.getLongitud()); 
		labelDistancia = new JLabel("Distancia: " +d+ "m");
		labelDistancia.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(labelDistancia, BorderLayout.CENTER);
		
		JButton buttonAmistad = new JButton("Enviar petición de amistad");
		buttonAmistad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAmistadActionPerformed(evt);
            }

			private void buttonAmistadActionPerformed(ActionEvent evt) {
				
			}
        });
		getContentPane().add(buttonAmistad, BorderLayout.EAST);
		//this.setVisible(true);
		//this.setPreferredSize(new Dimension(600, 600));
		// TODO Auto-generated constructor stub
		this.pack();
	}
}
