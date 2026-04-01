package de.krakowski.lukas.model;

// TO Technical Object
// Besitzt die Daten aus der Datenbank; Dient zum Datentransfer

public class KlientTO {

    //-----------Varaiablen-------------
    private String rechnungsempfaenger;
    private String sachbearbeiter;
    private String aktenzeichen;
    private String klientVorName;
    private String klientNachName;
    private String finanzStatus;
    private String wohnStatus;
    private Boolean abrechnungsStatus;
    //----------------------------------

    //-----------Konstruktor------------
     public KlientTO(String rechnungsempfeanger, String sachbearbeiter, String aktenzeichen, String klientVorName, String klientNachName, String finanzStatus, String wohnStatus, Boolean abrechnungsStatus) {
        this.rechnungsempfaenger = rechnungsempfeanger;
        this.sachbearbeiter = sachbearbeiter;
        this.aktenzeichen = aktenzeichen;
        this.klientVorName = klientVorName;
        this.klientNachName = klientNachName;
        this.finanzStatus = finanzStatus;
        this.wohnStatus = wohnStatus;
        this.abrechnungsStatus = abrechnungsStatus;
    }
    //----------------------------------



    //---------------getter-------------
    public String getRechnungsempfaenger() {
        return rechnungsempfaenger;
    }


    public String getSachbearbeiter() {
        return sachbearbeiter;
    }


    public String getAktenzeichen() {
        return aktenzeichen;
    }


    public String getKlientVorName() {
        return klientVorName;
    }


    public String getKlientNachName() {
        return klientNachName;
    }


    public String getFinanzStatus() {
        return finanzStatus;
    }


    public String getWohnStatus() {
        return wohnStatus;
    }


    public Boolean getAbrechnungsStatus() {
        return abrechnungsStatus;
    }
    //----------------------------------

}
