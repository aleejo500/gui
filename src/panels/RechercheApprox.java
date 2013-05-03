package panels;

import java.util.ResourceBundle;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import listeners.RechercheApproxListener;

/** Panel correspondant à la recherche 
approximative d'une station de metro */
public class RechercheApprox extends JPanel {

    /** Bouton qui lance la recherche */
    JButton searchButton;
    /** Le champ de texte dans lequel sera entré la recherche */
    JTextField searchField;

    /** Constructeur sans argument */
    public RechercheApprox() {
        /* Gestion du layout */
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        /* Creation des Bundles */
        ResourceBundle button = ResourceBundle.getBundle("ButtonBundle");
        ResourceBundle label = ResourceBundle.getBundle("LabelBundle");

        /* Création des composants */
        searchButton = new JButton(button.getString("approxSearchButton"));
        searchButton.addActionListener(new RechercheApproxListener());
        searchField = new JTextField(30);

        /* Ajout des composants */
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        add(new JLabel(label.getString("approxSearchLabel")), c);

        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        add(searchField, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        add(searchButton, c);
    }
}
