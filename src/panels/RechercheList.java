package panels;

import java.util.ResourceBundle;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import components.LigneList;
import components.StationList;

/** Panel correspondant à une recherche en 
selectionnant dans une JList */
public class RechercheList extends JPanel {

    /** Constructeur sans argument */
    public RechercheList() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        ResourceBundle label = ResourceBundle.getBundle("LabelBundle");


        JLabel ligneLabel =
                new JLabel(label.getString("listSearchLineLabel"));
        JScrollPane ligneList = new JScrollPane(new LigneList());

        JLabel stationLabel =
                new JLabel(label.getString("listSearchStationLabel"));
        JScrollPane stationList = new JScrollPane(new StationList());

        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        add(ligneLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        add(stationLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        add(ligneList, c);

        c.gridx = 1;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        add(stationList, c);
    }
}
