package utils;

/* Classe qui modélise une ligne de transport */
public class Ligne {

    /**
     * Identifiant de la ligne.
     */
    private String id;
    /**
     * Le numéro de la ligne extrait de la base de donnée
     */
    private String numero;
    /**
     * Le type de ligne : metro, bus, rer, tramway ...
     */
    private String type;

    /**
     * Le constructeur
     *
     * @param numero Le numero extrait de la base de donnée.
     * @param type Le type extrait de la base de donnée.
     */
    public Ligne(String numero, String type) {
        this.numero = numero;
        this.id = processNumero(numero);
        this.type = type;
    }

    /**
     * Getter pour le numero de la ligne.
     *
     * @return Le numero de ligne tel qu'il est extrait de la base de donnée.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Getter pour l'identifiant de la ligne.
     *
     * @return L'identifiant de la ligne.
     */
    public String getId() {
        return id;
    }

    /**
     * Getter pour le type de la ligne.
     *
     * @return Le type de la ligne
     */
    public String getType() {
        return type;
    }

    /**
     * Analyse le numéro de la base de donnée pour extraire l'id de la ligne.
     *
     * @param num Le numero extrait de la base de donnée.
     * @return L'identifiant de la ligne.
     */
    private String processNumero(String num) {
        StringBuilder builder = new StringBuilder();

        int i = 0;
        while ((num.charAt(i) != ' ') && (i < num.length())) {
            builder.append(num.charAt(i));
            i++;
        }

        return builder.toString();
    }

    @Override
    public String toString() {
        return id;
    }
}
