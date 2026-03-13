package de.krakowski.lukas.service;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

    //htmlRechnungStream = HTML 
    //htmlRechnung = String
    //pdfRechnungsBytes = Byte
    //documentRechnung = PDDocument
    //bufferedRechnung = BufferedImage
    //imageRechnung = JavaFXImage

public class RechnungFormatierenPDFService {

    // HTML-Datei aus resources laden
    public InputStream ladeHTMLRechnung() {
    InputStream streamRechnung = getClass().getResourceAsStream("/rechnungPDF.html");
    if (streamRechnung == null) {
        throw new IllegalStateException("Resource 'rechnungPDF.html' nicht gefunden");
    }
    return streamRechnung;
}

    // HTML InputStream → String
    public String htmlString(InputStream htmlStream) throws IOException {
        try (htmlStream) {
            return new String(htmlStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    // HTML String → PDF Bytes
    public byte[] htmlPdfBytes(String html) throws IOException {
        try(ByteArrayOutputStream pdfOut = new ByteArrayOutputStream()){

            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withHtmlContent(html, null);
            builder.toStream(pdfOut);
            builder.run();

            return pdfOut.toByteArray();
        }
    }

    // PDF Bytes → BufferedImage
    public BufferedImage bufferedImageRechnung(byte[] pdfBytes) throws IOException {

        try (PDDocument document = PDDocument.load(new ByteArrayInputStream(pdfBytes))) {
            PDFRenderer renderer = new PDFRenderer(document);
            return renderer.renderImageWithDPI(0, 150);
        }
    }

    // BufferedImage → JavaFX Image
    public Image fXImageRechnung(BufferedImage bufferedImage) {
        
        return SwingFXUtils.toFXImage(bufferedImage, null); 
    }
    
}
