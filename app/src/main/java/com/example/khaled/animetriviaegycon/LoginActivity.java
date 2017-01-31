package com.example.khaled.animetriviaegycon;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;
import static com.firebase.ui.auth.ui.AcquireEmailHelper.RC_SIGN_IN;

/**
 * A login screen that offers login via email/password.
 */

public class LoginActivity extends AppCompatActivity {

    //for firebase general authentication
    FirebaseAuth firebaseAuth;

    //Progress Dialog for progress update
    ProgressDialog progress;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */

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
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        //Progress bar for info
        progress= new ProgressDialog(this);

        //Initiates the current firebase running instance
        firebaseAuth = FirebaseAuth.getInstance();

        //If user is already signed in, continue to rules
        if(firebaseAuth.getCurrentUser()!=null){
            Log.e("email logged in:",firebaseAuth.getCurrentUser().getEmail());
            this.finish();
            startActivity(new Intent(LoginActivity.this, RulesActivity.class));
        }

        mPasswordView = (EditText) findViewById(R.id.password);

        //Get the buttons in our form
        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        Button Signup = (Button) findViewById(R.id.register);

        //The sign up button click listener
        //Go to register activity
        Signup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        //The sign in click listener
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //Start the progress dialogue..
                progress.setMessage("Logging in, please wait...");
                progress.show();

                //Get email and password
                String email = mEmailView.getText().toString().trim();
                String pass = mPasswordView.getText().toString().trim();

                //If mail empty, error
                if(TextUtils.isEmpty(email)){
                    progress.dismiss();
                    Toast.makeText(LoginActivity.this, "Please enter your email.", Toast.LENGTH_SHORT).show();
                    return;
                }

                //If pass empty, error
                if(TextUtils.isEmpty(pass)){
                    progress.dismiss();
                    Toast.makeText(LoginActivity.this, "Please enter your password.", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Sign in through firebase and check if success or fail after completion
                firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progress.dismiss();
                        if(task.isSuccessful()){
                            LoginActivity.this.finish();
                            startActivity(new Intent(LoginActivity.this, RulesActivity.class));
                        }
                        else if(task.isSuccessful()!=true){
                            Toast.makeText(LoginActivity.this, "Username or password incorrect. Please, try again.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

    }

}

