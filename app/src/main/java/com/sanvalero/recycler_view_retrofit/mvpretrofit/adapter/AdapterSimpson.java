package com.sanvalero.recycler_view_retrofit.mvpretrofit.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sanvalero.recycler_view_retrofit.R;
import com.sanvalero.recycler_view_retrofit.mvpretrofit.entities.Simpson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterSimpson extends RecyclerView.Adapter<AdapterSimpson.ViewHolderSimpson> {

    ArrayList<Simpson> lstSimpson;

    public AdapterSimpson(ArrayList<Simpson> lstSimpson) {
        this.lstSimpson = lstSimpson;
    }

    @NonNull
    @Override
    public AdapterSimpson.ViewHolderSimpson onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_personajes, null, false);

        return new ViewHolderSimpson(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSimpson.ViewHolderSimpson holder, int position) {
        holder.etiNombre.setText(lstSimpson.get(position).getCharacter());
        holder.etiInformacion.setText(lstSimpson.get(position).getQuote());
        Picasso.get().load(lstSimpson.get(position).getImage()).error(R.drawable.krusti).into(holder.foto);
    }

    @Override
    public int getItemCount() {
        return lstSimpson.size();
    }

    public class ViewHolderSimpson extends RecyclerView.ViewHolder {
        TextView etiNombre, etiInformacion;
        ImageView foto;

        public ViewHolderSimpson(@NonNull View itemView) {
            super(itemView);

            etiNombre = (TextView) itemView.findViewById(R.id.idNombre);
            etiInformacion = (TextView) itemView.findViewById(R.id.idInfo);
            foto = (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}
