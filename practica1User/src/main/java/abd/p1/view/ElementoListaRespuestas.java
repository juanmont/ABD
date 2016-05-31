/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view;


/**
 *
 * @author adrianpanaderogonzalez
 */
public class ElementoListaRespuestas extends javax.swing.JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int order = 1;
	private String texto = "Texto";

	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
