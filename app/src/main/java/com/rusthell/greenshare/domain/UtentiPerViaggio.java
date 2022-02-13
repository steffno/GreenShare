package com.rusthell.greenshare.domain;

import java.util.ArrayList;

public class UtentiPerViaggio {
    private Viaggio viaggio;
    private ArrayList<Utente> passeggeri = new ArrayList<>();
    private Utente guidatore;

    public Viaggio getViaggio() {
        return viaggio;
    }

    public void setViaggio(Viaggio viaggio) {
        this.viaggio = viaggio;
    }

    public Utente getGuidatore() {
        return guidatore;
    }

    public void setGuidatore(Utente guidatore) {
        this.guidatore = guidatore;
    }

    public ArrayList<Utente> getPasseggeri() {
        return passeggeri;
    }

    public void setPasseggeri(ArrayList<Utente> passeggeri) {
        this.passeggeri = passeggeri;
    }

    public void aggiungiPasseggero(Utente utente){
        passeggeri.add(utente);
    }
}
