package panels;

import java.util.ResourceBundle;
import java.awt.CardLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;

/** Panel correspondant à l'onglet 
de recherche d'une station de metro */
public class Recherche extends JPanel implements ItemListener {

    private JPanel cards;

    /** Constructeur sans argument */
    public Recherche() {
        /* Chargement des ResourceBundle */
        ResourceBundle comboText = ResourceBundle.getBundle("ComboTxtBundle");
        ResourceBundle label = ResourceBundle.getBundle("LabelBundle");

        String TEXTUELLE = comboText.getString("text");
        String LIGNE = comboText.getString("ligne");
        String APPROX = comboText.getString("approx");

        /* Creation de la combo box */
        JPanel comboBoxPane = new JPanel();
        String[] cbitems = {TEXTUELLE, LIGNE, APPROX};
        JComboBox<String> cb = new JComboBox<String>(cbitems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);

        /* JPanel de la selection */
        JPanel select = new JPanel();
        select.add(new JLabel(label.getString("comboBoxLabel")));
        select.add(comboBoxPane);

        /* Panel de la fonction de recherche */
        cards = new JPanel(new CardLayout());
        cards.add(new RechercheText(), TEXTUELLE);
        cards.add(new RechercheList(), LIGNE);
        cards.add(new RechercheApprox(), APPROX);

        /* Ajout au panel courant */
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(select);
        add(cards);
    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) evt.getItem());
    }
}
