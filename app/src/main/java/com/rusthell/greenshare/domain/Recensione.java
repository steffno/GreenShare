package com.rusthell.greenshare.domain;

public class Recensione {
    private Integer id;
    private String testo;
    private int stelle;

    public Recensione (Integer id, String testo, int stelle){
        this.id = id;
        this.testo = testo;
        this.stelle = stelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public int getStelle() {
        return stelle;
    }

    public void setStelle(int stelle) {
        this.stelle = stelle;
    }
}
