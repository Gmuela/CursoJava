package cursomaana.example.com.androidexamen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class AdaptadorSpinnerNacionalidad extends ArrayAdapter<Pais> {
    public AdaptadorSpinnerNacionalidad(Context context, Pais[] paises) {
        super(context, R.layout.spinner_view, paises);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.spinner_dropdown_paises, parent, false);

        TextView label = (TextView) row.findViewById(R.id.nombre_dd);
        ImageView icon = (ImageView) row.findViewById(R.id.imagen_bandera_dd);

        Pais pais = getItem(position);

        icon.setImageResource(pais.getBandera());
        label.setText(pais.getNombre());

        return row;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;
        ViewHolderPaises holder;

        if (itemView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            itemView = inflater.inflate(R.layout.spinner_view, null);
            holder = new ViewHolderPaises();

            holder.bandera = (ImageView) itemView.findViewById(R.id.imagen_bandera);
            holder.nombre = (TextView) itemView.findViewById(R.id.nombre);

            itemView.setTag(holder);

        } else {
            holder = (ViewHolderPaises) itemView.getTag();
        }

        Pais pais = getItem(position);

        holder.bandera.setImageResource(pais.getBandera());
        holder.nombre.setText(pais.getNombre());

        return (itemView);
    }

    private class ViewHolderPaises {
        ImageView bandera;
        TextView nombre;
    }
}
