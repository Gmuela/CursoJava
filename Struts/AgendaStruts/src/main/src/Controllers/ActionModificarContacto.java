package Controllers;

import Beans.Contacto;
import Business.ContactoBusiness;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ActionModificarContacto extends ActionSupport implements ModelDriven<Contacto> {

    private Contacto contacto = new Contacto();
    private ContactoBusiness contactoBusiness = new ContactoBusiness();

    @Override
    public String execute() throws Exception {
        contactoBusiness.modifyContacto(contacto);
        return SUCCESS;
    }

    @Override
    public Contacto getModel() {
        return contacto;
    }
}
