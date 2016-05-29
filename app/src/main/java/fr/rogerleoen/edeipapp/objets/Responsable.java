package fr.rogerleoen.edeipapp.objets;

import java.util.ArrayList;
import java.util.Iterator;

import fr.rogerleoen.edeipapp.asyncWebService.AsyncWebService;
import fr.rogerleoen.edeipapp.asyncWebService.ResponsableWebService;

/**
 * Created by Jean-Baptiste on 17/05/2016.
 */
public class Responsable extends Utilisateur {
    private ArrayList<Eleve> lesEleves = null;

    public Responsable(){
        super();
    }

    public Responsable(Utilisateur unUtilisateur){
        super(unUtilisateur);
        ResponsableWebService.getEleves(this);
    }

    public Integer getIdResponsable () {
        return idUtilisateur;
    }

    public ArrayList<Eleve> getEleve(){
        return lesEleves;
    }

    public Eleve getEleveById(Integer idEleve){
        for (Eleve unEleves: lesEleves
             ) {
            if(unEleves.getIdEleve().equals(idEleve)){
                return unEleves;
            }
        }
        return new Eleve();
    }

    public void addEleve(Eleve unEleve) {
        Boolean found = false;
        for (Eleve lEleve :
                lesEleves) {
            if (lEleve.getIdEleve().equals(unEleve.getIdEleve())){
                found = true;
                break;
            }
        }
        if (!found)
            lesEleves.add(unEleve);
    }
}
