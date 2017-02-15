package com.example.cursomaana.ligafutbol.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cursomaana.ligafutbol.R;
import com.example.cursomaana.ligafutbol.beans.Jugador;

public class AdaptadorJugadores extends ArrayAdapter<Jugador> {
    public AdaptadorJugadores(Context context, Jugador[] datos) {
        super(context, R.layout.formato_jugadores, datos);
    }

    public View getView(int position, View convertView, final ViewGroup parent) {

        View itemView = convertView;
        ViewHolderJugadores holder;

        if (itemView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            itemView = inflater.inflate(R.layout.formato_jugadores, null);
            holder = new ViewHolderJugadores();

            holder.imagenJugador = (ImageView) itemView.findViewById(R.id.imagen_jugador);
            holder.nombreDorsal = (TextView) itemView.findViewById(R.id.nombre_dorsal);

            itemView.setTag(holder);

        } else{
            holder = (ViewHolderJugadores) itemView.getTag();
        }

        final Jugador jugador = getItem(position);

        holder.imagenJugador.setImageResource(jugador.getImagen());
        holder.nombreDorsal.setText(jugador.getNombre() + " #"+jugador.getDorsal());

        return (itemView);
    }

    private class ViewHolderJugadores {
        ImageView imagenJugador;
        TextView nombreDorsal;
    }
}
