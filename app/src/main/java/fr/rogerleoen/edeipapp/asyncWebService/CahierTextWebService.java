package fr.rogerleoen.edeipapp.asyncWebService;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.lang.reflect.Type;
import java.util.Collection;

import fr.rogerleoen.edeipapp.SingletonPersonne;
import fr.rogerleoen.edeipapp.dummy.CahierTextContent;
import fr.rogerleoen.edeipapp.objets.CahierText;

/**
 * Created by Jean-Baptiste on 18/05/2016.
 */
public class CahierTextWebService extends AsyncWebService {
    public static void getListCahierText() {
        String url = baseUrl + "api/CahierTexte.php";
        client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("action", "getByIdUtilisateur");
//        params.add("idUtilisateur", SingletonPersonne.getUtilisateur().getIdUtilisateur().toString());
        client.get(url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                String leRetour = HtmlDecodePost(response);
                Collection<CahierText> desCahierTextes;
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<CahierText>>(){}.getType();
                    desCahierTextes = gRetour.fromJson(leRetour, collectionType);
                    for(CahierText unCahierTexte: desCahierTextes) {
                        CahierTextContent.addItem(unCahierTexte);
                    }

                } catch (Throwable t) {
                    Log.e("My App", "Could not parse malformed JSON: ", t);
                }
                Log.e("CahierTextContent", "Chargement listeTerminé WS");
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e(content, "pb dans le WebService : "+ error.toString(), error);
            }
        });
    }
}
