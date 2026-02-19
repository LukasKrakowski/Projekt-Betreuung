package de.krakowski.lukas.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import de.krakowski.lukas.service.RechnungFormatierenPDFService;
import de.krakowski.lukas.view.View;
import javafx.scene.image.Image;

public class RechnungBereitstellenController {

    private View dieView;

    public RechnungBereitstellenController(View pView){
        dieView = pView;
    }

    // Gibt View die Fertige PDF zurück + Meldet DB das Klient bearbeitet wurde

   
}
