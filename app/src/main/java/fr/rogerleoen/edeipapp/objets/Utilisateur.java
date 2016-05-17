package fr.rogerleoen.edeipapp.objets;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Jean-Baptiste on 16/05/2016.
 */
public class Utilisateur {
    protected String idUtilisateur;
    protected String nomUtilisateur;
    protected String prenomUtilisateur;
    protected String adr1Utilisateur;
    protected String adr2Utilisateur;
    protected String cpUtilisateur;
    protected String villeUtilisateur;
    protected String actifUtilisateur;
    protected String mailUtilisateur;
    protected String dateNaissanceUtilisateur;
    protected String dateInscriptionUtilisateur;

    public Utilisateur(){}

    public void getFromJson(JSONObject jsonObjet) throws JSONException {
        idUtilisateur               = jsonObjet.getString("idUtilisateur");
        nomUtilisateur              = jsonObjet.getString("idUtilisateur");
        prenomUtilisateur           = jsonObjet.getString("idUtilisateur");
        adr1Utilisateur             = jsonObjet.getString("idUtilisateur");
        adr2Utilisateur             = jsonObjet.getString("idUtilisateur");
        cpUtilisateur               = jsonObjet.getString("idUtilisateur");
        villeUtilisateur            = jsonObjet.getString("idUtilisateur");
        actifUtilisateur            = jsonObjet.getString("idUtilisateur");
        mailUtilisateur             = jsonObjet.getString("idUtilisateur");
        dateNaissanceUtilisateur    = jsonObjet.getString("idUtilisateur");
        dateInscriptionUtilisateur  = jsonObjet.getString("idUtilisateur");
    }

    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public String getAdr1Utilisateur() {
        return adr1Utilisateur;
    }

    public String getAdr2Utilisateur() {
        return adr2Utilisateur;
    }

    public String getCpUtilisateur() {
        return cpUtilisateur;
    }

    public String getVilleUtilisateur() {
        return villeUtilisateur;
    }

    public String getActifUtilisateur() {
        return actifUtilisateur;
    }

    public String getMailUtilisateur() {
        return mailUtilisateur;
    }

    public String getDateNaissanceUtilisateur() {
        return dateNaissanceUtilisateur;
    }

    public String getDateInscriptionUtilisateur() {
        return dateInscriptionUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public void setAdr1Utilisateur(String adr1Utilisateur) {
        this.adr1Utilisateur = adr1Utilisateur;
    }

    public void setAdr2Utilisateur(String adr2Utilisateur) {
        this.adr2Utilisateur = adr2Utilisateur;
    }

    public void setCpUtilisateur(String cpUtilisateur) {
        this.cpUtilisateur = cpUtilisateur;
    }

    public void setVilleUtilisateur(String villeUtilisateur) {
        this.villeUtilisateur = villeUtilisateur;
    }

    public void setActifUtilisateur(String actifUtilisateur) {
        this.actifUtilisateur = actifUtilisateur;
    }

    public void setMailUtilisateur(String mailUtilisateur) {
        this.mailUtilisateur = mailUtilisateur;
    }

    public void setDateNaissanceUtilisateur(String dateNaissanceUtilisateur) {
        this.dateNaissanceUtilisateur = dateNaissanceUtilisateur;
    }

    public void setDateInscriptionUtilisateur(String dateInscriptionUtilisateur) {
        this.dateInscriptionUtilisateur = dateInscriptionUtilisateur;
    }
}
