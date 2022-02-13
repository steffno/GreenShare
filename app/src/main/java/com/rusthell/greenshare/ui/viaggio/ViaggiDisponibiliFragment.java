package com.rusthell.greenshare.ui.viaggio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rusthell.greenshare.R;
import com.rusthell.greenshare.ViaggioAdapter;
import com.rusthell.greenshare.domain.Viaggio;

import java.util.ArrayList;

public class ViaggiDisponibiliFragment extends Fragment {

    //init
    private ArrayList<Viaggio> viaggioArrayList;
    private ViaggioViewModel viaggioViewModel;
    private RecyclerView viaggioRV;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        viaggioViewModel = new ViewModelProvider(requireActivity()).get(ViaggioViewModel.class);
        super.onCreate(savedInstanceState);
        try {
            viaggioArrayList = viaggioViewModel.getViaggi();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_risultato, container, false);
        viaggioRV = (RecyclerView) view.findViewById(R.id.idRvViaggioDisp);
        ViaggioAdapter viaggioAdapter = new ViaggioAdapter(getActivity(), viaggioArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false);
        if(viaggioRV!=null){System.out.println("FUNONZIA");}
        else{
            System.out.println("E' NULL");
        }
        viaggioRV.setLayoutManager(linearLayoutManager);
        viaggioRV.setAdapter(viaggioAdapter);
        ViewCompat.setTransitionName(viaggioRV, "anim1");
        return view;




    }

}
