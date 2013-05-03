package components;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import java.sql.SQLException;
import utils.DBConnection;
import utils.Station;
import java.util.LinkedList;

/** Classe permettant d'utiliser une 
liste avec les stations de metro */
public class StationList extends JList<Station> {

    private DefaultListModel<Station> listModel;
    private LinkedList<Station> stations;

    /** Contructeur sans argument */
    public StationList() {
        listModel = new DefaultListModel<Station>();
        try {
            DBConnection con = new DBConnection();
            stations = con.getMetroStations();
            while (!stations.isEmpty()) {
                listModel.addElement(stations.pop());
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
