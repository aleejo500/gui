/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import javax.swing.JCheckBox;

/**
 *
 * @author amidouch
 */
public class StationComponent extends JCheckBox {
    private static final int DIAMETRE = 20;
    private int x;
    private int y;

    public StationComponent(int x, int y) {
        this.x = x - (DIAMETRE / 2);
        this.y = y - (DIAMETRE / 2);
        setBounds(this.x, this.y, DIAMETRE, DIAMETRE);
    }
}
