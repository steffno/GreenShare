package com.rusthell.greenshare;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

import java.util.Arrays;
import java.util.List;

public class Home extends AppCompatActivity {
    //Inizializziamo le variabili
    /**
     * * Allora, la home deve essere lasciata come main activity (AppCompactActivity) essendo la parte
     * "principale" dell'applicazione, il resto delle funzionalità saranno dei fragment che si sovrapporranno a essa
     * i guess, almeno, se funziona non so perchè ahahah
     */
   EditText mSearchText;
   TextView textView, textView2;
   private final int ID_Home = 1;
   private final int ID_2 = 2;
   private final int ID_3 = 3;
   private final int ID_4 = 4;
   private static final String TAG = "Home";
   private static final LatLngBounds LAT_LNG_BOUNDS = new LatLngBounds(
            new LatLng(-40, -168), new LatLng(71, 136));
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Intent intent = getIntent();
        //Prendiamo utente dall' intent del logIn
        Utente utente = (Utente) getIntent().getSerializableExtra("utente");
        setContentView(R.layout.home);
        TextView myAwesomeTextView = (TextView) findViewById(R.id.ciao);
        myAwesomeTextView.setText("Benvenuto " + utente.getUsername()+" !");
        //Assegno le variabili del Autocomplete
        mSearchText = (EditText) findViewById(R.id.cerca);
        textView = (TextView)  findViewById(R.id.textview);
        textView2 = (TextView) findViewById(R.id.textview2);
        MeowBottomNavigation bottomNav = findViewById(R.id.bottomNavigation1);
        bottomNav.add(new MeowBottomNavigation.Model(ID_Home, R.drawable.ic_baseline_home_24));
        bottomNav.add(new MeowBottomNavigation.Model(ID_2, R.drawable.ic_baseline_dashboard_24));

        bottomNav.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {

            }
        });

        //Inizializziamo i places
        Places.initialize(getApplicationContext(), "AIzaSyBNTS0lqjxxnk7znMHw2GEBEf_-bjJypEo");

        //Set EditText non facusable
        mSearchText.setFocusable(false);
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
    }
}
