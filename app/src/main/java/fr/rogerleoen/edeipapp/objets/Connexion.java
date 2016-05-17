package fr.rogerleoen.edeipapp.objets;

/**
 * Created by Jean-Baptiste on 17/05/2016.
 */
public class Connexion {
    protected Integer idUtilisateur;
    protected String  loginUtilisateur;
    protected String mdpUtilisateur;

    public Connexion() {
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public String getLoginUtilisateur() {
        return loginUtilisateur;
    }

    public String getMdpUtilisateur() {
        return mdpUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public void setLoginUtilisateur(String loginUtilisateur) {
        this.loginUtilisateur = loginUtilisateur;
    }

    public void setMdpUtilisateur(String mdpUtilisateur) {
        this.mdpUtilisateur = mdpUtilisateur;
    }
}
