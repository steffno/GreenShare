package com.rusthell.greenshare;



import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.rusthell.greenshare.domain.Utente;
import com.rusthell.greenshare.services.UtenteService;

import java.util.Arrays;
import java.util.List;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class Home extends AppCompatActivity {
    //Inizializziamo le variabili
    /**
     * * Allora, la home deve essere lasciata come main activity (AppCompactActivity) essendo la parte
     * "principale" dell'applicazione, il resto delle funzionalità saranno dei fragment che si sovrapporranno a essa
     * i guess, almeno, se funziona non so perchè ahahah
     */
   EditText mSearchText;
   TextView textView, textView2;
   AnimatedBottomBar animatedBottomBar;
   FragmentManager fragmentManager;
   private static final String TAG = "Home";
   private static final LatLngBounds LAT_LNG_BOUNDS = new LatLngBounds(
            new LatLng(-40, -168), new LatLng(71, 136));
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Intent intent = getIntent();
        Utente utente = (Utente) getIntent().getSerializableExtra("utente");
        setContentView(R.layout.home);

        animatedBottomBar = findViewById(R.id.bottom_bar);
        //facciamo partire subito il fragment home
        if(savedInstanceState==null){
            animatedBottomBar.selectTabById(R.id.homeTab, true);
            fragmentManager = getSupportFragmentManager();
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, homeFragment).commit();
        }

        animatedBottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int lastIndex, @Nullable AnimatedBottomBar.Tab lastTab, int newIndex, @NonNull AnimatedBottomBar.Tab newTab) {
                Fragment fragment = null;
                switch(newTab.getId()){
                    case R.id.homeTab:
                        fragment = new HomeFragment();
                        break;
                    case R.id.dashboardTab:
                        fragment = new DashboardFragment();
                        Toast.makeText(Home.this, "Fragment Dashboard", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.profileTab:
                        //TODO Crea Fragment
                        fragment = new ProfileFragment();
                        Toast.makeText(Home.this, "Fragment Profilo", Toast.LENGTH_SHORT).show();
                        break;
                }

                if(fragment!=null){
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }else{
                    Log.e(TAG, "Errore nella creazione del frammento");
                }

            }

            @Override
            public void onTabReselected(int i, @NonNull AnimatedBottomBar.Tab tab) {

            }
        });


        TextView myAwesomeTextView = (TextView) findViewById(R.id.ciao);
//        myAwesomeTextView.setText("Benvenuto " + utente.getUsername()+" !");
        //prova del static utente
        UtenteService utenteService = new UtenteService();
        System.out.println("L'utente chiamato da utenteservice static in home è: "+ utenteService.getUtenteLoggato());
        System.out.println("L'utente da intent in home è: "+ utente);
        //Assegno le variabili del Autocomplete
      //  mSearchText = (EditText) findViewById(R.id.cerca);
       // textView = (TextView)  findViewById(R.id.textview);
       // textView2 = (TextView) findViewById(R.id.textview2);
        //MeowBottomNavigation bottomNav = findViewById(R.id.bottomNavigation1);
       // bottomNav.add(new MeowBottomNavigation.Model(ID_Home, R.drawable.ic_baseline_home_24));
       // bottomNav.add(new MeowBottomNavigation.Model(ID_2, R.drawable.ic_baseline_dashboard_24));

       // bottomNav.setOnShowListener(new MeowBottomNavigation.ShowListener() {
       //     @Override
       //     public void onShowItem(MeowBottomNavigation.Model item) {

     //       }
      //  });

        //Inizializziamo i places
        Places.initialize(getApplicationContext(), "AIzaSyBNTS0lqjxxnk7znMHw2GEBEf_-bjJypEo");

        //Set EditText non facusable
    //   mSearchText.setFocusable(false);
        /*
       mSearchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Inizializziamo place field list
                List<Place.Field> fieldList = Arrays.asList(Place.Field.ADDRESS, Place.Field.LAT_LNG
                        , Place.Field.NAME);
                //Create Intent
                Intent intent1 = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY
                        , fieldList).build(Home.this);
                //Start Acvtivity
                startActivityForResult(intent1, 100);
            }
        });
    }
         */
        /*

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && requestCode == RESULT_OK){
            //Se successo
            //Inizializza place
            Place place = Autocomplete.getPlaceFromIntent(data);
            //Set address on editText
            mSearchText.setText(place.getAddress());
            //Set Locality Name
            textView.setText(String.format("Nome localita : %s", place.getName()));
            //Setta Latidutine e longitudine
            textView2.setText(String.valueOf(place.getLatLng()));
        }else if(resultCode == AutocompleteActivity.RESULT_ERROR){
            //Quando errore
            //Inizializza stato
            Status status = Autocomplete.getStatusFromIntent(data);
            //Display toast
            Toast.makeText(getApplicationContext(), status.getStatusMessage(), Toast.LENGTH_SHORT).show();
        }
        */

    }


}
