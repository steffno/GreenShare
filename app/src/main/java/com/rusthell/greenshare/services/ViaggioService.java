package com.rusthell.greenshare.services;

import com.rusthell.greenshare.domain.Viaggio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViaggioService {

    private static List<Viaggio> viaggi = new ArrayList<>();

    static{
        //aggiungo qualche viaggio
        Viaggio viaggio = new Viaggio("Teramo", "L'Aquila", LocalDate.now(), LocalTime.now(), false);
        //a questo viaggio specifico delle tappe
        ArrayList<String> tappe = new ArrayList<String>(Arrays.asList("Forcella", "Val vomano", "Basciano"));
        viaggio.setTappe(tappe);
        viaggi.add(viaggio);
        viaggio = new Viaggio("Avezzano", "Chieti", LocalDate.now(), LocalTime.now(), false);
        viaggi.add(viaggio);
        viaggio = new Viaggio("Pescara", "Forcella", LocalDate.now(), LocalTime.now(), false);
        viaggi.add(viaggio);
    }

    public ArrayList<Viaggio> cercaViaggio(String andata, String partenza, LocalDate data) throws Exception {
        ArrayList<Viaggio> localViaggio = new ArrayList<>();
        for(Viaggio v : viaggi){
            if (v.getArrivo().equals(andata) && v.getPartenza().equals(partenza) && v.getData().equals(data)){
                System.out.println("Sono dentro il primo if in viaggio service");
                localViaggio.add(v);
            }
            System.out.println("Pausetta");
            if(v.getTappe().contains(andata) && !v.getTappe().isEmpty()){
                System.out.println("Sono dentro il secondo if in viaggio service");
                localViaggio.add(v);
            }
        }
        if(localViaggio.isEmpty()){
            throw new Exception ("Nessun viaggio trovato");
        }
        return localViaggio;
    }

}
