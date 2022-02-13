package com.rusthell.greenshare.ui.viaggio;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rusthell.greenshare.domain.Viaggio;
import com.rusthell.greenshare.services.UtenteService;
import com.rusthell.greenshare.services.ViaggioService;
import com.rusthell.greenshare.ui.home.HomeFragment;

import java.time.LocalDate;
import java.util.ArrayList;

public class ViaggioViewModel extends ViewModel {

    private final MutableLiveData<String> destinazione = new MutableLiveData<String>();
    private final MutableLiveData<String> partenza = new MutableLiveData<String>();
    private final MutableLiveData<LocalDate> data = new MutableLiveData<>();
    private final MutableLiveData<ArrayList<Viaggio>> viaggi = new MutableLiveData<>();
    private ViaggioService viaggioService = new ViaggioService();
    private final MutableLiveData<Boolean> viaggioTrovato = new MutableLiveData<>();

    public void setDestinazione(String destinazione1){
        destinazione.setValue(destinazione1);
    }

    public LiveData<String> getDestinazione(){
        return destinazione;
    }

    public LiveData<Boolean> getViaggioTrovato(){return viaggioTrovato;}

    public void setViaggioTrovato(Boolean b){
        viaggioTrovato.setValue(b);
    }

    public void setPartenza(String partenza1){
        partenza.setValue(partenza1);
    }

    public LiveData<String> getPartenza(){
        return partenza;
    }

    public MutableLiveData<LocalDate> getData() {
        return data;
    }

    public void setData(LocalDate data1){
        data.setValue(data1);
    }

    public ArrayList<Viaggio> getViaggi() throws Exception{

        ArrayList<Viaggio> viaggiTrovati = new ArrayList<>();
        try {
            System.out.println("In get viaggi VIEWMODEL la destinazione è: "+destinazione.getValue()+ " l'andata è: " + partenza.getValue() + " e data: " + data.getValue());
            viaggiTrovati =  viaggioService.cercaViaggio(destinazione.getValue(), partenza.getValue(), data.getValue());
            viaggioTrovato.setValue(true);
            return viaggiTrovati;
        }catch (Exception e){
            viaggioTrovato.setValue(false);
            throw new Exception();
        }
    }


}
