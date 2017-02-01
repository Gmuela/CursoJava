package Modelo.Negocio;

import Bean.BusquedaOferta;
import Bean.Oferta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("GestionOferta")
public class GestionOfertas implements Gestion<Oferta> {

    private List<Oferta> ofertas;

    public GestionOfertas() {
        init();
    }

    public void init() {
        ofertas = new ArrayList<Oferta>();
        ofertas.add(new Oferta(50.5, 1, "Miguel Ángel"));
        ofertas.add(new Oferta(25.0, 2, "Alcalá Hotel"));
        ofertas.add(new Oferta(1250.78, 10, "Gran Hotel"));
        ofertas.add(new Oferta(150.8, 3, "Rich"));
    }

    @Override
    public List<Oferta> getResult(double precio) {

        List<Oferta> ofertasResult = new ArrayList<Oferta>();

        if (precio > 0) {
            for (Oferta oferta : ofertas) {
                if (oferta.getPrecio() < precio) {
                    ofertasResult.add(oferta);
                }
            }
        } else {
            ofertasResult = ofertas;
        }
        return ofertasResult;
    }

    @Override
    public List<Oferta> getResultFilterBy(BusquedaOferta busquedaOferta) {
        List<Oferta> ofertasResult = new ArrayList<Oferta>();

        double precio = busquedaOferta.getPrecio();


        for (Oferta oferta : ofertas) {
            if (oferta.getPrecio() <= precio && oferta.getNumNoches() == busquedaOferta.getNumNoches()) {
                ofertasResult.add(oferta);
            }
        }


        return ofertasResult;
    }


}
