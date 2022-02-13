package com.rusthell.greenshare.services;

import com.rusthell.greenshare.domain.Utente;
import com.rusthell.greenshare.domain.UtentiPerViaggio;
import com.rusthell.greenshare.domain.Viaggio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViaggioService {

    private static ArrayList<Viaggio> viaggi = new ArrayList<>();
    private static ArrayList<UtentiPerViaggio> utentiPerViaggio = new ArrayList<>();
    UtenteService utenteService = new UtenteService();

    static{
        //aggiungo qualche viaggio
        Viaggio viaggio = new Viaggio("Teramo", "L'Aquila", LocalDate.now(), LocalTime.now(), false);
        //a questo viaggio specifico delle tappe
        ArrayList<String> tappe = new ArrayList<String>(Arrays.asList("Forcella", "Val vomano", "Basciano"));
        viaggio.setTappe(tappe);
        //creo association class
        UtentiPerViaggio temp = new UtentiPerViaggio();
        temp.setViaggio(viaggio);
        utentiPerViaggio.add(temp);
        viaggi.add(viaggio);

        viaggio = new Viaggio("Avezzano", "Chieti", LocalDate.now(), LocalTime.now(), false);
        //creo association class
        temp = new UtentiPerViaggio();
        temp.setViaggio(viaggio);
        viaggi.add(viaggio);

        viaggio = new Viaggio("Pescara", "Forcella", LocalDate.now(), LocalTime.now(), true);
        //creo association class
        temp = new UtentiPerViaggio();
        temp.setViaggio(viaggio);
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

    public static ArrayList<Viaggio> getViaggi(Utente utente) {
        ArrayList<Viaggio> viaggiPerUtente = new ArrayList<>();
        for(UtentiPerViaggio uV : utentiPerViaggio){
            if(uV.getGuidatore() == utente){
                viaggiPerUtente.add(uV.getViaggio());
            }
        }
        return viaggiPerUtente;
    }

    public void aggiungiViaggio(Viaggio viaggio){
        /*

        Utente utente = utenteService.getUtenteLoggato();
        ArrayList<Viaggio> viaggiPerUtente = utente.getViaggi();
        viaggiPerUtente.add(viaggio);
        utente.setViaggi(viaggiPerUtente);*/
        //sopra era senza association class, ma vorrei farlo con essa quindi userò la seguente implementazione

        for(UtentiPerViaggio uV : utentiPerViaggio){
            if (uV.getViaggio() == viaggio){
                //allora posso aggiungere il "passeggero" al viaggio
                uV.aggiungiPasseggero(utenteService.getUtenteLoggato());
            }
        }
    }
}
