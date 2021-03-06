package com.rusthell.greenshare.ui.viaggio;

import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rusthell.greenshare.R;
import com.rusthell.greenshare.domain.Viaggio;
import com.rusthell.greenshare.services.UtenteService;
import com.rusthell.greenshare.services.ViaggioService;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class InfoFragment extends Fragment {


    private Viaggio viaggio;
    private TextView textView1, textView2, textView3, textView4;
    private Button button;
    private RecyclerView tappeRV;
    private UtenteService utenteService = new UtenteService();
    private ArrayList<String> tappe =  new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Transition transition = TransitionInflater.from(requireContext())
                .inflateTransition(R.transition.shared_transition);
        postponeEnterTransition();
        setSharedElementEnterTransition(transition); */
        viaggio = (Viaggio) getArguments().getSerializable("viaggio");

        System.out.println("SOno dentro on create di InfoFragment");
        if(viaggio.getTappe() !=null){
            System.out.println("LE TAPPE NON SONO NULL");
            tappe = viaggio.getTappe();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        textView1 = view.findViewById(R.id.textViewPartenzaInfo1);
        textView2 = view.findViewById(R.id.textViewDestinazioneInfo1);
        textView3 = view.findViewById(R.id.textViewDataInfo1);
        textView4 = view.findViewById(R.id.textViewOrarioInfo1);
        textView1.setText(viaggio.getPartenza());
        textView2.setText(viaggio.getArrivo());
        textView3.setText(viaggio.getData().toString());
        textView4.setText(viaggio.getOrario().format(DateTimeFormatter.ofPattern("HH:mm")));
        button = view.findViewById(R.id.buttonPrenotaViaggio);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViaggioService viaggioService = new ViaggioService();
                try {
                    viaggioService.prenotaViaggio(viaggio, utenteService.getUtenteLoggato());
                    Toast.makeText(getActivity(), "Hai prenotato questo viaggio", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getActivity(), "Hai GIA' prenotato questo viaggio", Toast.LENGTH_LONG).show();
                }
            }
        });


        System.out.println("SOno dentro on create view di InfoFragment");
        tappeRV = view.findViewById(R.id.recyclerViewTappe);


        TappaAdapter tappeAdapter = new TappaAdapter(getActivity(), tappe);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false);
        tappeRV.setLayoutManager(linearLayoutManager);
        tappeRV.setAdapter(tappeAdapter);
        return view;
    }


}