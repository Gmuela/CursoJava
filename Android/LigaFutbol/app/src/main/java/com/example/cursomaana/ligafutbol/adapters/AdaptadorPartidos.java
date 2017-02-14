package com.example.cursomaana.ligafutbol.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cursomaana.ligafutbol.beans.Equipo;
import com.example.cursomaana.ligafutbol.beans.Partido;
import com.example.cursomaana.ligafutbol.R;

public class AdaptadorPartidos extends ArrayAdapter<Partido> {
    public AdaptadorPartidos(Context context, Partido[] datos) {
        super(context, R.layout.formato_lista_partidos, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View itemView = inflater.inflate(R.layout.formato_lista_partidos, null);

        ImageView imagen_local = (ImageView) itemView.findViewById(R.id.imagen_local);
        ImageView imagen_visitante = (ImageView) itemView.findViewById(R.id.imagen_visitante);

        TextView nombreLocal = (TextView) itemView.findViewById(R.id.nombre_equipo_local);
        TextView nombreVisitante = (TextView) itemView.findViewById(R.id.nombre_equipo_visitante);
        TextView fecha = (TextView) itemView.findViewById(R.id.fecha_partido);
        TextView hora = (TextView) itemView.findViewById(R.id.hora_partido);

        Partido partido = getItem(position);

        Equipo equipoLocal = partido.getEquipoLocal();
        Equipo equipoVisitante = partido.getEquipoVisitante();

        imagen_local.setImageResource(equipoLocal.getIdImagen());
        imagen_visitante.setImageResource(equipoVisitante.getIdImagen());

        fecha.setText(partido.getFecha());
        hora.setText(partido.getHora());

        nombreLocal.setText(equipoLocal.getNombreEquipo());
        nombreVisitante.setText(equipoVisitante.getNombreEquipo());

        return (itemView);
    }
}
