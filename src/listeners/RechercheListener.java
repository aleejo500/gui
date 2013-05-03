package listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import frames.FenetreMetro;

public class RechercheListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        FenetreMetro fm = new FenetreMetro();
    }
}
