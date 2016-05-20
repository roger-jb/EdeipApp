package fr.rogerleoen.edeipapp;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import fr.rogerleoen.edeipapp.asyncWebService.AsyncWebService;
import fr.rogerleoen.edeipapp.asyncWebService.CahierTextWebService;
import fr.rogerleoen.edeipapp.objets.Connexion;
import fr.rogerleoen.edeipapp.objets.Utilisateur;

/**
 * Created by Jean-Baptiste on 03/05/2016.
 */
public class SingletonPersonne {
    private static SingletonPersonne ourInstance = new SingletonPersonne();

    public static void setUtilisateur(Utilisateur utilisateur) {
        SingletonPersonne.utilisateur = utilisateur;
    }

    private static Utilisateur utilisateur = new Utilisateur();
    private static boolean estConnecte = false;
    private static String login = "";
    public static boolean bConnexion = false;

    public static void setLesConnexions(Collection<Connexion> lesConnexions) {
        SingletonPersonne.lesConnexions = lesConnexions;
    }

    public static void addConnexion (Connexion uneConnexion){
        Boolean found = false;
        for (Connexion laConnexion :
                lesConnexions) {
            if (laConnexion.getLoginUtilisateur().equals(uneConnexion.getLoginUtilisateur())){
                found = true;
                break;
            }
        }
        if (!found)
            lesConnexions.add(uneConnexion);
    }

    private static Collection<Connexion> lesConnexions;

    public static SingletonPersonne getInstance() {
        return ourInstance;
    }
    public static Utilisateur getUtilisateur(){return utilisateur;}

    private SingletonPersonne() {
        lesConnexions = new ArrayList<>();
        lesConnexions = AsyncWebService.getListConnexion();
        Log.e("CahierTextContent", "Chargement liste");
        CahierTextWebService.getListCahierText();
        Log.e("CahierTextContent", "Chargement listeTerminé");
    }

    public static boolean connexion(String login, String password){
        SingletonPersonne.login = login;
        estConnecte = true;
        bConnexion = false;
        return estConnecte;
    }

    public static Collection<Connexion> getLesConnexions() {
        return lesConnexions;
    }

    public static void setUtilisateurById(Integer unIdUtilisateur) {
        AsyncWebService.getUtilisateurById(unIdUtilisateur);
        login = SingletonPersonne.getUtilisateur().getNomUtilisateur();
    }

    public static boolean isConnected() {
        return estConnecte;
    }

    public static void Deconnexion() {
        utilisateur = new Utilisateur();
        estConnecte = false;
    }

    public String getLogin() {
        return login;
    }
}
