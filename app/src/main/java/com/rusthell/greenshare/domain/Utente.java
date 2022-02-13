package com.rusthell.greenshare.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Utente implements Serializable {
    private String nome;
    private String cognome;
    private String username;
    private String password;
    private Veicolo veicolo;
    private ArrayList<Viaggio> viaggi = new ArrayList<>();


    public Utente(String nome, String cognome, String username, String password, Veicolo veicolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
        this.veicolo = veicolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }

    public ArrayList<Viaggio> getViaggi() {
        return viaggi;
    }

    public void setViaggi(ArrayList<Viaggio> viaggi) {
        this.viaggi = viaggi;
    }
}
