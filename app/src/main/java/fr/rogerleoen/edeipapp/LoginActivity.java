package fr.rogerleoen.edeipapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

import fr.rogerleoen.edeipapp.objets.Connexion;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private UserLoginTask mAuthTask = null;

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.login);

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.connexion_button);
        assert mEmailSignInButton != null;
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.i("DUMMY_CREDENTIAL", test);

                attemptLogin();
                if (SingletonPersonne.getInstance().isConnected()){
                    changeActivity();
                }
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    @Override
    protected void onResume(){
        super.onResume();
        mEmailView.setText(SingletonPersonne.getInstance().getLogin());
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String unLogin = mEmailView.getText().toString();
        String unPassword = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid unPassword, if the user entered one.
        if (!TextUtils.isEmpty(unPassword) && !isPasswordValid(unPassword)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid unLogin address.
        if (TextUtils.isEmpty(unLogin)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isLoginValid(unLogin)) {
            mEmailView.setError(getString(R.string.error_invalid_login));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            mAuthTask = new UserLoginTask(unLogin, unPassword);
            mAuthTask.execute((Void) null);


        }
    }

    private boolean isLoginValid(String login) {
        return !login.isEmpty();
    }

    private boolean isPasswordValid(String password) {
        return !password.isEmpty();
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    private void changeActivity(){
        startActivity(new Intent(this, AccueilActivity.class));
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
        private final String mLogin;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mLogin = email;
            mPassword = password;
        }

        private String hash(String password) {
            MessageDigest digest;
            String hash = "";
            try {
                digest = MessageDigest.getInstance("SHA-256");
                digest.update(password.getBytes());
                hash = bytesToHexString(digest.digest());
            } catch (NoSuchAlgorithmException e1) {
                e1.printStackTrace();
            }
            return hash;
        }

        private String bytesToHexString(byte[] bytes) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(0xFF & bytes[i]);
                if (hex.length() == 1) {
                    sb.append('0');
                }
                sb.append(hex);
            }
            return sb.toString();
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            for (Connexion uneConnexion:SingletonPersonne.getLesConnexions()){
                if (uneConnexion.getLoginUtilisateur().equals(mLogin)){

                    if (uneConnexion.getMdpUtilisateur().equals(hash(mPassword))){
                        SingletonPersonne.setUtilisateurById(uneConnexion.getIdUtilisateur());
                        SingletonPersonne.connexion(mLogin, mPassword);
                        return true;
                    }
                    return false;
                }
            }
            return false;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            showProgress(false);

            if (success) {
                finish();
            } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }
}

