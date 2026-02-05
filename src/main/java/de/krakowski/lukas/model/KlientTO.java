package de.krakowski.lukas.model;

// TO Technical Object
// Besitzt die Daten aus der Datenbank; Dient zum Datentransfer

public class KlientTO {

    private String rechnungsempfaenger;
    private String sachbearbeiter;
    private String aktenzeichen;
    private String klientVorName;
    private String klientNachName;
    private String finanzStatus;
    private String wohnStatus;
    private Boolean abrechnungsStatus;


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

    public String getRechnungsempfaenger() {
        return rechnungsempfaenger;
    }


    public void setRechnungsempfaenger(String rechnungsempfaenger) {
        this.rechnungsempfaenger = rechnungsempfaenger;
    }


    public String getSachbearbeiter() {
        return sachbearbeiter;
    }


    public void setSachbearbeiter(String sachbearbeiter) {
        this.sachbearbeiter = sachbearbeiter;
    }


    public String getAktenzeichen() {
        return aktenzeichen;
    }


    public void setAktenzeichen(String aktenzeichen) {
        this.aktenzeichen = aktenzeichen;
    }


    public String getKlientVorName() {
        return klientVorName;
    }


    public void setKlientVorName(String klientVorName) {
        this.klientVorName = klientVorName;
    }


    public String getKlientNachName() {
        return klientNachName;
    }


    public void setKlientNachName(String klientNachName) {
        this.klientNachName = klientNachName;
    }


    public String getFinanzStatus() {
        return finanzStatus;
    }


    public void setFinanzStatus(String finanzStatus) {
        this.finanzStatus = finanzStatus;
    }


    public String getWohnStatus() {
        return wohnStatus;
    }


    public void setWohnStatus(String wohnStatus) {
        this.wohnStatus = wohnStatus;
    }


    public Boolean getAbrechnungsStatus() {
        return abrechnungsStatus;
    }


    public void setAbrechnungsStatus(Boolean abrechnungsStatus) {
        this.abrechnungsStatus = abrechnungsStatus;
    }


   


    


}
