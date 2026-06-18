package de.krakowski.lukas.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import de.krakowski.lukas.model.KlientTO;
import de.krakowski.lukas.model.RechnungTO;
import javafx.scene.image.Image;

public class RechnungspacketErzeugenService {

    //-----------Variablen----------------
    private RechnungFormatierenPDFService rechnungFormatierenPDFService;
    //-------------------------------------

    //-----------Konstruktor--------------
    public RechnungspacketErzeugenService(RechnungFormatierenPDFService rechnungFormatierenPDFService) {
        this.rechnungFormatierenPDFService = rechnungFormatierenPDFService;
    }
    //-------------------------------------

    //-----------Methoden-----------------
    public RechnungTO rechnungsPacketObjektErstellen(KlientTO klient) throws IOException {

        // Schritt 1: HTML laden
        InputStream stream = rechnungFormatierenPDFService.ladeHTMLRechnung();

        // Schritt 2: InputStream → String
        String html = rechnungFormatierenPDFService.htmlString(stream);

        // Schritt 3: HTML String → PDF Bytes
        byte[] pdfBytes = rechnungFormatierenPDFService.htmlPdfBytes(html);

        // Schritt 4: PDF Bytes → BufferedImage
        BufferedImage buffered = rechnungFormatierenPDFService.bufferedImageRechnung(pdfBytes);

        // Schritt 5: BufferedImage → JavaFX Image
        Image image = rechnungFormatierenPDFService.fXImageRechnung(buffered);

        // Schritt 6: Name aus KlientTO
        String name = klient.getKlientVorName() + " " + klient.getKlientNachName();

        // Schritt 7: RechnungTO befüllen und zurückgeben
        return new RechnungTO(image, pdfBytes, name);
    }
    //-------------------------------------
}
