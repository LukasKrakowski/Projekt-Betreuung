package de.krakowski.lukas.service;



import java.sql.Timestamp;

import de.krakowski.lukas.model.KlientTO;

public class KlientenAbfrageService {


    // Input: Datum
    //Hollt Daten aus DB und erzeugt damit das Objekt "KlientTO"

    public KlientTO klientenAbfrage (Timestamp zeit){
        
        
        return new KlientTO("null", true);
    }

}
