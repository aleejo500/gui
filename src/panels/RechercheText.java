package panels;

import java.awt.Dimension;
import java.util.ResourceBundle;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import listeners.RechercheListener;
import listeners.SearchStationListener;

/** Panel correspondant à l'onglet 
de recherche d'une station de metro */
public class RechercheText extends JPanel {

    /** Bouton qui lance la recherche. */
    JButton searchButton;
    /** Le champ de texte dans lequel sera entré la recherche. */
    JComboBox<String> searchField;

    /** Constructeur sans argument */
    public RechercheText() {
        /* Gestion du layout */
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        /* Ajout des ressource bundle */
        ResourceBundle label = ResourceBundle.getBundle("LabelBundle");
        ResourceBundle button = ResourceBundle.getBundle("ButtonBundle");

        /* Création des composants */
        searchButton = new JButton(button.getString("textSearchButton"));
        searchButton.addActionListener(new RechercheListener());
        searchField = new JComboBox<String>(new DefaultComboBoxModel<String>());
        searchField.setPreferredSize(new Dimension(350, 20));
        searchField.setEditable(true);
        searchField.getEditor().getEditorComponent()
                .addKeyListener(new SearchStationListener(searchField));

        /* Placement des composants */
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        add(new JLabel(label.getString("textSearchLabel")), c);

        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(searchField, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        add(searchButton, c);
    }
}
