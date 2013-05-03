package panels;

import java.util.ResourceBundle;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/** Barre de menu de la fenêtre principale */
public class MenuPrincipal extends JMenuBar {

    /** Constructeur sans argument */
    public MenuPrincipal() {
        super();

        ResourceBundle texts = ResourceBundle.getBundle("MenuBundle");

        JMenu file = new JMenu(texts.getString("file"));

        JMenuItem quit = new JMenuItem(texts.getString("quit"));
        quit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        file.add(quit);

        add(file);
    }
}
