package com.rusthell.greenshare.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.rusthell.greenshare.MainActivity;
import com.rusthell.greenshare.R;
import com.rusthell.greenshare.services.UtenteService;

public class ProfileFragment extends Fragment {

    private ImageView imageView;
    private TextView textViewNome;
    private TextView textViewCognome;
    private UtenteService utenteService;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        imageView = (ImageView) view.findViewById(R.id.imgProfilo);
        textViewNome = (TextView) view.findViewById(R.id.textNome);
        textViewCognome = (TextView) view.findViewById(R.id.textCognome);
        button = (Button) view.findViewById(R.id.buttonEsci);


        //Setto il testo delle textView
        utenteService = new UtenteService();
        System.out.println("Utente in ProfileFragment: " + utenteService.getUtenteLoggato().getNome());
        textViewNome.setText(utenteService.getUtenteLoggato().getNome());
        textViewCognome.setText(utenteService.getUtenteLoggato().getCognome());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utenteService.logout();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        return view;
    }


}
