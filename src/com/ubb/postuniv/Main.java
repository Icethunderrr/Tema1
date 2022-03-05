package com.ubb.postuniv;

import com.ubb.postuniv.domain.CameraValidator;
import com.ubb.postuniv.repository.InMemoryCameraRepository;
import com.ubb.postuniv.service.CameraService;
import com.ubb.postuniv.userInterface.Console;

public class Main {

    public static void main(String[] args) {
        CameraValidator cameraValidator = new CameraValidator();
        InMemoryCameraRepository cameraRepository = new InMemoryCameraRepository();
        CameraService cameraService = new CameraService(cameraRepository, cameraValidator);

        cameraService.addCamera("1", "camera1", 100, 2, "Regular");
        cameraService.addCamera("2", "camera2", 200, 3, "Executive");
        cameraService.addCamera("3", "camera3", 300, 4, "VIP");

        Console console = new Console(cameraService);

        console.runUi();
    }
}