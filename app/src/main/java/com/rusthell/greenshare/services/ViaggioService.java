package com.rusthell.greenshare.services;

import com.rusthell.greenshare.domain.Utente;
import com.rusthell.greenshare.domain.UtentePerViaggio;
import com.rusthell.greenshare.domain.Viaggio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class ViaggioService {

    private static ArrayList<Viaggio> viaggi = new ArrayList<>();
    private static ArrayList<UtentePerViaggio> utentiPerViaggio = new ArrayList<>();
    private static UtenteService utenteService = new UtenteService();

    static{
        //VIAGGIO 1
        Viaggio viaggio = new Viaggio("Teramo", "L'Aquila", LocalDate.now(), LocalTime.now(), false, utenteService.getUtenti().get(2));
        //a questo viaggio specifico delle tappe
        ArrayList<String> tappe = new ArrayList<String>(Arrays.asList("Forcella", "Val vomano", "Basciano"));
        viaggio.setTappe(tappe);
        //creo association class
        UtentePerViaggio temp = new UtentePerViaggio();
        temp.setViaggio(viaggio);
        temp.setPasseggero(utenteService.getUtenteLoggato());
        utentiPerViaggio.add(temp);
        viaggi.add(viaggio);

        //VIAGGIO 2
        viaggio = new Viaggio("Avezzano", "Chieti", LocalDate.now(), LocalTime.now(), false, utenteService.getUtenti().get(2));
        //creo association class
        temp = new UtentePerViaggio();
        temp.setViaggio(viaggio);
        viaggi.add(viaggio);

        //VIAGGIO 3
        viaggio = new Viaggio("Pescara", "Forcella", LocalDate.now(), LocalTime.now(), true, utenteService.getUtenti().get(2));
        //creo association class
        temp = new UtentePerViaggio();
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
        for(UtentePerViaggio uV : utentiPerViaggio){
            if(uV.getPasseggero() == utente){
                viaggiPerUtente.add(uV.getViaggio());
            }
        }
        //adesso aggiungiamo i viaggi prenotati
        for(Viaggio v : viaggi){
            if(v.getGuidatore().getUsername().equals(utente.getUsername())){
                viaggiPerUtente.add(v);
            }
        }
        return viaggiPerUtente;
    }

    public void prenotaViaggio(Viaggio viaggio, Utente utente) throws Exception {
        /*

        Utente utente = utenteService.getUtenteLoggato();
        ArrayList<Viaggio> viaggiPerUtente = utente.getViaggi();
        viaggiPerUtente.add(viaggio);
        utente.setViaggi(viaggiPerUtente);*/
        //sopra era senza association class, ma vorrei farlo con essa quindi userò la seguente implementazione

        if(!utentiPerViaggio.contains(utente)){
            UtentePerViaggio temp = new UtentePerViaggio();
            temp.setPasseggero(utente);
            temp.setViaggio(viaggio);
        }else{
            throw new Exception("Utente già presente con questo viaggio");
        }
    }

    public void creaViaggio(String andata, String partenza, LocalDate data, Utente utente){
        Viaggio viaggio = new Viaggio(andata, partenza, data, LocalTime.now(), false, utente);
        viaggi.add(viaggio);
    }
}
