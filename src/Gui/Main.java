package gui;

import javax.swing.SwingUtilities;
import frames.FenetrePrincipale;

/** Classe contenant la méthode main du package Gui */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {

                    @Override
                    public void run() {
                        FenetrePrincipale fenetre = new FenetrePrincipale();
                        fenetre.afficher();
                    }
                });
    }
}
