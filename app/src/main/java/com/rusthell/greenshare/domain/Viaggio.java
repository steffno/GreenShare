package com.rusthell.greenshare.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Viaggio implements Serializable {
    private String arrivo;
    private String partenza;
    private LocalDate data;
    private LocalTime orario;
    private Boolean concluso;
    private Utente guidatore;
    private ArrayList<String> tappe = new ArrayList<>();

    public Viaggio(String arrivo, String partenza, LocalDate data, LocalTime orario, Boolean concluso, Utente guidatore) {
        this.arrivo = arrivo;
        this.partenza = partenza;
        this.data = data;
        this.orario = orario;
        this.concluso = concluso;
        this.guidatore = guidatore;
    }

    public String getArrivo() {
        return arrivo;
    }

    public void setArrivo(String andata) {
        this.arrivo = andata;
    }

    public String getPartenza() {
        return partenza;
    }

    public void setPartenza(String partenza) {
        this.partenza = partenza;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getOrario() {
        return orario;
    }

    public Boolean getConcluso() {
        return concluso;
    }

    public void setConcluso(Boolean concluso) {
        this.concluso = concluso;
    }

    public void setOrario(LocalTime orario) {
        this.orario = orario;
    }

    public ArrayList<String> getTappe(){
        return tappe;
    }

    public void setTappe(ArrayList<String> tappe){
        this.tappe = tappe;
    }

    public Utente getGuidatore() {
        return guidatore;
    }

    public void setGuidatore(Utente guidatore) {
        this.guidatore = guidatore;
    }
}
