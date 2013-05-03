package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class DBConnection {

    public Connection con;
    private PreparedStatement selectStmt;

    public DBConnection()
            throws SQLException, ClassNotFoundException, Exception {
        Fconect();
    }

    private void Fconect()
            throws ClassNotFoundException, SQLException, Exception {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/RATP", "amidouch", "izan2112!");
    }

    public void FCLOSEconecta() throws ClassNotFoundException, SQLException {
        if (con != null) {
            con.close();
            con = null;
        }
    }

    public ResultSet Requete1()
            throws SQLException, ClassNotFoundException, Exception {
        /* Construction de la requete */
        StringBuilder stmt = new StringBuilder();
        stmt.append("SELECT lignes.numero,station.nom,station.commune,lignes.type ");
        stmt.append("FROM lignes, station ");
        stmt.append("WHERE lignes.id = station.id and lignes.type='metro';");
        
        /* Execution et traitement de la requete */
        selectStmt = con.prepareStatement(stmt.toString());
        ResultSet rs = selectStmt.executeQuery();
        return rs;
    }

    /** Les stations de metro */
    public LinkedList<Station> getMetroStations()
            throws SQLException, ClassNotFoundException {
        /* Construction de la requete */
        StringBuilder stmt = new StringBuilder();
        stmt.append("SELECT * ");
        stmt.append("FROM station ");
        stmt.append("WHERE type = 'metro';");
        
        /* Execution et traitement de la requete */
        selectStmt = con.prepareStatement(stmt.toString());
        ResultSet results = selectStmt.executeQuery();
        LinkedList<Station> stations = new LinkedList<Station>();
        while (results.next()) {
            stations.add(new Station(results.getInt("id"),
                    results.getDouble("latitude"),
                    results.getDouble("longitude"),
                    results.getString("nom"),
                    results.getString("commune"),
                    results.getString("type")));
        }
        return stations;
    }

    /**
     * Récupère les lignes de métro depuis la base de donnée.
     * @return Une liste des lignes de métro.
     * @throws SQLException Lorsque la requête SQL échoue.
     * @throws ClassNotFoundException Lorsque une classe n'est pas trouvée.
     */
    public LinkedList<Ligne> getMetroLignes()
            throws SQLException, ClassNotFoundException {
        /* Construction de la requete */
        StringBuilder stmt = new StringBuilder();
        stmt.append("SELECT DISTINCT numero, type ");
        stmt.append("FROM lignes ");
        stmt.append("WHERE type = 'metro' ");
        stmt.append("ORDER BY numero ASC ;");
        
        /* Execution et traitement de la requete */
        selectStmt = con.prepareStatement(stmt.toString());
        ResultSet results = selectStmt.executeQuery();
        LinkedList<Ligne> lignes = new LinkedList<Ligne>();
        while (results.next()) {
            lignes.add(new Ligne(results.getString("numero"), 
                    results.getString("type")));
        }
        return lignes;
    }

    /**
     * Récupère La latitude minimum de la base de donnée.
     * @return La latitude minimum
     * @throws SQLException Requête SQL qui échoue.
     * @throws ClassNotFoundException Une classe n'est pas trouvée.
     */
    public double getMinX()
            throws SQLException, ClassNotFoundException {
        /* Construction de la requete */
        StringBuilder stmt = new StringBuilder();
        stmt.append("SELECT min(longitude) ");
        stmt.append("FROM station ");
        stmt.append("WHERE type = 'metro'; ");
        
        /* Execution et traitement de la requete */
        selectStmt = con.prepareStatement(stmt.toString());
        ResultSet results = selectStmt.executeQuery();
        if (results.next()) {
            return results.getDouble(1);
        } else {
            return 0;
        }
    }

    public double getMinY()
            throws SQLException, ClassNotFoundException {
        /* Construction de la requete */
        StringBuilder stmt = new StringBuilder();
        stmt.append("SELECT min(latitude) ");
        stmt.append("FROM station ");
        stmt.append("WHERE type = 'metro'; ");
        
        /* Execution et traitement de la requete */
        selectStmt = con.prepareStatement(stmt.toString());
        ResultSet results = selectStmt.executeQuery();
        if (results.next()) {
            return results.getDouble(1);
        } else {
            return 0;
        }
    }

    public double getMaxX()
            throws SQLException, ClassNotFoundException {
        /* Construction de la requete */
        StringBuilder stmt = new StringBuilder();
        stmt.append("SELECT max(longitude) ");
        stmt.append("FROM station ");
        stmt.append("WHERE type = 'metro'; ");
        
        /* Execution et traitement de la requete */
        selectStmt = con.prepareStatement(stmt.toString());
        ResultSet results = selectStmt.executeQuery();
        if (results.next()) {
            return results.getDouble(1);
        } else {
            return 0;
        }
    }

    public double getMaxY()
            throws SQLException, ClassNotFoundException {
        /* Construction de la requete */
        StringBuilder stmt = new StringBuilder();
        stmt.append("SELECT max(latitude) ");
        stmt.append("FROM station ");
        stmt.append("WHERE type = 'metro'; ");
        
        /* Execution et traitement de la requete */
        selectStmt = con.prepareStatement(stmt.toString());
        ResultSet results = selectStmt.executeQuery();
        if (results.next()) {
            return results.getDouble(1);
        } else {
            return 0;
        }
    }
}
