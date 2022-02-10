package com.rusthell.greenshare.ui.viaggio;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.rusthell.greenshare.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class CercaDestinazioneFragment extends Fragment {
    //Inizializzo
    private TextView textView;
    private TextView textView2;
    private AutoCompleteTextView autoCompleteTextView;
    private ViaggioViewModel viaggioViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cerca_destinazione, container, false);

        //instanziamo viewModel
        viaggioViewModel = new ViewModelProvider(requireActivity()).get(ViaggioViewModel.class);



        String [] CITTA = new String[]{
                "Teramo", "L'Aquila", "Avezzano", "Chieti", "Pescara", "Forcella", "Val Vomano", "Basciano",
                "Bazzano", "Montorio", "Valle Cupa", "Capestrano", "Navelli", "Popoli", "Ter", "Tera"};

        //places autocomplete
       // textView = (TextView) view.findViewById(R.id.textview);
       // textView2 = (TextView) view.findViewById(R.id.textview2);
        autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.cercaDestinazioneAutocomplete);
       /* Places.initialize(getActivity().getApplicationContext(), "AIzaSyBNTS0lqjxxnk7znMHw2GEBEf_-bjJypEo");

        //places by google

        // Initialize the AutocompleteSupportFragment.
        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getChildFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        // Specify the types of place data to return.
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));

        // Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {
                // TODO: Get info about the selected place.
                Log.i(TAG, "Place: " + place.getName() + ", " + place.getId());
            }


            @Override
            public void onError(@NonNull Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {
                // TODO: Get info about the selected place.
                Toast.makeText(getActivity().getApplicationContext(), place.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(@NonNull Status status) {
                // TODO: Handle the error.
                Toast.makeText(getActivity().getApplicationContext(), status.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        */

        //adesso programmo l'autocomplete text view

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, CITTA);
        autoCompleteTextView.setThreshold(1);

        //autoCompleteTextView.setText("0x");
      //  autoCompleteTextView.requestFocus();
       // InputMethodManager inputManager = (InputMethodManager)getActivity().getSystemService(INPUT_METHOD_SERVICE);
       // inputManager.restartInput(autoCompleteTextView);
        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("Hai premuto");
                String selected = adapterView.getItemAtPosition(i).toString();
                System.out.println("Hai premuto: " + selected);
                viaggioViewModel.setDestinazione(selected);

            }
        });
        return view;
    }



}