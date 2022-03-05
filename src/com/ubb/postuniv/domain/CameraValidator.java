package com.ubb.postuniv.domain;

public class CameraValidator {

    public void validate(Camera camera) {
        String errors = "";
        if (camera.getDenumire().isEmpty()) {
            errors += "Denumirea camerei nu poate fi goala!\n";
        }
        if (camera.getPat() < 1 || camera.getPat() >5) {
            errors += "Numarul de paturi trebuie sa fie intre 1 si 5!\n";
        }
        if (!camera.getTip().equals("Regular") &&
                !camera.getTip().equals("Business") &&
                !camera.getTip().equals("VIP") &&
                !camera.getTip().equals("Executive")) {
            errors += "Tipul trebuie sa fie unul dintre Regular, Business, Vip sau Executive!\n";
        }

        if (!errors.isEmpty()) {
            throw new RuntimeException(errors);
        }
    }
}