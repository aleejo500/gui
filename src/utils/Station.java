package utils;

/**
 * Classe modélisant une station de metro
 */
public class Station {

    /**
     * Identifiant de la station
     */
    private int id;
    /**
     * Latitude de la station
     */
    private double latitude;
    /**
     * Longitude de la station
     */
    private double longitude;
    /**
     * Nom de la station
     */
    private String nom;
    /**
     * Nom de la commune ou se trouve la station
     */
    private String commune;
    /**
     * Le type de station : metro, bus, rer, tramway ...
     */
    private String type;

    /**
     * Constructeur
     */
    public Station(int id, double latitude, double longitude,
            String nom, String commune, String type) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nom = nom;
        this.commune = commune;
        this.type = type;
    }

    /**
     * Retourne le nom de la station
     */
    public String getNom() {
        return nom;
    }

    public double getX() {
        return longitude;
    }

    public double getY() {
        return latitude;
    }

    @Override
    public String toString() {
        return nom ;
    }
}
