package com.example.khaled.animetriviaegycon;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.R.attr.button;

public class RegisterActivity extends AppCompatActivity {
    //Firebase authentication function
    FirebaseAuth firebaseAuth;

    //Progress dialog for updates
    ProgressDialog progress;

    //Text view vars
    EditText EmailView;
    EditText PasswordView;
    EditText ConfirmPasswordView;
    EditText FirstNameView;
    EditText LastNameView;
    EditText PhoneNumberView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Getting the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initialize progress dialog
        progress=new ProgressDialog(this);

        //Getting current firebase instance
        firebaseAuth = FirebaseAuth.getInstance();

        //startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setProviders(AuthUI.FACEBOOK_PROVIDER,AuthUI.EMAIL_PROVIDER,AuthUI.GOOGLE_PROVIDER).build(),1);
        //GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

        //Getting the register button for listener
        Button Regist = (Button) findViewById(R.id.RegButton);

        //Register button listener
        Regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(RegisterActivity.this,RulesActivity.class));
                //finish();
                progress.setMessage("Registering, please wait...");
                progress.show();

                //Getting the text views
                EditText EmailView= (EditText) findViewById(R.id.email);
                EditText PasswordView= (EditText) findViewById(R.id.password);
                EditText ConfirmPasswordView= (EditText) findViewById(R.id.confirm_password);
                EditText FirstNameView= (EditText) findViewById(R.id.first_name);
                EditText LastNameView= (EditText) findViewById(R.id.last_name);
                EditText PhoneNumberView= (EditText) findViewById(R.id.phone_number);

                //Get email and password
                final String email = EmailView.getText().toString().trim();
                final String pass = PasswordView.getText().toString().trim();
                final String confirmPass =  ConfirmPasswordView.getText().toString().trim();
                final String firstName = FirstNameView.getText().toString().trim();
                final String lastName = LastNameView.getText().toString().trim();
                final String phoneNumber = PhoneNumberView.getText().toString().trim();

                if(pass.equals(confirmPass) && TextUtils.isEmpty(pass)!=true && pass.length()>=8) {
                    //If mail empty, error
                    if (TextUtils.isEmpty(email)) {
                        progress.dismiss();
                        Toast.makeText(RegisterActivity.this, "Please enter your email.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    //If first name empty, error
                    if (TextUtils.isEmpty(firstName)) {
                        progress.dismiss();
                        Toast.makeText(RegisterActivity.this, "Please enter your first name.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    //If last name empty, error
                    if (TextUtils.isEmpty(lastName)) {
                        progress.dismiss();
                        Toast.makeText(RegisterActivity.this, "Please enter your last name.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    //If phone number empty, error
                    if (TextUtils.isEmpty(phoneNumber)) {
                        progress.dismiss();
                        Toast.makeText(RegisterActivity.this, "Please enter your phone number.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    //register with email and pass and check what to do if success  or fail
                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //dismiss the progress dialog.
                            progress.dismiss();
                            //if success , add rest of data to DB
                            if(task.isSuccessful()){
                                //if registration success, insert rest of info
                                writeNewUser(email,pass,firstName,lastName,phoneNumber);
                                //transfer to login activity
                                RegisterActivity.this.finish();
                                Toast.makeText(RegisterActivity.this, "Registration successful, please login.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            }
                            //if fail and internet conn, already registered.
                            else if(task.isSuccessful()!=true && isOnline() ){
                                Toast.makeText(RegisterActivity.this, "User already registered.", Toast.LENGTH_SHORT).show();
                            }
                            //if fail and no internet, check interent
                            else{
                                Toast.makeText(RegisterActivity.this, "Registration failed, please check your internet connection.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    progress.dismiss();
                    Toast.makeText(RegisterActivity.this, "Both passwords have to match, not left blank, and more than or equal 8 characters.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }

    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null &&
                cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }

    private void writeNewUser( String email,  String pass,  String fName,  String lName, String phone) {
        //Database reference for data insert
        DatabaseReference mDatabase;
        //sign in to get user id
        firebaseAuth.signInWithEmailAndPassword(email,pass);
        //get user id
        String userId = firebaseAuth.getCurrentUser().getUid();
        //creates user with data to be inserted
        Users user = new Users(email,userId,fName, lName,phone);
        //sets the database to the users one and writes a new entry with the current user Id
        mDatabase = FirebaseDatabase.getInstance().getReference().child("users").child(userId);
        //Writes the user to the entry
        mDatabase.setValue(user);
        //signs out from session
        firebaseAuth.signOut();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,LoginActivity.class));
    }
}
