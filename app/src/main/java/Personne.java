/**
 * Created by Jean-Baptiste on 03/05/2016.
 */
public class Personne {
    private static Personne ourInstance = new Personne();

    public static Personne getInstance() {
        return ourInstance;
    }

    private Personne() {
    }

    public boolean connexion(String login, String password){



        return false;
    }
}
