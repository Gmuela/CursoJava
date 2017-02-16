package com.example.cursomaana.ligafutbol.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cursomaana.ligafutbol.R;
import com.example.cursomaana.ligafutbol.activities.DetalleEquipoActivity;
import com.example.cursomaana.ligafutbol.beans.Equipo;
import com.example.cursomaana.ligafutbol.beans.Partido;

public class AdaptadorPartidos extends ArrayAdapter<Partido> {
    public AdaptadorPartidos(Context context, Partido[] datos) {
        super(context, R.layout.formato_lista_partidos, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;
        ViewHolderPartidos holder;

        if (itemView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            itemView = inflater.inflate(R.layout.formato_lista_partidos, null);
            holder = new ViewHolderPartidos();

            holder.imagen_local = (ImageView) itemView.findViewById(R.id.imagen_local);
            holder.imagen_visitante = (ImageView) itemView.findViewById(R.id.imagen_visitante);

            holder.nombreLocal = (TextView) itemView.findViewById(R.id.nombre_equipo_local);
            holder.nombreVisitante = (TextView) itemView.findViewById(R.id.nombre_equipo_visitante);
            holder.fecha = (TextView) itemView.findViewById(R.id.fecha_partido);
            holder.hora = (TextView) itemView.findViewById(R.id.hora_partido);

            itemView.setTag(holder);

        } else{
            holder = (ViewHolderPartidos) itemView.getTag();
        }

        Partido partido = getItem(position);
        final Equipo equipoLocal = partido.getEquipoLocal();
        final Equipo equipoVisitante = partido.getEquipoVisitante();

        holder.imagen_local.setImageResource(equipoLocal.getImagenEscudo());
        holder.imagen_local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(getContext(), DetalleEquipoActivity.class);
                nextIntent.putExtra("equipo", equipoLocal.getId());
                getContext().startActivity(nextIntent);
            }
        });

        holder.imagen_visitante.setImageResource(equipoVisitante.getImagenEscudo());
        holder.imagen_visitante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(getContext(), DetalleEquipoActivity.class);
                nextIntent.putExtra("equipo", equipoVisitante.getId());
                getContext().startActivity(nextIntent);
            }
        });

        holder.nombreLocal.setText(equipoLocal.getNombreEquipo());
        holder.nombreVisitante.setText(equipoVisitante.getNombreEquipo());

        if(partido.isJugado()){
            holder.fecha.setText(partido.getResultado());
            holder.fecha.setTextColor(Color.BLUE);
            holder.fecha.setTextSize(25f);
            holder.hora.setText("");
        } else {
            holder.fecha.setText(partido.getFecha());
            holder.hora.setText(partido.getHora());
        }


        return (itemView);
    }

    private class ViewHolderPartidos {
        ImageView imagen_local;
        ImageView imagen_visitante;

        TextView nombreLocal;
        TextView nombreVisitante;
        TextView fecha;
        TextView hora;
    }
}
