package com.rusthell.greenshare.services;

import com.rusthell.greenshare.domain.Viaggio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ViaggioService {

    private static List<Viaggio> viaggi = new ArrayList<>();

    static{
        //aggiungo qualche viaggio
        Viaggio viaggio = new Viaggio("Teramo", "L'Aquila", LocalDate.now(), LocalTime.now());
        viaggi.add(viaggio);
        viaggio = new Viaggio("Avezzano", "Chieti", LocalDate.now(), LocalTime.now());
        viaggi.add(viaggio);
        viaggio = new Viaggio("Pescara", "Forcella", LocalDate.now(), LocalTime.now());
        viaggi.add(viaggio);
    }

    public ArrayList<Viaggio> cercaViaggio(String andata, String partenza, LocalDate data) throws Exception {
        ArrayList<Viaggio> localViaggio = new ArrayList<>();
        for(Viaggio v : viaggi){
            if (v.getAndata().equals(andata) && v.getPartenza().equals(partenza) && v.getData().equals(data)){
                localViaggio.add(v);
            }
        }
        if(localViaggio.isEmpty()){
            throw new Exception ("Nessun viaggio trovato");
        }
        return localViaggio;
    }

}
