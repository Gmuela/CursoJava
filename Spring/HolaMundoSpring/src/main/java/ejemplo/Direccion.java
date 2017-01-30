package ejemplo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Direccion implements Serializable {

    private String calle="una calle de paris";
    private Integer codigoPostal=28514;

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
