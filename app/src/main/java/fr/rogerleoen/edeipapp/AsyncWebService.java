package fr.rogerleoen.edeipapp;

import android.text.Html;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import fr.rogerleoen.edeipapp.objets.Connexion;
import fr.rogerleoen.edeipapp.objets.Utilisateur;

/**
 * Created by Jean-Baptiste on 15/05/2016.
 */
public class AsyncWebService {
    private static AsyncHttpClient client = new AsyncHttpClient();
    private static SyncHttpClient syncClient = new SyncHttpClient();
    private static String baseUrl = "http://roger-leoen.ddns.net/edeip/";
    //private static String baseUrl = "http://edeip-lyon.fr/";


    private static String HtmlDecodePost(String laChaine){
        return Html.fromHtml(laChaine).toString();
    }


    public static void testGet(final TextView affiche) {
        //String url = baseUrl + "WebService/Bulletin.php?idEleve=24&idMatiere=3&idNiveau=5&idTrimestre=1&action=getByEleveMatiereNiveauTrimestre";
        String url = baseUrl + "api/testPost.php";
        RequestParams params = new RequestParams();
        params.add("login", "AUCLAIR.Céline");
        params.add("pwd","123Soleil");

        client = new AsyncHttpClient();
        client.get(url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                //response = new String(response.getBytes(Charset.forName("ISO-8859-1")), Charset.forName("UTF-8"));
                affiche.setText(HtmlDecodePost(response));
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                affiche.setText( "pb dans le WebService : "+ error.toString());
            }
        });
    }

    public static void testPost(final TextView affiche){
        String url = baseUrl + "api/connexion.php";
        client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("login", "AUCLAIR.Céline");
        params.add("pwd","123Soleil");
        client.post(url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                //response = new String(response.getBytes(Charset.forName("ISO-8859-1")), Charset.forName("UTF-8"));
                affiche.setText(HtmlDecodePost(response));
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                affiche.setText( "pb dans le WebService : "+ error.toString());
            }
        });
    }

    public static void connexion(String login, String password){
        String url = baseUrl + "api/connexion.php";

        client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("login", login);
        params.add("pwd",password);
        client.post(url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                //response = new String(response.getBytes(Charset.forName("ISO-8859-1")), Charset.forName("UTF-8"));
                String retour = HtmlDecodePost(response);
                try {
                    JSONObject jRetour = new JSONObject(retour);
                    SingletonPersonne.getUtilisateur().getFromJson(jRetour);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                SingletonPersonne.bConnexion = true;
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                SingletonPersonne.bConnexion = true;
            }
        });
    }

    public static Collection<Connexion> getListConnexion(){
        String url = baseUrl + "api/listConnexion.php";
        client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        client.post(url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                String LeRetour = HtmlDecodePost(response);
                Log.i("LERETOUR", LeRetour);
                Collection<Connexion> desConnexions;
                try {

                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Connexion>>(){}.getType();
                    desConnexions =  gRetour.fromJson(LeRetour, collectionType); //= gRetour.fromJson(LeRetour, collectionType);

                    Log.e("SIZE GSON","size : "+ desConnexions.size());
                    Iterator it = desConnexions.iterator();

                    Connexion uneConnexion;

                    while (it.hasNext()){
                        uneConnexion = (Connexion) it.next();
                        if (uneConnexion.getLoginUtilisateur().equals("ROGER.Jean-Baptiste")){
                            Log.e("MDP import", uneConnexion.getMdpUtilisateur());
                        }
                        SingletonPersonne.addConnexion(uneConnexion);
                    }

                    Log.i("listConnexion", Integer.toString(SingletonPersonne.getLesConnexions().size()));
                } catch (Throwable t) {
                    Log.e("My App", "Could not parse malformed JSON: ", t);
                }
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e(content, "pb dans le WebService : "+ error.toString(), error);
            }
        });

        return SingletonPersonne.getLesConnexions();
    }

    public static void getUtilisateurById(Integer unIdUtilisateur) {
        String url = baseUrl + "api/Utilisateur.php";
        client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("id", Integer.toString(unIdUtilisateur));
        client.get(url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                String LeRetour = HtmlDecodePost(response);
                //Utilisateur unUtilisateur = new Utilisateur();
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Utilisateur>(){}.getType();
                    //unUtilisateur =  gRetour.fromJson(LeRetour, collectionType); //= gRetour.fromJson(LeRetour, collectionType);

                    SingletonPersonne.setUtilisateur((Utilisateur) gRetour.fromJson(LeRetour, collectionType));

                } catch (Throwable t) {
                    Log.e("My App", "Could not parse malformed JSON: ", t);
                }
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e(content, "pb dans le WebService : "+ error.toString(), error);
            }
        });
    }
}
