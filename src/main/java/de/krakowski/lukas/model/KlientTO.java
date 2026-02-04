package de.krakowski.lukas.model;

// TO Technical Object
// Besitzt die Daten aus der Datenbank; Dient zum Datentransfer

public class KlientTO {

    private String vorName;
    private String nachName;
    private String VorgangsNummer;
    private Boolean abrechnungsStatus;


    public KlientTO(String vorName, Boolean abrechnungsStatus) {
        this.vorName = vorName;
        this.abrechnungsStatus = abrechnungsStatus;
    }


    // Namen
    public String getVorName() {
        return vorName;
    }

    public void setVorName(String vorName) {
        this.vorName = vorName;
    }


    public String getNachName() {
        return nachName;
    }

    public void setNachName(String nachName) {
        this.nachName = nachName;
    }


    // ID
    public String getVorgangsNummer() {
        return VorgangsNummer;
    }

    public void setVorgangsNummer(String iD) {
        VorgangsNummer = iD;
    }
   

    // Abrechnungsstatus
    public Boolean getAbrechnungsStatus() {
        return abrechnungsStatus;
    }

    public void setAbrechnungsStatus(Boolean abrechnungsStatus) {
        this.abrechnungsStatus = abrechnungsStatus;
    }  

}
