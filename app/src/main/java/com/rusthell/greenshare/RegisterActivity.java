package com.rusthell.greenshare;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText username, password, nome, cognome;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        username = (EditText) findViewById(R.id.usernameR);
        password = (EditText) findViewById(R.id.passwordR);
        nome = (EditText) findViewById(R.id.nomeR);
        cognome = (EditText) findViewById(R.id.cognomeR);
        button = (Button) findViewById(R.id.registerbtnR);






    }
}
