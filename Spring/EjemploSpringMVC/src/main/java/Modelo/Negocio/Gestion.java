package Modelo.Negocio;

import Bean.BusquedaOferta;
import Bean.Oferta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Gestion<Type> {

    List<Type> getResult(double precio);

    List<Oferta> getResultFilterBy(BusquedaOferta busquedaOferta);
}
