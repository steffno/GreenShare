package com.rusthell.greenshare.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Viaggio {
    private String andata;
    private String partenza;
    private LocalDate data;
    private LocalTime orario;

    public Viaggio(String andata, String partenza, LocalDate data, LocalTime orario) {
        this.andata = andata;
        this.partenza = partenza;
        this.data = data;
        this.orario = orario;
    }

    public String getAndata() {
        return andata;
    }

    public void setAndata(String andata) {
        this.andata = andata;
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

    public void setOrario(LocalTime orario) {
        this.orario = orario;
    }
}
