package com.ubb.postuniv.userInterface;

import com.ubb.postuniv.domain.Camera;
import com.ubb.postuniv.domain.CameraRaportProfitabilitate;
import com.ubb.postuniv.domain.TipCameraCuMediePaturi;
import com.ubb.postuniv.service.CameraService;

import java.util.Scanner;

public class Console {
    private CameraService cameraService;
    Scanner scanner = new Scanner(System.in);

    public Console(CameraService cameraService) {
        this.cameraService = cameraService;
    }

    public void runUi() {
        while (true) {
            this.showMenu();
            String opt = this.scanner.nextLine();
            switch (opt) {
                case "1":
                    this.handleAddCamera();
                    break;
                case "2":
                    this.handleUpdateCamera();
                    break;
                case "3":
                    this.handleDeleteCamera();
                    break;
                case "4":
                    this.handleShowAllCamere();
                    break;
                case "5":
                    this.handleShowCamereByProfitabilitate();
                    break;    
                case "6":
                    this.handleShowCamereCuMediePaturi();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Optiune invalida!");
            }
        }
    }

    private void handleShowCamereCuMediePaturi() {
        for (TipCameraCuMediePaturi camera: cameraService.getTipuriCamereCuMediePaturi()) {
            System.out.println(camera.toString());

        }
    }

    private void handleDeleteCamera() {
        try {
            System.out.println("Dati id-ul camerei (unic):");
            String id = this.scanner.nextLine();
            this.cameraService.deleteCamera(id);
        } catch (RuntimeException rex) {
            System.out.println(rex.getMessage());
        }
    }

    private void handleShowCamereByProfitabilitate() {
        for (CameraRaportProfitabilitate cameraRaport : this.cameraService.getCamereByProfitabilitate()) {
            System.out.println(cameraRaport);
        }
    }

    private void handleShowAllCamere() {
        for (Camera camera : this.cameraService.getAll()) {
            System.out.println(camera);
        }
    }

    private void handleAddCamera() {
        try {
            System.out.println("Dati id-ul camerei (unic):");
            String id = this.scanner.nextLine();

            System.out.println("Dati denumirea camerei (nenula):");
            String denumire = this.scanner.nextLine();

            System.out.println("Dati pretul camerei:");
            float pret = this.scanner.nextFloat();

            System.out.println("Dati numarul de paturi (intre 1 si 5):");
            int pat = this.scanner.nextInt();

            this.scanner.nextLine();
            System.out.println("Dati tipul camerei (dintre Regular, Business, Executive sau VIP):");
            String tip = this.scanner.nextLine();

            this.cameraService.addCamera(id, denumire, pret, pat, tip);
        } catch (RuntimeException rex) {
            System.out.println(rex.getMessage());
        }
    }

    private void handleUpdateCamera() {
        try {
            System.out.println("Dati id-ul camerei (unic):");
            String id = this.scanner.nextLine();

            System.out.println("Dati denumirea camerei (nenula):");
            String denumire = this.scanner.nextLine();

            System.out.println("Dati pretul camerei:");
            float pret = this.scanner.nextFloat();

            System.out.println("Dati numarul de paturi (intre 1 si 5):");
            int pat = this.scanner.nextInt();

            this.scanner.nextLine();
            System.out.println("Dati tipul camerei (dintre Regular, Business, Executive sau VIP):");
            String tip = this.scanner.nextLine();

            this.cameraService.updateCamera(id, denumire, pret, pat, tip);
        } catch (RuntimeException rex) {
            System.out.println(rex.getMessage());
        }
    }

    private void showMenu() {
        System.out.println("1. Adauga camera");
        System.out.println("2. Update camera");
        System.out.println("3. Delete camera");
        System.out.println("4. Afisare camere");
        System.out.println("5. Raport camere ordonate descrescator dupa raportul pret / pat");
        System.out.println("6. Raport tip camere cu medie paturi");
        System.out.println("x. Iesire");


    }
}