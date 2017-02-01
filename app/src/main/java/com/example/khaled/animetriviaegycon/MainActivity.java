package com.example.khaled.animetriviaegycon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, com.example.khaled.animetriviaegycon.GridView.OnFragmentInteractionListener {

    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    FragmentManager fragmentManager = getSupportFragmentManager();
    LeaderActivity Lactivity = new LeaderActivity();
    StatusActivity Sactivity = new StatusActivity();
    Copyright copyright = new Copyright();
    com.example.khaled.animetriviaegycon.GridView Gview = new com.example.khaled.animetriviaegycon.GridView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentManager.beginTransaction()
                .replace(R.id.frame, Gview)
                .commit();

        /*
        for(int i=0;i<10;i++){
            gridArray.add(new Item(homeIcon,"Naruto"));
            gridArray.add(new Item(userIcon,"Bleach"));
        }


        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.content_main, gridArray);
        gridView.setAdapter(customGridAdapter);
        */

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        View header = navigationView.getHeaderView(0);
        final TextView accName = (TextView)header.findViewById(R.id.accName);
        final TextView email = (TextView) header.findViewById(R.id.EmailView);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users");
        final FirebaseAuth auth = FirebaseAuth.getInstance();
        String userID= auth.getCurrentUser().getUid();

        ref.orderByChild("id").equalTo(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name =  dataSnapshot.getChildren().iterator().next().child("firstName").getValue().toString() + " "
                        + dataSnapshot.getChildren().iterator().next().child("lastName").getValue().toString();
                accName.setText(name);
                email.setText(auth.getCurrentUser().getEmail());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_buttons, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.All_anime) {
            fragmentManager.beginTransaction()
                    .replace(R.id.frame, Gview)
                    .commit();

        } else if (id == R.id.nav_status) {

            fragmentManager.beginTransaction()
                    .replace(R.id.frame, Sactivity)
                    .commit();

        } else if (id == R.id.nav_Leader) {

            fragmentManager.beginTransaction()
                    .replace(R.id.frame, Lactivity)
                    .commit();

        }else if (id == R.id.nav_about) {

            fragmentManager.beginTransaction()
                    .replace(R.id.frame, copyright)
                    .commit();

        } else if (id == R.id.nav_logout) {
            FirebaseAuth auth = FirebaseAuth.getInstance();
            finish();
            auth.signOut();
            startActivity(new Intent(this, LoginActivity.class));

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
