package com.rusthell.greenshare;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.rusthell.greenshare.domain.Viaggio;
import com.rusthell.greenshare.ui.viaggio.InfoFragment;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ViaggioAdapter extends RecyclerView.Adapter<ViaggioAdapter.Viewholder>{

    private Context context;
    private ArrayList<Viaggio> viaggioArrayList;


    //Costruttore
    public ViaggioAdapter(Context context, ArrayList<Viaggio> viaggioArrayList){
        this.context = context;
        this.viaggioArrayList = viaggioArrayList;
    }


    @NonNull
    @Override
    public ViaggioAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //per inflatare il layout di ogni item nel recyclerview
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viaggio_data_container, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViaggioAdapter.Viewholder holder, int position) {
        Viaggio model = viaggioArrayList.get(position);
        System.out.println("In viaggio adapter il numero di posizione è:" + position);

        if(model.getConcluso() == false){
            System.out.println("concluso");
            holder.status.setBackgroundColor(0xFF00FF00);
        }else{
            holder.status.setBackgroundColor(0xFFFF0000);

        }
        holder.partenza.setText(model.getPartenza());
        holder.arrivo.setText(model.getArrivo());
        holder.orario.setText(model.getOrario().format(DateTimeFormatter.ofPattern("HH:mm")));
        holder.data.setText(model.getData().toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("hai toccato l'item con partenza: " + model.getPartenza());
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                //se il viaggio è cocluso apre la schermata di recensione, se ancora non lo è apre la schermata di modifica\
                //creo un bundle per passare i dati direttament al frammento contenente tutte le info del viaggio
                Bundle args = new Bundle();
                args.putSerializable("viaggio", model);
              //  if(model.getConcluso() == false){
                    Fragment fragment = new InfoFragment();
                    fragment.setArguments(args);
                    activity.getSupportFragmentManager().
                            beginTransaction().
                            setReorderingAllowed(true).
                            addSharedElement(view, "anim1").
                            replace(R.id.fragment_container, fragment).
                            commit();
               // }
            }
        });
    }

    @Override
    public int getItemCount() {
        return viaggioArrayList.size();
    }



    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView partenza, arrivo, data, orario;
         private View status;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            status = (View) itemView.findViewById(R.id.statusImageView);
            partenza = itemView.findViewById(R.id.textViewPartenza);
            arrivo = itemView.findViewById(R.id.textViewArrivo);
            orario = itemView.findViewById(R.id.textViewOrario);
            data = itemView.findViewById(R.id.textViewData);
        }
    }

}
