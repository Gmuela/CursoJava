package Controller;

import Bean.BusquedaOferta;
import Bean.Oferta;
import Modelo.Negocio.Gestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/busquedaOfertas.do")
public class BusquedaOfertas {

    @Autowired
    @Qualifier("GestionOferta")
    private Gestion<Oferta> ofertaGestion;

    @RequestMapping(method = RequestMethod.GET)
    public String rellenarFormulario(Model modelo){
        BusquedaOferta busquedaOferta = new BusquedaOferta();
        busquedaOferta.setNumNoches(1);
        busquedaOferta.setPrecio(60);
        modelo.addAttribute("busquedaOferta", busquedaOferta);

        return "busquedaOfertas";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String procesarFormulario(@ModelAttribute("busquedaOferta") BusquedaOferta busquedaOferta,
                                     BindingResult bindingResult,
                                     Model modelo){
        if(busquedaOferta.getPrecio() < 0){
            bindingResult.rejectValue("precio", "negativeNumber");
            return "busquedaOfertas";
        }
        if(bindingResult.hasErrors()){
            return "busquedaOfertas";
        }
        List<Oferta> ofertas = ofertaGestion.getResultFilterBy(busquedaOferta);
        modelo.addAttribute("ofertas",ofertas);
        return "vistaOfertas";
    }

}
