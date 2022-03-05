package com.ubb.postuniv.domain;

public class TipCameraCuMediePaturi {
    public String tipCamera;
    public float mediePaturi;

    public TipCameraCuMediePaturi(String tipCamera, float mediePaturi) {
        this.tipCamera = tipCamera;
        this.mediePaturi = mediePaturi;
    }

    @Override
    public String toString() {
        return "TipCameraCuMediePaturi{" +
                "tipCamera='" + tipCamera + '\'' +
                ", mediePaturi=" + mediePaturi +
                '}';
    }
}
