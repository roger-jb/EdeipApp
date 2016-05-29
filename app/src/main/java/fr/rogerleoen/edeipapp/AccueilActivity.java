package fr.rogerleoen.edeipapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class AccueilActivity extends AppCompatActivity {

    private static TextView helloTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("AccueilActivity", String.valueOf(SingletonPersonne.getInstance().isConnected()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        helloTextView = (TextView) findViewById(R.id.helloTextView);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Ce sera pour ajouter un message", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        if (!SingletonPersonne.getInstance().isConnected()){
            startActivity(new Intent(this, LoginActivity.class));
        }
        String text = "Bonjour\n"+SingletonPersonne.getUtilisateur().getPrenomUtilisateur()+" "+SingletonPersonne.getUtilisateur().getNomUtilisateur()+".";

        Log.d("bonjour", text);
        if (SingletonPersonne.getInstance().isConnected())
        while (text.equals("Bonjour\nnull null.")) {
            text = "Bonjour\n" + SingletonPersonne.getUtilisateur().getPrenomUtilisateur() + " " + SingletonPersonne.getUtilisateur().getNomUtilisateur() + ".";
            //Log.d("bonjour", text);
        }
        helloTextView.setText(text);
        Log.i("accueilActivity", "fin resume Acceuil");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_accueil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_CarnetLiaison :
                //helloTextView.setText("Hello "+ SingletonPersonne.getUtilisateur().getNomUtilisateur() + " " + SingletonPersonne.getUtilisateur().getPrenomUtilisateur());
                break;
            case R.id.action_CahierText :
                //startActivity(new Intent(this, AccueilCahierTextActivity.class));
                startActivity(new Intent(this, CahierTextItemListActivity.class));
                break;
//            case R.id.action_settings :
//                break;
            case R.id.action_deconnexion :
                SingletonPersonne.Deconnexion();
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private String hash(String password) {
        MessageDigest digest;
        String hash = "";
        try {
            digest = MessageDigest.getInstance("SHA-256");
            digest.update(password.getBytes());

            hash = bytesToHexString(digest.digest());

            Log.i("Eamorr", "result is " + hash);
        } catch (NoSuchAlgorithmException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return hash;
    }

    private String bytesToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (byte aByte : bytes) {
            String hex = Integer.toHexString(0xFF & aByte);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}
