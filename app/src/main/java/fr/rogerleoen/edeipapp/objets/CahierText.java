package fr.rogerleoen.edeipapp.objets;

import java.util.Date;

/**
 * Created by Jean-Baptiste on 18/05/2016.
 */
public class CahierText {
    private Integer idCahierTexte;
    private Integer idMatiereNiveau;
    private String dateRealisation;
    private String contenuCahierTexte;
    private Integer idRedacteur;
    private String dateRedaction;

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

    public String getDateRealisation() {
        return dateRealisation;
    }

    public void setDateRealisation(String dateRealisation) {
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

    public String getDateRedaction() {
        return dateRedaction;
    }

    public void setDateRedaction(String dateRedaction) {
        this.dateRedaction = dateRedaction;
    }
}
