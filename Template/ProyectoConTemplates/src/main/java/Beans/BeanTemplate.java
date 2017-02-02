package Beans;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
//@SequenceGenerator(name = "id_bean", sequenceName = "bean_sequence")
public class BeanTemplate {
    @Id
//  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_bean")
    private Integer id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fecha;

//  @ManyToMany
//  @ManyToOne
//  @OneToMany
//  @OneToOne
//  private OtroBean otroBean;

    /*CONSTRUCTOR VACIO Y PARAMETRIZADO*/

    /*GETTERS Y SETTERS*/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
