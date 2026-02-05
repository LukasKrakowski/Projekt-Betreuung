package de.krakowski.lukas.service;



import java.sql.Timestamp;

import de.krakowski.lukas.model.KlientTO;

public class KlientenAbfrageService {


    // Input: Rechnungsempfänger(Amtsgericht);Sachbearbeiter;Aktenzeichen;KlientVorname;KlientNachname;Betreuungsanfang;FinanzStatus;WohnStatus;AbrechnungsStatus;
    //Hollt Daten aus DB und erzeugt damit das Objekt "KlientTO"

    public KlientTO klientenAbfrage (Timestamp zeit){
        
        
        return new KlientTO("null", "null", "null","null", "null", "null", "null", true);
    }

}
