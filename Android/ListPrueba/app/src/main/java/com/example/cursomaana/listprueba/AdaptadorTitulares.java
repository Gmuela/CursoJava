package com.example.cursomaana.listprueba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class AdaptadorTitulares extends ArrayAdapter<Titular> {
    public AdaptadorTitulares(Context context, Titular[] datos) {
        super(context, R.layout.vista_titular, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View itemView = inflater.inflate(R.layout.vista_titular, null);
        TextView lblTitulo = (TextView) itemView.findViewById(R.id.titulo);
        lblTitulo.setText(getItem(position).getTitular());
        TextView lblSubtitulo = (TextView) itemView.findViewById(R.id.subtitulo);
        lblSubtitulo.setText(getItem(position).getSubtitular());
        return (itemView);
    }
}
