package frames;

import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import panels.MenuPrincipal;
import panels.Recherche;
import panels.Itineraire;

/** Fenêtre principale de l'application */
public class FenetrePrincipale extends JFrame {

    private JTabbedPane fonctionnalites;

    /** Constructeur sans argument */
    public FenetrePrincipale() {
        super("TransParix");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(new MenuPrincipal());
        ResourceBundle onglet = ResourceBundle.getBundle("OngletBundle");
        fonctionnalites = new JTabbedPane();
        fonctionnalites.add(onglet.getString("search"), new Recherche());
        fonctionnalites.add(onglet.getString("itinerary"), new Itineraire());
        getContentPane().add(fonctionnalites);
        pack();
        setLocationRelativeTo(null);
    }
    
    public void afficher() {
        setVisible(true);
    }
}
