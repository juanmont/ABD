/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view;

import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

import org.hibernate.SessionFactory;

import abd.p1.controller.ListUserController;
import abd.p1.controller.UserController;
import abd.p1.model.Contacto;
import abd.p1.model.Genero;
import abd.p1.model.Usuario;

/**
 *
 * @author adrianpanaderogonzalez
 */
@SuppressWarnings("serial")
public class VentanaPrincipal extends javax.swing.JFrame {

	private UserController controlUsuarios;
	private Usuario u;
	private AvatarPanel2 userPanel;
	private DefaultListModel<Usuario> modelo;
	private ListUserController controlListaUsuarios;
	
    /**
     * Creates new form VentanaPrincipal
     * @param controlUsuarios 
     * @param u 
     */
    public VentanaPrincipal(Usuario u, UserController controlUsuarios, ListUserController controlListaUsuarios) {
        initComponents();
        this.u = u;
        this.controlUsuarios = controlUsuarios;
        this.controlListaUsuarios = controlListaUsuarios;
        modelo = new DefaultListModel<>();
        List<Usuario> l = this.controlListaUsuarios.getAllUsers();
        for(Usuario usuario: l){
        	modelo.addElement(usuario);
        }
        listaUsuarios.setModel(modelo);
        listaUsuarios.setCellRenderer(new UsuarioCellRenderer());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelUsuarios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaUsuarios = new javax.swing.JList<>();
        jCheckBoxNombre = new javax.swing.JCheckBox();
        jTextFieldNombre = new javax.swing.JTextField();
        jCheckBoxAmigos = new javax.swing.JCheckBox();
        jButtonModificarPerfil = new javax.swing.JButton();
        jButtonVerPerfil = new javax.swing.JButton();
        jPanelPreguntas = new javax.swing.JPanel();
        jPanelMensajes = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        javax.swing.GroupLayout jPanelUsuariosLayout = new javax.swing.GroupLayout(jPanelUsuarios);
        jPanelUsuarios.setLayout(jPanelUsuariosLayout);
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

        jTabbedPane1.addTab("Usuarios", jPanelUsuarios);

        javax.swing.GroupLayout jPanelPreguntasLayout = new javax.swing.GroupLayout(jPanelPreguntas);
        jPanelPreguntas.setLayout(jPanelPreguntasLayout);
        jPanelPreguntasLayout.setHorizontalGroup(
            jPanelPreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );
        jPanelPreguntasLayout.setVerticalGroup(
            jPanelPreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Preguntas", jPanelPreguntas);

        javax.swing.GroupLayout jPanelMensajesLayout = new javax.swing.GroupLayout(jPanelMensajes);
        jPanelMensajes.setLayout(jPanelMensajesLayout);
        jPanelMensajesLayout.setHorizontalGroup(
            jPanelMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );
        jPanelMensajesLayout.setVerticalGroup(
            jPanelMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Mensajes no leídos", jPanelMensajes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    protected void jCheckBoxNombreActionPerformed(ActionEvent evt) {
		//modelo.addElement(controlUsuarios.selectUsuarioByEmail(jTextFieldNombre.getText()));
	}

	private void jCheckBoxAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAmigosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxAmigosActionPerformed

    private void jButtonModificarPerfilActionPerformed(ActionEvent evt) {
    	userPanel = new AvatarPanel2(this, true, u, true, controlUsuarios);
		userPanel.setVisible(true);
		this.setVisible(false);
	}
    
    private void jButtonVerPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVerPerfilActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonModificarPerfil;
    private javax.swing.JButton jButtonVerPerfil;
    private javax.swing.JCheckBox jCheckBoxAmigos;
    private javax.swing.JCheckBox jCheckBoxNombre;
    private javax.swing.JPanel jPanelMensajes;
    private javax.swing.JPanel jPanelPreguntas;
    private javax.swing.JPanel jPanelUsuarios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JList<Usuario> listaUsuarios;
    // End of variables declaration//GEN-END:variables
}
