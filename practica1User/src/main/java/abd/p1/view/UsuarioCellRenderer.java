/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import abd.p1.model.Usuario;

/**
 *
 * @author adrianpanaderogonzalez
 */
public class UsuarioCellRenderer extends ElementoListaUsuario implements ListCellRenderer<Usuario>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<? extends Usuario> lista, Usuario value, int index, 
                boolean isSelected, boolean cellHasFocus) {
			if(value.getImagen() != null)
				setImagen(new ImageIcon(value.getImagen()));
            this.setNombre(value.getNombre());
            this.setEdad(value.calcularEdad(value.getFecha_nacimiento()));
            this.setOpaque(true);
            if (isSelected) {
                this.setBackground(Color.GRAY);
            } else {
                this.setBackground(Color.WHITE);
            }
            return this; 
	}
    
}
