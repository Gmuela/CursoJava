package cursomaana.example.com.androidexamen;

public class Pais {
    private Integer bandera;
    private String nombre;

    public Pais(Integer bandera, String nombre) {
        this.bandera = bandera;
        this.nombre = nombre;
    }

    public Integer getBandera() {
        return bandera;
    }

    public void setBandera(Integer bandera) {
        this.bandera = bandera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
