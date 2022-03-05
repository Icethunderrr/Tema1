package com.ubb.postuniv.domain;

public class CameraRaportProfitabilitate {
    private Camera camera;
    private float profitabilitate;

    public CameraRaportProfitabilitate(Camera camera) {
        this.camera = camera;
        this.profitabilitate = camera.getPret()/ camera.getPat();
    }

    public Camera getCamera() {
        return camera;
    }

    public float getProfitabilitate() {
        return profitabilitate;
    }

    @Override
    public String toString() {
        return "CameraRaportProfitabilitate{" +
                "camera=" + camera +
                ", profitabilitate=" + profitabilitate +
                '}';
    }
}