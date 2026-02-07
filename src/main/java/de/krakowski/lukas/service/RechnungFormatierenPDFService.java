package de.krakowski.lukas.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import java.awt.image.BufferedImage;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;


// Bekomme Alle Daten um PDF Felder auszufüllen gebe fertige PDF an "RechnungBereitstellenController" + Name des Klienten

public class RechnungFormatierenPDFService {

    public Image rechnungFormatieren() throws IOException {

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

    //byts zu PDDocument

    PDDocument documentRechnung = PDDocument.load(new ByteArrayInputStream(pdfRechnungsBytes));

    //PDDocument zu BufferedImage

    PDFRenderer renderer = new PDFRenderer(documentRechnung);
    BufferedImage bufferedRechnung = renderer.renderImageWithDPI(0, 150); 

    //BufferedImage zu Image

    Image imageRechnung = SwingFXUtils.toFXImage(bufferedRechnung, null);

    documentRechnung.close();

    System.out.println(getClass().getResource("/rechnungPDF.html"));

    return imageRechnung;
    
    //htmlRechnungStream = HTML 
    //htmlRechnung = String
    //pdfRechnungsBytes = Byte
    //documentRechnung = PDDocument
    //bufferedRechnung = BufferedImage
    //imageRechnung = JavaFXImage
    }   
}
