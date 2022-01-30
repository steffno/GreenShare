package com.rusthell.greenshare.domain;

public class Veicolo {
    private String targa;
    private String nomeVeicolo;
    private int cilindrata;
    private Alimentazione alimentazione;
    private int euro;

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getNomeVeicolo() {
        return nomeVeicolo;
    }

    public void setNomeVeicolo(String nomeVeicolo) {
        this.nomeVeicolo = nomeVeicolo;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public Alimentazione getAlimentazione() {
        return alimentazione;
    }

    public void setAlimentazione(Alimentazione alimentazione) {
        this.alimentazione = alimentazione;
    }

    public int getEuro() {
        return euro;
    }

    public void setEuro(int euro) {
        this.euro = euro;
    }

    public Veicolo(String targa, String nomeVeicolo, int cilindrata, Alimentazione alimentazione, int euro) {
        this.targa = targa;
        this.nomeVeicolo = nomeVeicolo;
        this.cilindrata = cilindrata;
        this.alimentazione = alimentazione;
        this.euro = euro;
    }
}
