package p1admin.adminview;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

import p1admin.model.Pregunta;

/**
 * Renderizador de una celda de la lista de preguntas.
 *
 * @author Manuel Montenegro (mmontene@ucm.es)
 */
public class QuestionCellRenderer extends QuestionPanel implements ListCellRenderer<Pregunta> {
	private static final long serialVersionUID = 1L;
	static final Color AZULILLO = new Color(200, 200, 255);

	@Override
	public Component getListCellRendererComponent(JList<? extends Pregunta> list, Pregunta value, int index,
			boolean isSelected, boolean cellHasFocus) {
		this.setElement(value);
        if (isSelected) {
            this.setBackground(AZULILLO);
        } else {
            this.setBackground(Color.WHITE);
        }
		return this;
	}
}
