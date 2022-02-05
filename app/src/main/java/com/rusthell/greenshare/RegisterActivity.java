package com.rusthell.greenshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.rusthell.greenshare.services.UtenteService;

public class RegisterActivity extends AppCompatActivity {
    private EditText username, password, nome, cognome;
    private Button button;
    private UtenteService utenteService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        utenteService = new UtenteService();
        username = (EditText) findViewById(R.id.usernameR);
        password = (EditText) findViewById(R.id.passwordR);
        nome = (EditText) findViewById(R.id.nomeR);
        cognome = (EditText) findViewById(R.id.cognomeR);
        button = (Button) findViewById(R.id.registerbtnR);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utenteService.registra(nome.getText().toString(),
                        cognome.getText().toString(),
                        username.getText().toString(),
                        password.getText().toString());

                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
