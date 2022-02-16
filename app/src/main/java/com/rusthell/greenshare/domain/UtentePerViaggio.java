package com.rusthell.greenshare.domain;

import java.util.ArrayList;

public class UtentePerViaggio {
    private Viaggio viaggio;
    private Utente passeggero;
    private Boolean partito = false;
    private Boolean arrivato = false;

    public Utente getPasseggero() {
        return passeggero;
    }

    public void setPasseggero(Utente passeggero) {
        this.passeggero = passeggero;
    }

    public Boolean getPartito() {
        return partito;
    }

    public void setPartito(Boolean partito) {
        this.partito = partito;
    }

    public Boolean getArrivato() {
        return arrivato;
    }

    public void setArrivato(Boolean arrivato) {
        this.arrivato = arrivato;
    }

    public Viaggio getViaggio() {
        return viaggio;
    }

    public void setViaggio(Viaggio viaggio) {
        this.viaggio = viaggio;
    }


}
