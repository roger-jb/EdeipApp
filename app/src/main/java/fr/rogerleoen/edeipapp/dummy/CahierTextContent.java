package fr.rogerleoen.edeipapp.dummy;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.rogerleoen.edeipapp.asyncWebService.CahierTextWebService;
import fr.rogerleoen.edeipapp.objets.CahierText;

/**
 * Created by Jean-Baptiste on 18/05/2016.
 */
public class CahierTextContent {
    public static final List<CahierText> ITEMS = new ArrayList<>();
    public static final Map<String, CahierText> ITEM_MAP = new HashMap<>();

    static {
        Log.e("CahierTextContent", "Chargement liste");
        CahierTextWebService.getListCahierText();
        Log.e("CahierTextContent", "Chargement listeTerminé");
    }

    public static void addItem(CahierText item){
        Log.d("CahierTextContent", "add"+item.toString());
        ITEMS.add(item);
        ITEM_MAP.put(item.getIdCahierTexte().toString(), item);
    }
}
