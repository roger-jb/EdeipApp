package fr.rogerleoen.edeipapp.objets;

import io.realm.RealmModel;

/**
 * Created by Jean-Baptiste on 26/05/2016.
 */
public class EleveResponsable implements RealmModel {
    private Integer idEleve;
    private Integer idReponsble;

    public Integer getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Integer idEleve) {
        this.idEleve = idEleve;
    }

    public Integer getIdReponsble() {
        return idReponsble;
    }

    public void setIdReponsble(Integer idReponsble) {
        this.idReponsble = idReponsble;
    }
}
