package de.krakowski.lukas.controller;

import de.krakowski.lukas.model.RechnungTO;
import de.krakowski.lukas.service.RechnungFormatierenPDFService;
import javafx.scene.image.Image;

public class RechnungspacketErzeugenController {

    //-----------Variablen----------------
    private Image pdfImage;
    private byte[] pdfBytes;
    private String nameKlient;
    private RechnungFormatierenPDFService rechnungFormatierenPDFService;
    //-------------------------------------

   public RechnungspacketErzeugenController(RechnungFormatierenPDFService rechnungFormatierenPDFService){

        this.rechnungFormatierenPDFService = rechnungFormatierenPDFService;
   }

    public RechnungTO rechnungsPacketObjektErstellen(){

    RechnungTO rechnungTO = new RechnungTO(null, null, null);  // Neues Rechnungsobjekt wird erstellt
    return rechnungTO;
    }

}
