package DAO.Factories;

import DAO.PersonaDAO;
import DAO.PersonaDAOFichero;
import DAO.PersonaDAOJDBC;
import IOClasses.LectorFichero;

public class FactoryPersonaDAO {

    public static PersonaDAO getPersonaDAO(){
        PersonaDAO dao = null;
        LectorFichero lector = new LectorFichero("daoConfig.cfg");
        String linea = lector.leerLinea();
        String[] value = linea.split(":");
        String option = value[1];
        if(option.equalsIgnoreCase("file")){
            dao = new PersonaDAOFichero();
        } else if(option.equalsIgnoreCase("dataBase")){
            dao = new PersonaDAOJDBC();
        }

        return dao;
    }
}
