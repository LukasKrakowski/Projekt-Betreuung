package de.krakowski.lukas.controller;

import de.krakowski.lukas.model.RechnungTO;
import de.krakowski.lukas.service.RechnungFormatierenPDFService;
import javafx.scene.image.Image;

public class RechnungspacketErzeugenController {

    private Image pdfImage;
    private byte[] pdfBytes;
    private String nameKlient;
    private RechnungFormatierenPDFService rechnungFormatierenPDFService = new RechnungFormatierenPDFService();

    public RechnungspacketErzeugenController(){

         

        
    }

    public RechnungTO rechnungsPacketObjektErstellen(){

        return new RechnungTO(null, null, null);
    }

}
