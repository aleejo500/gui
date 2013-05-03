package frames;

import javax.swing.JFrame;
import panels.PlanMetro;

/** Classe qui affiche le plan du metro */
public class FenetreMetro extends JFrame {

    /** Constructeur */
    public FenetreMetro() {
        setTitle("Plan du métro");
        getContentPane().add(new PlanMetro(1000, 600));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
