package Controller;

import Bean.BusquedaOferta;
import Bean.Oferta;
import Modelo.Negocio.Gestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/ofertas.do")
public class ControlOfertas {

    @Autowired
    @Qualifier("GestionOferta")
    private Gestion<Oferta> ofertaGestion;

    @RequestMapping(method = RequestMethod.GET)
    public String procesar(@RequestParam(value = "precio", required = false, defaultValue = "0.0") double precio, Model modelo){

        List<Oferta> ofertas = ofertaGestion.getResult(precio);
        modelo.addAttribute("ofertas",ofertas);
        return "vistaOfertas";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String procesarFormulario(BusquedaOferta busquedaOferta, Model modelo){

        List<Oferta> ofertas = ofertaGestion.getResultFilterBy(busquedaOferta);
        modelo.addAttribute("ofertas",ofertas);
        return "vistaOfertas";
    }

}
