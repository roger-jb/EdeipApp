package fr.rogerleoen.edeipapp.objets;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jean-Baptiste on 17/05/2016.
 */
public class Eleve extends Utilisateur {
    protected Integer idNiveau;

    public Integer getIdEleve() {
        return idUtilisateur;
    }

    public Integer getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Integer idNiveau) {
        this.idNiveau = idNiveau;
    }
}
