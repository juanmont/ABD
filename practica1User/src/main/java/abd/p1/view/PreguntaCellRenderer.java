/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import abd.p1.model.Pregunta;
import java.awt.Color;

/**
 *
 * @author adrianpanaderogonzalez
 */
public class PreguntaCellRenderer extends ElementoListaPreguntas implements ListCellRenderer<Pregunta>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final Color AZULILLO = new Color(200, 200, 255);
	
    @Override
    public Component getListCellRendererComponent(JList<? extends Pregunta> list, Pregunta value, 
            int index, boolean isSelected, boolean cellHasFocus) {
        
        this.setEnunciado(value.getEnunciado());
        this.setNumeroOpciones(value.getOpciones().size());
        this.setOpaque(true);
        if (isSelected) {
            this.setBackground(AZULILLO);
        } else {
            this.setBackground(Color.WHITE);
        }
        
        return this;
    }
    
}
