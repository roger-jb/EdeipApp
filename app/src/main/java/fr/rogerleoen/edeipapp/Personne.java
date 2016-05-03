package fr.rogerleoen.edeipapp;

/**
 * Created by Jean-Baptiste on 03/05/2016.
 */
public class Personne {
    private static Personne ourInstance = new Personne();

    private static boolean estConnecte = false;
    private static String identifiant = "";

    public static Personne getInstance() {
        return ourInstance;
    }

    private Personne() {
    }

    public static boolean connexion(String login, String password){
        identifiant = login;
        estConnecte = true;

        return estConnecte;
    }

    public boolean isConnected() {
        return estConnecte;
    }
}
