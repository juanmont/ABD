package abd.p1.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

import abd.p1.model.Opcion;

public class RespuestaCellRenderer extends ElementoListaRespuestas implements ListCellRenderer<Opcion>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final Color AZULILLO = new Color(200, 200, 255);
	
    @Override
    public Component getListCellRendererComponent(JList<? extends Opcion> list, Opcion value, 
            int index, boolean isSelected, boolean cellHasFocus) {
        String text = value.getTexto();
        int order = value.getNumeroOrden();
        this.setText(order + ". " + text);
        if (isSelected) {
            this.setBackground(AZULILLO);
        } else {
        	this.setBackground(Color.WHITE);
        }
        return this;
    }
}
