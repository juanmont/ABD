/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author adrianpanaderogonzalez
 */
public class AvatarPanel extends javax.swing.JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int SIZE = 64;
    private static final ImageIcon defaultIcon = new ImageIcon(AvatarPanel.class.getResource("homer.png"));
    
    private ImageIcon icon;
    private Image rescaledIcon;
    
    public AvatarPanel() {
        this(defaultIcon);
    }
    
    
    /**
     * Creates new form AvatarPanel
     */
    public AvatarPanel(ImageIcon icon) {
        this.setPreferredSize(new Dimension(SIZE, SIZE));
        this.icon = icon;
        this.rescaledIcon = icon.getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT);
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
        this.rescaledIcon = icon.getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT);
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(rescaledIcon, 0, 0, this);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
