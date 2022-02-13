package com.rusthell.greenshare.ui.viaggio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.rusthell.greenshare.R;

import java.util.ArrayList;

public class TappaAdapter extends RecyclerView.Adapter<TappaAdapter.Viewholder>{

    private ArrayList<String> tappe;
    private Context context;

    public TappaAdapter(Context context, ArrayList<String> tappe){
        this.context = context;
        this.tappe = tappe;
    }

    public TappaAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //dobbiamo inflatare
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tappa_container, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TappaAdapter.Viewholder holder, int position) {
        String model = tappe.get(position);
        System.out.println("In onBindViewHolder in TappaAdapter il nome della tappa è: " + model);
        holder.nome.setText(model);
    }

    @Override
    public int getItemCount() {
        return tappe.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView nome;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.textViewTappa);
        }
    }
}
