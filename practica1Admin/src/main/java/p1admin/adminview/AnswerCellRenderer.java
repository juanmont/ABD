package p1admin.adminview;


import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import p1admin.model.Opcion;

/**
 * Renderizador de una de las preguntas.
 * 
 * @author Manuel Montenegro (mmontene@ucm.es)
 */
public class AnswerCellRenderer extends JLabel implements ListCellRenderer<Opcion> {

	private static final long serialVersionUID = 1L;

	public AnswerCellRenderer() {
		this.setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Opcion> list, Opcion value, int index,
			boolean isSelected, boolean cellHasFocus) {
		String text = value.getTexto();
		int order = value.getNumeroOrden();
		this.setText(order + ". " + text);
		if (isSelected) {
			this.setBackground(QuestionCellRenderer.AZULILLO);
		} else {
			this.setBackground(Color.WHITE);
		}
		return this;
	}

}
