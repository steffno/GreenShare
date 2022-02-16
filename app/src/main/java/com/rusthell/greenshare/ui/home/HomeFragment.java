package com.rusthell.greenshare.ui.home;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rusthell.greenshare.services.ViaggioService;
import com.rusthell.greenshare.ui.viaggio.CercaDestinazioneFragment;
import com.rusthell.greenshare.R;
import com.rusthell.greenshare.services.UtenteService;
import com.rusthell.greenshare.ui.viaggio.CercaPartenzaFragment;
import com.rusthell.greenshare.ui.viaggio.ViaggiDisponibiliFragment;
import com.rusthell.greenshare.ui.viaggio.ViaggioViewModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class HomeFragment extends Fragment {

//Inizializzo
    private EditText editText, editText2;
    private ViaggioViewModel viaggioViewModel;
    private TextView textView;
    private Button button, button2;
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
        myAwesomeTextView.setText("Ciao " + utenteService.getUtenteLoggato().getNome());
         viaggioViewModel = new ViewModelProvider(requireActivity()).get(ViaggioViewModel.class);
        textView = (TextView) view.findViewById(R.id.dataViaggio);
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
        viaggioViewModel.getDestinazione().observe(getViewLifecycleOwner(), set -> {
            editText.setText(viaggioViewModel.getDestinazione().getValue());
        });

        editText2 = (EditText) view.findViewById(R.id.cercaPEditText);
        editText2.setFocusable(false);
        editText2.setInputType(0);
        editText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new CercaPartenzaFragment();
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

        viaggioViewModel.getDestinazione().observe(getViewLifecycleOwner(), set -> {
            editText2.setText(viaggioViewModel.getPartenza().getValue());
        });

        //datepicker
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();

            }
        });

        button = (Button) view.findViewById(R.id.bottoneCerca);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    System.out.println("HAI CLICCATO IL BOTTONE");
                    viaggioViewModel.getViaggi();

                    System.out.println("Dopo viaggio view model get viaggi in HomeFragment");
                    Fragment viaggiDisponibiliFragment = new ViaggiDisponibiliFragment();
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .setCustomAnimations(R.anim.slide_in_bottom,
                                    R.anim.slide_out_top,
                                    R.anim.slide_in_top,
                                    R.anim.slide_out_bottom)
                            .replace(R.id.fragment_container, viaggiDisponibiliFragment)
                            .addToBackStack("HomeFragment")
                            .commit();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        button2 = (Button) view.findViewById(R.id.bottoneCrea);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("HAI CLICCATO IL BOTTONE CREA");
                ViaggioService viaggioService = new ViaggioService();
                viaggioService.creaViaggio(viaggioViewModel.getDestinazione().getValue(),
                        viaggioViewModel.getPartenza().getValue(), viaggioViewModel.getData().getValue(), utenteService.getUtenteLoggato());
                Toast.makeText(getActivity(), "Il viaggio è stato creato", Toast.LENGTH_LONG).show();
            }
        });

        viaggioViewModel.getViaggioTrovato().observe(getViewLifecycleOwner(), set ->{
            if(viaggioViewModel.getViaggioTrovato().getValue() == false)
            Toast.makeText(getActivity(), "Nessun viaggio trovato", Toast.LENGTH_LONG).show();
        });
        return view;
    }

    private void showDatePicker(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1+1;
                //converto int in stringe
                String giorno, mese, anno;
                giorno = Integer.toString(i2);
                mese = Integer.toString(i1);
                anno = Integer.toString(i);

                //se mese è di una sola cifra
                if(mese.length() == 1){
                    mese = "0" + mese;
                }

                String date = giorno + "-" + mese + "-" + anno;
                System.out.println("Data selezionata; " + date);
                textView.setText(date);
                viaggioViewModel.setData(LocalDate.parse(textView.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ITALIAN)));
            }
        },
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

}

