package com.utad.sergio.pmdmactividad2.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.utad.sergio.pmdmactividad2.FBObjects.FBCoches;
import com.utad.sergio.pmdmactividad2.FBObjects.Message;
import com.utad.sergio.pmdmactividad2.R;

import java.util.ArrayList;

/**
 * Created by sergio on 19/12/17.
 */

public class ListaCochesAdapter extends RecyclerView.Adapter<CocheViewHolder> {

    private ArrayList<FBCoches> coches;

    public ListaCochesAdapter(ArrayList<FBCoches> coches){
        this.coches=coches;
    }
    @Override
    public CocheViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos XML de la Celda
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda_coche_layout,null);
        CocheViewHolder cocheViewHolder = new CocheViewHolder(view);
        return cocheViewHolder;
    }

    @Override
    public void onBindViewHolder(CocheViewHolder holder, int position) {
        //holder.txtMsg.setText(coches.get(position).original);
        holder.tvfabricado.setText(coches.get(position).Fabricado+"");
        holder.tvmarca.setText(coches.get(position).Marca);
        holder.tvnombre.setText(coches.get(position).Nombre);
        holder.tvlat.setText(coches.get(position).lat+"");
        holder.tvlon.setText(coches.get(position).lon+"");

    }

    @Override
    public int getItemCount() {

        return coches.size();
    }
}

class CocheViewHolder extends RecyclerView.ViewHolder {

    public TextView tvfabricado, tvmarca, tvnombre, tvlat, tvlon;

    public CocheViewHolder(View itemView) {

        super(itemView);
        tvfabricado=itemView.findViewById(R.id.tvfabricado);
        tvmarca=itemView.findViewById(R.id.tvmarca);
        tvnombre=itemView.findViewById(R.id.tvnombre);
        tvlat=itemView.findViewById(R.id.tvlat);
        tvlon=itemView.findViewById(R.id.tvlon);

    }
}