import javax.persistence.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name = "id_descuento", sequenceName = "descuento_sequence")
public class Descuento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_descuento")
    private Integer id;
    private int value;

    private LocalDate fechaFinal;

    public Descuento() {
    }

    public Descuento(int value, LocalDate fechaFinal) {
        this.value = value;
        this.fechaFinal = fechaFinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
}
