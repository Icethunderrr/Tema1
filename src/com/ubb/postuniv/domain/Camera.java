package com.ubb.postuniv.domain;

public class Camera {
    private String id;  //id camera
    private String denumire;    //nenula
    private float pret;
    private int pat;    //nr pozitiv intre 1 si 5
    private String tip;     //Regular, Business, Executive sau VIP

    public Camera(String id, String denumire, float pret, int pat, String tip) {
        this.id = id;
        this.denumire = denumire;
        this.pret = pret;
        this.pat = pat;
        this.tip = tip;
    }

    public String getId() {
        return id;
    }

    public String getDenumire() {
        return denumire;
    }

    public float getPret() {
        return pret;
    }

    public int getPat() {
        return pat;
    }

    public String getTip() {
        return tip;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "id='" + id + '\'' +
                ", denumire='" + denumire + '\'' +
                ", pret=" + pret +
                ", pat=" + pat +
                ", tip='" + tip + '\'' +
                '}';
    }
}