package fr.rogerleoen.edeipapp.objets;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmModel;

/**
 * Created by Jean-Baptiste on 26/05/2016.
 */
public class Niveau implements RealmModel {
    private Integer idNiveau;
    @SerializedName("libelleNiveau")
    private String libelleNiveau;
    private Integer idModule;

}
