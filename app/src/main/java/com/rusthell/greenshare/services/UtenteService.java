package com.rusthell.greenshare.services;

import android.widget.Toast;

import com.rusthell.greenshare.MainActivity;
import com.rusthell.greenshare.domain.Utente;

import java.util.ArrayList;
import java.util.List;

public  class UtenteService {
    private static Utente utenteLoggato;
    protected static List<Utente> utentiList = new ArrayList<Utente>();
    static {
        //utente 1
        Utente utente = new Utente("Stefano", "Di Dionisio", "snesno", "1234", null);
        utentiList.add(utente);
        //utente 2
        utente = new Utente("Nicolò", "Andreoni", "Nico", "1234", null);
        utentiList.add(utente);
        //utente 3
        utente = new Utente("Martina", "Giansanti", "Marti", "1234", null);
        utentiList.add(utente);
    }
    public Utente login(String username, String password) throws Exception {
        System.out.println(" Sono dentro utente service");
            for (Utente u: utentiList) {
                if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                    utenteLoggato = u;
                    return u;
                }
            }
        throw new Exception("Utente non esistente");
    }

    public static void logout(){
        utenteLoggato = null;
    }

    public void registra(String nome, String cognome, String username, String password){
        Utente utente = new Utente(nome, cognome, username, password, null);
        utentiList.add(utente);
    }
    public Utente getUtenteLoggato(){return utenteLoggato;}
}
