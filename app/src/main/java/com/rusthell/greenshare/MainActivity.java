package com.rusthell.greenshare;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.rusthell.greenshare.domain.*;
import com.rusthell.greenshare.services.UtenteService;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//Attivita main del programma. Quindi il login//
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utente utente = null;
                try {
                   utente = UtenteService.logIn(username.getText().toString(), password.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, " Username o password sbagliati!!", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(MainActivity.this, " Bella capo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Home.class);
                System.out.println("Username prima della nuova schermata: " + username.getText().toString());
                intent.putExtra("utente",utente);
                startActivity(intent);
                //finish();
            }
        });

    }

}