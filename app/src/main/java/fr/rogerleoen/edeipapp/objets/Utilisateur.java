package fr.rogerleoen.edeipapp.objets;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import io.realm.RealmModel;

/**
 * Created by Jean-Baptiste on 16/05/2016.
 */
public class Utilisateur implements RealmModel {
    @SerializedName("idUtilisateur")
    protected Integer idUtilisateur;
    @SerializedName("nomUtilisateur")
    protected String nomUtilisateur;
    @SerializedName("prenomUtilisateur")
    protected String prenomUtilisateur;
    @SerializedName("adr1Utilisateur")
    protected String adr1Utilisateur;
    @SerializedName("adr2Utilisateur")
    protected String adr2Utilisateur;
    @SerializedName("cpUtilisateur")
    protected String cpUtilisateur;
    @SerializedName("villeUtilisateur")
    protected String villeUtilisateur;
    @SerializedName("actifUtilisateur")
    protected Boolean actifUtilisateur;
    @SerializedName("mailUtilisateur")
    protected String mailUtilisateur;
    @SerializedName("dateNaissanceUtilisateur")
    protected Date dateNaissanceUtilisateur;
    @SerializedName("dateInscriptionUtilisateur")
    protected Date dateInscriptionUtilisateur;

    public Utilisateur(){}
    public Utilisateur(Utilisateur unUtilisateur){
        idUtilisateur = unUtilisateur.getIdUtilisateur();
        nomUtilisateur = unUtilisateur.getNomUtilisateur();
        prenomUtilisateur = unUtilisateur.getPrenomUtilisateur();
        adr1Utilisateur = unUtilisateur.getAdr1Utilisateur();
        adr2Utilisateur = unUtilisateur.getAdr2Utilisateur();
        cpUtilisateur = unUtilisateur.getCpUtilisateur();
        villeUtilisateur = unUtilisateur.getVilleUtilisateur();
        actifUtilisateur = unUtilisateur.getActifUtilisateur();
        mailUtilisateur = unUtilisateur.getMailUtilisateur();
        dateNaissanceUtilisateur = unUtilisateur.getDateNaissanceUtilisateur();
        dateInscriptionUtilisateur = unUtilisateur.getDateInscriptionUtilisateur();
    }

    public void getFromJson(JSONObject jsonObjet) throws JSONException, ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);

        idUtilisateur               = jsonObjet.getInt("idUtilisateur");
        nomUtilisateur              = jsonObjet.getString("idUtilisateur");
        prenomUtilisateur           = jsonObjet.getString("idUtilisateur");
        adr1Utilisateur             = jsonObjet.getString("idUtilisateur");
        adr2Utilisateur             = jsonObjet.getString("idUtilisateur");
        cpUtilisateur               = jsonObjet.getString("idUtilisateur");
        villeUtilisateur            = jsonObjet.getString("idUtilisateur");
        actifUtilisateur            = jsonObjet.getBoolean("idUtilisateur");
        mailUtilisateur             = jsonObjet.getString("idUtilisateur");
        //14\/01\/1984
        dateNaissanceUtilisateur    = dateFormat.parse(jsonObjet.getString("idUtilisateur"));
        dateInscriptionUtilisateur  = dateFormat.parse(jsonObjet.getString("idUtilisateur"));
    }

    public Integer getIdUtilisateur() {
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

    public Boolean getActifUtilisateur() {
        return actifUtilisateur;
    }

    public String getMailUtilisateur() {
        return mailUtilisateur;
    }

    public Date getDateNaissanceUtilisateur() {
        return dateNaissanceUtilisateur;
    }

    public Date getDateInscriptionUtilisateur() {
        return dateInscriptionUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
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

    public void setActifUtilisateur(Boolean actifUtilisateur) {
        this.actifUtilisateur = actifUtilisateur;
    }

    public void setMailUtilisateur(String mailUtilisateur) {
        this.mailUtilisateur = mailUtilisateur;
    }

    public void setDateNaissanceUtilisateur(Date dateNaissanceUtilisateur) {
        this.dateNaissanceUtilisateur = dateNaissanceUtilisateur;
    }

    public void setDateInscriptionUtilisateur(Date dateInscriptionUtilisateur) {
        this.dateInscriptionUtilisateur = dateInscriptionUtilisateur;
    }
}
