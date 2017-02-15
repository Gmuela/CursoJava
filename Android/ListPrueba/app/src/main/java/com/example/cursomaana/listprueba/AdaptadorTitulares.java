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

        View itemView = convertView;
        ViewHolder holder;
        if (itemView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            itemView = inflater.inflate(R.layout.vista_titular, null);
            holder = new ViewHolder();
            holder.titulo = (TextView) itemView.findViewById(R.id.titulo);
            holder.subtitulo = (TextView) itemView.findViewById(R.id.subtitulo);
            itemView.setTag(holder);
        } else{
            holder = (ViewHolder) itemView.getTag();
        }
        holder.titulo.setText(getItem(position).getTitular());
        holder.subtitulo.setText(getItem(position).getSubtitular());
        return (itemView);
    }

    class ViewHolder{
        TextView titulo;
        TextView subtitulo;
    }
}
