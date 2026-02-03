package de.krakowski.lukas.model;

// TO Technical Object
// Besitzt die Daten aus der Datenbank; Dient zum Datentransfer

public class KlientTO {

    private String vorName;
    private String nachName;
    private String ID;
    private Boolean abrechnungsStatus;

    public KlientTO(String vorName, Boolean abrechnungsStatus) {
        this.vorName = vorName;
        this.abrechnungsStatus = abrechnungsStatus;
    }

    public String getName() {
        return vorName;
    }

    public void setName(String name) {
        this.vorName = vorName;
    }

    public Boolean getAbrechnungsStatus() {
        return abrechnungsStatus;
    }

    public void setAbrechnungsStatus(Boolean abrechnungsStatus) {
        this.abrechnungsStatus = abrechnungsStatus;
    }  

}
