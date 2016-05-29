package fr.rogerleoen.edeipapp.objets;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmModel;

/**
 * Created by Jean-Baptiste on 26/05/2016.
 */
public class Matiere implements RealmModel {
    private Integer idMatiere;
    @SerializedName("libelleMatiere")
    private String libelleMatiere;

    public Integer getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Integer idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getLibelleMatiere() {
        return libelleMatiere;
    }

    public void setLibelleMatiere(String libelleMatiere) {
        this.libelleMatiere = libelleMatiere;
    }
}
