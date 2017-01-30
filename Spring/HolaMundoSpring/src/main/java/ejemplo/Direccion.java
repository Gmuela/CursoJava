package ejemplo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Direccion implements Serializable {

    private String calle;
    private Integer codigoPostal;

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
