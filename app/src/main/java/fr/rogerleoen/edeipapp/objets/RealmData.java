package fr.rogerleoen.edeipapp.objets;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.lang.reflect.Type;
import java.util.Collection;

import fr.rogerleoen.edeipapp.asyncWebService.AsyncWebService;
import io.realm.RealmList;

/**
 * Created by Jean-Baptiste on 26/05/2016.
 */
public class RealmData extends AsyncWebService{
    public static RealmList<Matiere> lesMatieres;
    public static RealmList<Niveau> lesNiveaux;
    public static RealmList<MatiereNiveau> lesMatiereNiveau;
    public static RealmList<Utilisateur> lesUtilisateurs;
    public static RealmList<Eleve> lesEleves;
    public static RealmList<Responsable> lesResponsables;
    public static RealmList<Professeur> lesProfesseurs;
    public static RealmList<Administrateur> lesAdministrateurs;
    public static RealmList<Connexion> lesConnexions;
    public static RealmList<EleveResponsable> lesElevesResponsable;
    public static RealmList<CarnetLiaison> lesCarnetLiaisons;
    public static RealmList<EleveMatiereNiveau> lesEleveMatiereNiveau;
    public static RealmList<ProfesseurMatiereNiveau> lesProfesseurMatiereNiveau;
    public static RealmList<CahierText> lesCahierTexte;

    public static void Populate(){
        getAllMatiere();
        getAllNiveau();
        getAllMatiereNiveau();
        getAllUtilisateurs();
        getAllEleves();
        getAllResponsable();
        getAllProfesseur();
        getAllAdminstrateur();
        getAllConnexion();
        getAllEleveResponsable();
        getAllCarnetLiaison();
        getAllEleveMatiereNiveau();
        getAllProfesseurMatiereNiveau();
        getAllCahierTexte();
    }

    private static void getAllMatiere(){
        String url = "api/RealData.php";
        client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllMatiere");
        client.get(baseUrl + url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                String retour = HtmlDecodePost(response);
                Collection<Matiere> desMatieres;
                lesMatieres = new RealmList<Matiere>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Matiere>>(){}.getType();
                    desMatieres = gRetour.fromJson(retour, collectionType);
                    for (Matiere uneMatiere :
                            desMatieres) {
                        lesMatieres.add(uneMatiere);
                    }
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des Matieres");
                }
            }
        });
    }

    private static void getAllNiveau() {
        String url = "api/RealData.php";
        client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllNiveau");
        client.get(baseUrl + url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                String retour = HtmlDecodePost(response);
                Collection<Niveau> desNiveaux;
                lesNiveaux = new RealmList<Niveau>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Niveau>>(){}.getType();
                    desNiveaux = gRetour.fromJson(retour, collectionType);
                    for (Niveau unNiveau :
                            desNiveaux) {
                        lesNiveaux.add(unNiveau);
                    }
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des Niveaux");
                }
            }
        });
    }

    private static void getAllMatiereNiveau() {
        String url = "api/RealData.php";
        client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllMatiereNiveau");
        client.get(baseUrl + url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                String retour = HtmlDecodePost(response);
                Collection<MatiereNiveau> desMatieresNiveaux;
                lesMatiereNiveau = new RealmList<MatiereNiveau>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Niveau>>(){}.getType();
                    desMatieresNiveaux = gRetour.fromJson(retour, collectionType);
                    for (MatiereNiveau unMatiereNiveau :
                            desMatieresNiveaux) {
                        lesMatiereNiveau.add(unMatiereNiveau);
                    }
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des MatieresNiveau");
                }
            }
        });
    }

    private static void getAllUtilisateurs() {
        String url = "api/RealData.php";
        client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllUtilisateur");
        client.get(baseUrl + url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                String retour = HtmlDecodePost(response);
                Collection<Utilisateur> desUtiisateurs;
                lesUtilisateurs = new RealmList<Utilisateur>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Utilisateur>>(){}.getType();
                    desUtiisateurs = gRetour.fromJson(retour, collectionType);
                    for (Utilisateur unUtilisateur :
                            desUtiisateurs) {
                        lesUtilisateurs.add(unUtilisateur);
                    }
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des Utilisateurs");
                }
            }
        });
    }

    private static void getAllEleves() {
        String url = "api/RealData.php";
        client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllEleve");
        client.get(baseUrl + url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                String retour = HtmlDecodePost(response);
                Collection<Eleve> desEleves;
                lesEleves = new RealmList<Eleve>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Eleve>>(){}.getType();
                    desEleves = gRetour.fromJson(retour, collectionType);
                    for (Eleve unEleve :
                            desEleves) {
                        lesEleves.add(unEleve);
                    }
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des Matieres");
                }
            }
        });
    }

    private static void getAllResponsable() {
        String url = "api/RealData.php";
        client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllResponsable");
        client.get(baseUrl + url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                String retour = HtmlDecodePost(response);
                Collection<Responsable> desResponsable;
                lesResponsables = new RealmList<Responsable>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Responsable>>(){}.getType();
                    desResponsable = gRetour.fromJson(retour, collectionType);
                    for (Responsable unResponsable :
                            desResponsable) {
                        lesResponsables.add(unResponsable);
                    }
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des Responsable");
                }
            }
        });
    }

    private static void getAllProfesseur() {
        String url = "api/RealData.php";
        client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllProfesseur");
        client.post(baseUrl + url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                String retour = HtmlDecodePost(response);
                Collection<Professeur> desProfesseurs;
                lesProfesseurs = new RealmList<Professeur>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Professeur>>(){}.getType();
                    desProfesseurs = gRetour.fromJson(retour, collectionType);
                    for (Professeur unProfesseur :
                            desProfesseurs) {
                        lesProfesseurs.add(unProfesseur);
                    }
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des Professeurs");
                }
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e("RealmData", "Erreur dans l'appel WS des Professeurs");
            }
        });
    }

    private static void getAllCahierTexte() {
        String url = "api/RealData.php";
        client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllCahierTexte");
        client.post(baseUrl + url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                String retour = HtmlDecodePost(response);
                Collection<CahierText> desCahierTexte;
                lesCahierTexte = new RealmList<CahierText>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<CahierText>>(){}.getType();
                    desCahierTexte = gRetour.fromJson(retour, collectionType);
                    for (CahierText unCahierText :
                            desCahierTexte) {
                        lesCahierTexte.add(unCahierText);
                    }
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des cahierText");
                }
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e("RealmData", "Erreur dans l'appel WS des cahierText");
            }
        });
    }

    private static void getAllProfesseurMatiereNiveau() {
        String url = "api/RealData.php";
        client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllProfesseurMatiereNiveau");
        client.post(baseUrl + url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                String retour = HtmlDecodePost(response);
                Collection<ProfesseurMatiereNiveau> desCahierTexte;
                lesProfesseurMatiereNiveau = new RealmList<ProfesseurMatiereNiveau>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<CahierText>>(){}.getType();
                    desCahierTexte = gRetour.fromJson(retour, collectionType);
                    for (ProfesseurMatiereNiveau unProfMatiereNiveau :
                            desCahierTexte) {
                        lesProfesseurMatiereNiveau.add(unProfMatiereNiveau);
                    }
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des ProfesseurMatiereNiveau");
                }
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e("RealmData", "Erreur dans l'appel WS des ProfesseurMatiereNiveau");
            }
        });
    }

    private static void getAllEleveMatiereNiveau() {
        String url = "api/RealData.php";
        client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllEleveMatiereNiveau");
        client.post(baseUrl + url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                String retour = HtmlDecodePost(response);
                Collection<EleveMatiereNiveau> desEleveMatiereNiveau;
                lesEleveMatiereNiveau = new RealmList<EleveMatiereNiveau>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<EleveMatiereNiveau>>(){}.getType();
                    desEleveMatiereNiveau = gRetour.fromJson(retour, collectionType);
                    for (EleveMatiereNiveau unEleveMatiereNiveau :
                            desEleveMatiereNiveau) {
                        lesEleveMatiereNiveau.add(unEleveMatiereNiveau);
                    }
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des EleveMatiereNiveau");
                }
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e("RealmData", "Erreur dans l'appel WS des EleveMatiereNiveau");
            }
        });
    }

    private static void getAllCarnetLiaison() {
        String url = "api/RealData.php";
        client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllCarnetLiaison");
        client.post(baseUrl + url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                String retour = HtmlDecodePost(response);
                Collection<CarnetLiaison> desCarnetLiaisons;
                lesCarnetLiaisons = new RealmList<CarnetLiaison>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<CarnetLiaison>>(){}.getType();
                    desCarnetLiaisons = gRetour.fromJson(retour, collectionType);
                    for (CarnetLiaison unItem :
                            desCarnetLiaisons) {
                        lesCarnetLiaisons.add(unItem);
                    }
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des CarnetLiaison");
                }
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e("RealmData", "Erreur dans l'appel WS des CarnetLiaison");
            }
        });
    }

    private static void getAllEleveResponsable() {
        String url = "api/RealData.php";
        client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllEleveResponsable");
        client.post(baseUrl + url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                String retour = HtmlDecodePost(response);
                Collection<EleveResponsable> desItems;
                lesElevesResponsable = new RealmList<EleveResponsable>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<EleveResponsable>>(){}.getType();
                    desItems = gRetour.fromJson(retour, collectionType);
                    for (EleveResponsable unItem :
                            desItems) {
                        lesElevesResponsable.add(unItem);
                    }
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des ElevesResponsable");
                }
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e("RealmData", "Erreur dans l'appel WS des ElevesResponsable");
            }
        });
    }

    private static void getAllConnexion() {
        String url = "api/RealData.php";
        client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllConnexion");
        client.post(baseUrl + url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                String retour = HtmlDecodePost(response);
                Collection<Connexion> desItems;
                lesConnexions = new RealmList<Connexion>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Connexion>>(){}.getType();
                    desItems = gRetour.fromJson(retour, collectionType);
                    for (Connexion unItem :
                            desItems) {
                        lesConnexions.add(unItem);
                    }
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des ElevesResponsable");
                }
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e("RealmData", "Erreur dans l'appel WS des ElevesResponsable");
            }
        });
    }

    private static void getAllAdminstrateur() {
        String url = "api/RealData.php";
        client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("get", "AllAdminstrateur");
        client.post(baseUrl + url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                String retour = HtmlDecodePost(response);
                Collection<Administrateur> desItems;
                lesAdministrateurs = new RealmList<Administrateur>();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Administrateur>>(){}.getType();
                    desItems = gRetour.fromJson(retour, collectionType);
                    for (Administrateur unItem :
                            desItems) {
                        lesAdministrateurs.add(unItem);
                    }
                } catch (Throwable t){
                    Log.e("RealmData", "Erreur dans la recuperation des Administrateurs");
                }
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e("RealmData", "Erreur dans l'appel WS des Administrateurs");
            }
        });
    }

    public static RealmList<Matiere> getLesMatieres() {
        return lesMatieres;
    }

    public static void setLesMatieres(RealmList<Matiere> lesMatieres) {
        RealmData.lesMatieres = lesMatieres;
    }

    public static RealmList<Niveau> getLesNiveaux() {
        return lesNiveaux;
    }

    public static void setLesNiveaux(RealmList<Niveau> lesNiveaux) {
        RealmData.lesNiveaux = lesNiveaux;
    }

    public static RealmList<MatiereNiveau> getLesMatiereNiveau() {
        return lesMatiereNiveau;
    }

    public static void setLesMatiereNiveau(RealmList<MatiereNiveau> lesMatiereNiveau) {
        RealmData.lesMatiereNiveau = lesMatiereNiveau;
    }

    public static RealmList<Utilisateur> getLesUtilisateurs() {
        return lesUtilisateurs;
    }

    public static void setLesUtilisateurs(RealmList<Utilisateur> lesUtilisateurs) {
        RealmData.lesUtilisateurs = lesUtilisateurs;
    }

    public static RealmList<Eleve> getLesEleves() {
        return lesEleves;
    }

    public static void setLesEleves(RealmList<Eleve> lesEleves) {
        RealmData.lesEleves = lesEleves;
    }

    public static RealmList<Responsable> getLesResponsables() {
        return lesResponsables;
    }

    public static void setLesResponsables(RealmList<Responsable> lesResponsables) {
        RealmData.lesResponsables = lesResponsables;
    }

    public static RealmList<Professeur> getLesProfesseurs() {
        return lesProfesseurs;
    }

    public static void setLesProfesseurs(RealmList<Professeur> lesProfesseurs) {
        RealmData.lesProfesseurs = lesProfesseurs;
    }

    public static RealmList<Administrateur> getLesAdministrateurs() {
        return lesAdministrateurs;
    }

    public static void setLesAdministrateurs(RealmList<Administrateur> lesAdministrateurs) {
        RealmData.lesAdministrateurs = lesAdministrateurs;
    }

    public static RealmList<Connexion> getLesConnexions() {
        return lesConnexions;
    }

    public static void setLesConnexions(RealmList<Connexion> lesConnexions) {
        RealmData.lesConnexions = lesConnexions;
    }

    public static RealmList<EleveResponsable> getLesElevesResponsable() {
        return lesElevesResponsable;
    }

    public static void setLesElevesResponsable(RealmList<EleveResponsable> lesElevesResponsable) {
        RealmData.lesElevesResponsable = lesElevesResponsable;
    }

    public static RealmList<CarnetLiaison> getLesCarnetLiaisons() {
        return lesCarnetLiaisons;
    }

    public static void setLesCarnetLiaisons(RealmList<CarnetLiaison> lesCarnetLiaisons) {
        RealmData.lesCarnetLiaisons = lesCarnetLiaisons;
    }

    public static RealmList<EleveMatiereNiveau> getLesEleveMatiereNiveau() {
        return lesEleveMatiereNiveau;
    }

    public static void setLesEleveMatiereNiveau(RealmList<EleveMatiereNiveau> lesEleveMatiereNiveau) {
        RealmData.lesEleveMatiereNiveau = lesEleveMatiereNiveau;
    }

    public static RealmList<ProfesseurMatiereNiveau> getLesProfesseurMatiereNiveau() {
        return lesProfesseurMatiereNiveau;
    }

    public static void setLesProfesseurMatiereNiveau(RealmList<ProfesseurMatiereNiveau> lesProfesseurMatiereNiveau) {
        RealmData.lesProfesseurMatiereNiveau = lesProfesseurMatiereNiveau;
    }

    public static RealmList<CahierText> getLesCahierTexte() {
        return lesCahierTexte;
    }

    public static void setLesCahierTexte(RealmList<CahierText> lesCahierTexte) {
        RealmData.lesCahierTexte = lesCahierTexte;
    }
}
