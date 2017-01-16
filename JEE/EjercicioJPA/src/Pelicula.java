import javax.persistence.*;

@Entity
@SequenceGenerator(name = "id_pelicula", sequenceName = "pelicula_sequence")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_pelicula")
    private Integer id;
    private String titulo;
    private int duracion;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Descuento descuento;

    public Pelicula() {
    }

    public Pelicula(String titulo, int duracion, Descuento descuento) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.descuento = descuento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }
}
