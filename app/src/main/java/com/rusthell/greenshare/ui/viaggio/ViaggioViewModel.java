package com.rusthell.greenshare.ui.viaggio;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rusthell.greenshare.domain.Viaggio;

import java.time.LocalDate;
import java.util.ArrayList;

public class ViaggioViewModel extends ViewModel {

    private final MutableLiveData<String> destinazione = new MutableLiveData<String>();
    private final MutableLiveData<String> partenza = new MutableLiveData<String>();
    private final MutableLiveData<LocalDate> data = new MutableLiveData<>();
    private final MutableLiveData<ArrayList<Viaggio>> viaggi = new MutableLiveData<>();

    public void setDestinazione(String destinazione1){
        destinazione.setValue(destinazione1);
    }

    public LiveData<String> getDestinazione(){
        return destinazione;
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

    public MutableLiveData<ArrayList<Viaggio>> getViaggi


}
