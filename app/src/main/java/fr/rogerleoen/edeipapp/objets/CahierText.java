package fr.rogerleoen.edeipapp.objets;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import io.realm.RealmModel;

/**
 * Created by Jean-Baptiste on 18/05/2016.
 */
public class CahierText implements RealmModel{
    private Integer idCahierTexte;
    private Integer idMatiereNiveau;
    @SerializedName("dateRealisation")
    private Date dateRealisation;
    @SerializedName("contenuCahierTexte")
    private String contenuCahierTexte;
    private Integer idRedacteur;
    @SerializedName("dateRedaction")
    private Date dateRedaction;

    @Override
    public String toString(){
        return this.idCahierTexte+" "+contenuCahierTexte.length();
    }

    public Integer getIdCahierTexte() {
        return idCahierTexte;
    }

    public void setIdCahierTexte(Integer idCahierTexte) {
        this.idCahierTexte = idCahierTexte;
    }

    public Integer getIdMatiereNiveau() {
        return idMatiereNiveau;
    }

    public void setIdMatiereNiveau(Integer idMatiereNiveau) {
        this.idMatiereNiveau = idMatiereNiveau;
    }

    public Date getDateRealisation() {
        return dateRealisation;
    }

    public void setDateRealisation(Date dateRealisation) {
        this.dateRealisation = dateRealisation;
    }

    public String getContenuCahierTexte() {
        return contenuCahierTexte;
    }

    public void setContenuCahierTexte(String contenuCahierTexte) {
        this.contenuCahierTexte = contenuCahierTexte;
    }

    public Integer getIdRedacteur() {
        return idRedacteur;
    }

    public void setIdRedacteur(Integer idRedacteur) {
        this.idRedacteur = idRedacteur;
    }

    public Date getDateRedaction() {
        return dateRedaction;
    }

    public void setDateRedaction(Date dateRedaction) {
        this.dateRedaction = dateRedaction;
    }
}
