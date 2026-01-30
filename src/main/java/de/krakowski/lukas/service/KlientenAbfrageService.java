package de.krakowski.lukas.service;



import java.sql.Timestamp;

import de.krakowski.lukas.model.KlientTO;

public class KlientenAbfrageService {


    // Input: Datum
    //Output: Name, Abrechnungsstatus

    public KlientTO klientenAbfrage (Timestamp zeit){
        
        
        return new KlientTO("null", true);
    }

}
