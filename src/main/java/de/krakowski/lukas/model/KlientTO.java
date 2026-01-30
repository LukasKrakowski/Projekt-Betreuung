package de.krakowski.lukas.model;

// TO Technical Object
public class KlientTO {

    private String name;
    private Boolean abrechnungsStatus;

    public KlientTO(String name, Boolean abrechnungsStatus) {
        this.name = name;
        this.abrechnungsStatus = abrechnungsStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAbrechnungsStatus() {
        return abrechnungsStatus;
    }

    public void setAbrechnungsStatus(Boolean abrechnungsStatus) {
        this.abrechnungsStatus = abrechnungsStatus;
    }  

}
