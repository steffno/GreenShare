package com.rusthell.greenshare;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.libraries.places.api.Places;
import com.rusthell.greenshare.services.UtenteService;

public class HomeFragment extends Fragment {

//Inizializzo
    private EditText editText;
    private UtenteService utenteService = new UtenteService();
    FragmentManager fragmentManager;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        TextView myAwesomeTextView = (TextView) view.findViewById(R.id.ciao);
        myAwesomeTextView.setText("Benvenuto " + utenteService.getUtenteLoggato().getNome());

        editText = (EditText) view.findViewById(R.id.cercaEditText);
        editText.setFocusable(false);
        editText.setInputType(0);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new CercaDestinazioneFragment();
                System.out.println("Prima di iniziare la trasizione");
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_bottom,
                                R.anim.slide_out_top,
                                R.anim.slide_in_top,
                                R.anim.slide_out_bottom)
                        .replace(R.id.fragment_container, fragment)
                        .addToBackStack("HomeFragment")
                        .commit();
                System.out.println("Dopo transizione");
            }
        });

        //places autocomplete
        return view;
    }


}