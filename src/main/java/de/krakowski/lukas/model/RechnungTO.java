package de.krakowski.lukas.model;

import javafx.scene.image.Image;


public class RechnungTO {

    //-----------Varaiablen-------------
    private Image pdfImage;
    private byte[] pdfBytes;
    private String nameKlient;
    //----------------------------------

    //-----------Konstruktor------------
    public RechnungTO(Image pdfImage, byte[] pdfBytes, String nameKlient){

        this.pdfImage = pdfImage;
        this.pdfBytes = pdfBytes;
        this.nameKlient= nameKlient;
    }
    //-----------------------------------



    //---Image---geter-------------------
    public Image getPdfImage() {
        return pdfImage;
    }
    //-----------------------------------

    //---Bytes---geter-------------------
    public byte[] getPdfBytes() {
        return pdfBytes;
    }
    //-----------------------------------

    //---Name---geter--------------------
    public String getNameKlient() {
        return nameKlient;
    }
    //-----------------------------------
}
