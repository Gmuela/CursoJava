package ejemplogoogleapi.cursomaana.example.com.ejemplostorage.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuarioSQLHelper extends SQLiteOpenHelper {

    private String createTableUsuarios = "CREATE TABLE Usuarios(_id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,password TEXT,email TEXT)";

    public UsuarioSQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL(createTableUsuarios);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
