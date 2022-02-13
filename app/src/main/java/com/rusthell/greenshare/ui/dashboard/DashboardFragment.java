package com.rusthell.greenshare.ui.dashboard;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rusthell.greenshare.R;
import com.rusthell.greenshare.ViaggioAdapter;
import com.rusthell.greenshare.domain.Viaggio;
import com.rusthell.greenshare.services.UtenteService;
import com.rusthell.greenshare.services.ViaggioService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class DashboardFragment extends Fragment {

    private RecyclerView viaggioRV;
    private UtenteService utenteService = new UtenteService();
    //ArrayList per salvare i dati
    private ArrayList<Viaggio> viaggioArrayList;
    private ViaggioService viaggioService = new ViaggioService();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viaggioArrayList = viaggioService.getViaggi(utenteService.getUtenteLoggato());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        viaggioRV = (RecyclerView) view.findViewById(R.id.idRvViaggio);

        // inizializziamo il nostro adattatore e passiamo l'array
        ViaggioAdapter viaggioAdapter = new ViaggioAdapter(getActivity(), viaggioArrayList);
        //mettiamo un layout manager per la recycler view
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false);
        //creiamo una lista verticale
        if (viaggioRV!=null){ System.out.println("ViaggioRV non null");}
        else {System.out.println("ViaggioRV è null");}
        viaggioRV.setLayoutManager(linearLayoutManager);
        viaggioRV.setAdapter(viaggioAdapter);
        //System.out.println("Nell'array ci sono " + viaggioAdapter.getItemCount() + "parametri");

        return view;
    }


}