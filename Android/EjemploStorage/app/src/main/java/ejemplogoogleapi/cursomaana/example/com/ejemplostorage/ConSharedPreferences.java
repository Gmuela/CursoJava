package ejemplogoogleapi.cursomaana.example.com.ejemplostorage;

/**
 * Created by curso mañana on 17/02/2017.
 */

public class ConSharedPreferences {
    /*****************************CLASE MAIN ACTIVITY****************************************/
    /************************************************************************************/
    /************************************************************************************/
    /************************************************************************************/

    /**
    final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    final SharedPreferences.Editor editor = preferences.edit();

    int preferencesInt = preferences.getInt("idUsuario", 0);

    if (preferencesInt == 0) {
        editor.putInt("idUsuario", 0);
        editor.apply();
    } else {
        this.idUsuario = preferencesInt;
    }


    actualizar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Usuario usuario = new Usuario("Hola Actualización", "123456", "gmuela92@gmail.com");
            Gson gson = new Gson();
            String usuarioJSON = gson.toJson(usuario);
            editor.putString("usuario0", usuarioJSON);
            editor.commit();
        }
    });

    verDatos.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent nextIntent = new Intent(MainActivity.this, ListaUsuariosActivity.class);
            startActivity(nextIntent);
        }
    });

    borrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editor.remove("usuario0");
            editor.commit();
        }
    });
    */

    /*****************************CLASE VER DATOS****************************************/
    /************************************************************************************/
    /************************************************************************************/
    /************************************************************************************/
    /**
     SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
     List<Usuario> usuarios = new ArrayList<Usuario>();

     Map<String, ?> prefs = preferences.getAll();

     for (String key : prefs.keySet()) {
     Object pref = prefs.get(key);
     if (pref instanceof String) {
     Gson gson = new Gson();
     String usuarioJSON = (String)pref;
     Usuario usuario = gson.fromJson(usuarioJSON, Usuario.class);
     usuarios.add(usuario);
     }
     }

     AdaptadorUsuario adaptadorUsuario = new AdaptadorUsuario(this, usuarios);
     ListView listaUsuarios = (ListView) findViewById(R.id.lista_usuarios);
     listaUsuarios.setAdapter(adaptadorUsuario);
     */
}
