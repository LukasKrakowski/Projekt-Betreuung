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
    //----------------------------------



    //---Image---geter&setter-----------
    public Image getPdfImage() {
        return pdfImage;
    }

    public void setPdfImage(Image pdfImage) {
        this.pdfImage = pdfImage;
    }
    //-----------------------------------

    //---Bytes---geter&setter------------
    public byte[] getPdfBytes() {
        return pdfBytes;
    }

    public void setPdfBytes(byte[] pdfBytes) {
        this.pdfBytes = pdfBytes;
    }
    //-----------------------------------

    //---Name---geter&setter-------------
    public String getNameKlient() {
        return nameKlient;
    }

    public void setNameKlient(String nameKlient) {
        this.nameKlient = nameKlient;
    }
    //-----------------------------------
}
