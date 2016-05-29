package fr.rogerleoen.edeipapp.objets;

import io.realm.RealmModel;

/**
 * Created by Jean-Baptiste on 26/05/2016.
 */
public class EleveMatiereNiveau implements RealmModel {
    private Integer idMatiereNiveau;
    private Integer idEleve;

    public Integer getIdMatiereNiveau() {
        return idMatiereNiveau;
    }

    public void setIdMatiereNiveau(Integer idMatiereNiveau) {
        this.idMatiereNiveau = idMatiereNiveau;
    }

    public Integer getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Integer idEleve) {
        this.idEleve = idEleve;
    }
}
