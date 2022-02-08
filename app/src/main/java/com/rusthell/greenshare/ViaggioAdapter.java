package com.rusthell.greenshare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rusthell.greenshare.domain.Viaggio;

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

        if(position % 2 == 0){
            System.out.println("paro");
            holder.status.setBackgroundColor(0xFF00FF00);
        }else{
           // holder.status.setColorFilter(R.color.quantum_vanillaredA700);
        }
        holder.partenza.setText(model.getPartenza());
        holder.arrivo.setText(model.getAndata());
        holder.orario.setText(model.getOrario().toString());
        holder.data.setText(model.getData().toString());
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
