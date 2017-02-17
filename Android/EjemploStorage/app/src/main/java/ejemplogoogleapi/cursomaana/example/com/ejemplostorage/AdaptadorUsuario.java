package ejemplogoogleapi.cursomaana.example.com.ejemplostorage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorUsuario extends ArrayAdapter<Usuario> {
    public AdaptadorUsuario(Context context, List<Usuario> datos) {
        super(context,R.layout.formato_usuario, datos);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        ViewHolderJugadores holder;

        if (itemView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            itemView = inflater.inflate(R.layout.formato_usuario, null);
            holder = new ViewHolderJugadores();

            holder.nombre = (TextView) itemView.findViewById(R.id.nombre_usuario);
            holder.password = (TextView) itemView.findViewById(R.id.password_usuario);
            holder.email = (TextView) itemView.findViewById(R.id.email_usuario);
            itemView.setTag(holder);

        } else{
            holder = (ViewHolderJugadores) itemView.getTag();
        }

        Usuario usuario = getItem(position);
        holder.nombre.setText(usuario.getNombre());
        holder.password.setText(usuario.getPassword());
        holder.email.setText(usuario.getEmail());

        return (itemView);
    }

    private class ViewHolderJugadores {
        TextView nombre;
        TextView password;
        TextView email;
    }
}
