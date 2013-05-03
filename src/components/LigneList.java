package components;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import java.sql.SQLException;
import utils.DBConnection;
import utils.Ligne;
import java.util.LinkedList;

/** Classe permettant d'utiliser une 
liste avec les lignes de metro */
public class LigneList extends JList<Ligne> {

    private DefaultListModel<Ligne> listModel;
    private LinkedList<Ligne> lignes;

    /** Contructeur sans argument */
    public LigneList() {
        listModel = new DefaultListModel<Ligne>();
        try {
            DBConnection con = new DBConnection();
            lignes = con.getMetroLignes();
            while (!lignes.isEmpty()) {
                listModel.addElement(lignes.pop());
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        } catch (Exception ex) {
            System.err.println(ex);
        }
        setModel(listModel);
    }
}
