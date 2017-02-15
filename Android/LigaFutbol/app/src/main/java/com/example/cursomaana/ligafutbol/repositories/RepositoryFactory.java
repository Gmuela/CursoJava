package com.example.cursomaana.ligafutbol.repositories;

public class RepositoryFactory {

    private static DataBasePartidos dataBasePartidos = null;

    public static DataBasePartidos getInstance(){
        if(dataBasePartidos == null){
            dataBasePartidos = new DataBasePartidos();
        }
        return dataBasePartidos;
    }

}
