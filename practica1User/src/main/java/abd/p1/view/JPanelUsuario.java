package abd.p1.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import abd.p1.controller.ListUserController;
import abd.p1.controller.UserController;
import abd.p1.model.Usuario;

public class JPanelUsuario extends JPanel{

	private DefaultListModel<Usuario> modelo;
	private ListUserController controlListaUsuarios;
	private Usuario u;
	private UserController controlUsuarios;
	private AvatarPanel2 userPanel;
	private boolean pregunta;
	private VentanaUsuario vUsuario;
	
	public JPanelUsuario(UserController controlUsuarios, ListUserController controlListaUsuarios, Usuario u, boolean pregunta){
    	initComponents(controlListaUsuarios);
        this.u = u;
        this.controlUsuarios = controlUsuarios;
        this.controlListaUsuarios = controlListaUsuarios;
        this.pregunta = pregunta;
		modelo = new DefaultListModel<>();
        List<Usuario> l = this.controlListaUsuarios.getAllUsers(u.getEmail());
        for(Usuario usuario: l){
        	//System.out.println(CalculadorDistancias.calculaDistanca(u.getLatitud(), u.getLongitud(), usuario.getLatitud(), usuario.getLongitud()));
        	modelo.addElement(usuario);
        }
        listaUsuarios.setModel(modelo);
        listaUsuarios.setCellRenderer(new UsuarioCellRenderer());
        if(pregunta){
        	jButtonModificarPerfil.setText("Aceptar");
        	jButtonVerPerfil.setText("Cancelar");
        }
        else
        	this.setVisible(true);
	}
	
	private void initComponents(ListUserController controlListaUsuarios){
		
        jScrollPane1 = new javax.swing.JScrollPane();
        listaUsuarios = new javax.swing.JList<>();
        jCheckBoxNombre = new javax.swing.JCheckBox();
        jTextFieldNombre = new javax.swing.JTextField();
        jCheckBoxAmigos = new javax.swing.JCheckBox();
        jButtonModificarPerfil = new javax.swing.JButton();
        jButtonVerPerfil = new javax.swing.JButton();
        
        jTextFieldNombre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jCheckBoxNombre.isSelected()){
					String name = jTextFieldNombre.getText();
			    	List<Usuario> lista = new ArrayList<Usuario>();
			    	if(name != ""){
			    		lista = controlListaUsuarios.getAllUsersWithName(name, u.getContacto(), u.getGenero());
			    		modelo.removeAllElements();
			    		 for(Usuario usuario: lista){
			    	        	modelo.addElement(usuario);
			    	        }
			    	}
				}// TODO Auto-generated method stub
				
			}
		});
		
        jScrollPane1.setViewportView(listaUsuarios);

        jCheckBoxNombre.setText("Filtrar por nombre:");
        jCheckBoxNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxNombreActionPerformed(evt);
            }
        });

        jCheckBoxAmigos.setText("Mostrar sólo amigos");
        jCheckBoxAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAmigosActionPerformed(evt);
            }
        });

        jButtonModificarPerfil.setText("Modificar mi perfil");
        jButtonModificarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarPerfilActionPerformed(evt);
            }
        });

        jButtonVerPerfil.setText("Ver perfil seleccionado");
        jButtonVerPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerPerfilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUsuariosLayout = new javax.swing.GroupLayout(this);
        this.setLayout(jPanelUsuariosLayout);
        jPanelUsuariosLayout.setHorizontalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButtonModificarPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonVerPerfil)
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuariosLayout.createSequentialGroup()
                .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelUsuariosLayout.createSequentialGroup()
                        .addComponent(jCheckBoxNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNombre))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelUsuariosLayout.createSequentialGroup()
                        .addComponent(jCheckBoxAmigos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanelUsuariosLayout.setVerticalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxAmigos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModificarPerfil)
                    .addComponent(jButtonVerPerfil))
                .addContainerGap())
        );
		
	}
	
	 protected void jCheckBoxNombreActionPerformed(ActionEvent evt) {
			//modelo.addElement(controlUsuarios.selectUsuarioByEmail(jTextFieldNombre.getText()));
		}

		private void jCheckBoxAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAmigosActionPerformed
	        // TODO add your handling code here:
	    }//GEN-LAST:event_jCheckBoxAmigosActionPerformed

	    private void jButtonModificarPerfilActionPerformed(ActionEvent evt) {
		    	Usuario u2 = controlUsuarios.selectUsuarioByEmail(u.getEmail());
		    	if(u2 != null)
		    		u2.setAficiones(controlUsuarios.selectAficionesByUsuario(u2.getEmail()));
		    	userPanel = new AvatarPanel2(null, true, u2, true, controlUsuarios, null);
		    	userPanel.setVisible(true);
	    	
		}
	    
	    private void jButtonVerPerfilActionPerformed(java.awt.event.ActionEvent evt) {
		    	Usuario u2 = listaUsuarios.getSelectedValue();
		    	if(u2 != null){
			    	u2.setAficiones(controlUsuarios.selectAficionesByUsuario(u2.getEmail()));//GEN-FIRST:event_jButtonVerPerfilActionPerformed
			    	vUsuario = new VentanaUsuario(null, true, u2, false, controlUsuarios, u);
			    	vUsuario.setSize(new Dimension(600,600));
			    	vUsuario.setVisible(true);
		    	}
		    	else{
		    		JOptionPane.showMessageDialog(null, "Debes seleccionar un usuario de la lista", "Error", JOptionPane.ERROR_MESSAGE);
		    	}
	    }
	
	 private javax.swing.JButton jButtonModificarPerfil;
	    private javax.swing.JButton jButtonVerPerfil;
	    private javax.swing.JCheckBox jCheckBoxAmigos;
	    private javax.swing.JCheckBox jCheckBoxNombre;
	 private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JList<Usuario> listaUsuarios;
}
