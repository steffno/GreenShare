package com.rusthell.greenshare.services;

import android.widget.Toast;

import com.rusthell.greenshare.MainActivity;
import com.rusthell.greenshare.domain.Utente;

public  class UtenteService {
    private static Utente utenteLoggato;
    public void login(String username, String password) throws Exception {
        System.out.println(" Sono dentro utente service");
        /*
            Allora, adesso `e un login molto fittizzzio senza alcuna struttura dati, dove pero creiamo l`utente come oggetto
         */
        Utente utente = new Utente("Snesno","Di Dionisio", username, password, null);
        if(username.equals("snesno") && password.equals("1234")){
            System.out.println("Nome:" + username);
        }else{
            throw new Exception("bruh");
        }
        utenteLoggato = utente;
    }

    public static void logout(){}
    public Utente getUtenteLoggato(){return utenteLoggato;}
}
