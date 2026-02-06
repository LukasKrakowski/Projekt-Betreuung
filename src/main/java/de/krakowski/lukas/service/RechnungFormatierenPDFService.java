package de.krakowski.lukas.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.apache.pdfbox.pdmodel.PDDocument;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

// Bekomme Alle Daten um PDF Felder auszufüllen gebe fertige PDF an "RechnungBereitstellenController" + Name des Klienten

public class RechnungFormatierenPDFService {

    private void rechnungFormatieren() throws IOException {

    // HTML-Datei aus "resources" laden
    InputStream htmlRechnungStream = getClass().getResourceAsStream("/rechnungPDF.html");

    if (htmlRechnungStream == null) {
        throw new IllegalStateException("Resource 'rechnungPDF.html' wurde nicht gefunden");
    }

    // HTML-Inhalt als String
    String htmlRechnung = new String(htmlRechnungStream.readAllBytes(), StandardCharsets.UTF_8);

    // String zu byts (html Daten)
    ByteArrayOutputStream pdfOut = new ByteArrayOutputStream();

    PdfRendererBuilder builder = new PdfRendererBuilder();
    builder.withHtmlContent(htmlRechnung, null);
    builder.toStream(pdfOut);
    builder.run();

    byte[] pdfRechnungsBytes = pdfOut.toByteArray();

    //

    PDDocument documentRechnung = PDDocument.load(new ByteArrayInputStream(pdfRechnungsBytes));

    
    //htmlRechnungStream = HTML 
    //htmlRechnung = String
    //pdfRechnungsBytes = Byte
    //documentRechnung = PDDocument

    }   
}
