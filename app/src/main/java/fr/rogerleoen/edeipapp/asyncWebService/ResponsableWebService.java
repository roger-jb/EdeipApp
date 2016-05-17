package fr.rogerleoen.edeipapp.asyncWebService;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

import fr.rogerleoen.edeipapp.objets.Eleve;
import fr.rogerleoen.edeipapp.objets.Responsable;

/**
 * Created by Jean-Baptiste on 17/05/2016.
 */
public class ResponsableWebService extends AsyncWebService {

    public static void getEleves(final Responsable responsable) {
        String url = baseUrl + "api/Responsable.php";
        client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("action", "getEleves");
        params.add("idResponsable", Integer.toString(responsable.getIdResponsable()));
        client.get(url, params, new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(String response){
                String leRetour = HtmlDecodePost(response);
                Collection<Eleve> desEleves;
                try {
                    Gson gRetour = new Gson();
                    Type collectionType = new TypeToken<Collection<Eleve>>(){}.getType();
                    desEleves = gRetour.fromJson(leRetour, collectionType);

                    for (Eleve unEleve : desEleves) {
                        responsable.addEleve(unEleve);
                    }

                }
                catch (Throwable t){
                    Log.e("JSON Parse", "Could not parse malformed JSON: ", t);
                }
            }
            @Override
            public void onFailure(int statusCode, Throwable error, String content){
                Log.e(content, "pb dans le WebService : "+ error.toString(), error);
            }
        });

    }
}
