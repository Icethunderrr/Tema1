package com.ubb.postuniv.service;

import com.ubb.postuniv.domain.Camera;
import com.ubb.postuniv.domain.CameraRaportProfitabilitate;
import com.ubb.postuniv.domain.CameraValidator;
import com.ubb.postuniv.domain.TipCameraCuMediePaturi;
import com.ubb.postuniv.repository.InMemoryCameraRepository;

import java.util.*;

public class CameraService {
    private InMemoryCameraRepository cameraRepository;
        private CameraValidator cameraValidator;

    public CameraService(InMemoryCameraRepository cameraRepository, CameraValidator cameraValidator) {
        this.cameraRepository = cameraRepository;
        this.cameraValidator = cameraValidator;
    }



    public void addCamera(String id, String denumire, float pret,
                         int pat, String tip) throws RuntimeException {
        Camera camera = new Camera(id, denumire, pret, pat, tip);
        this.cameraValidator.validate(camera);
        this.cameraRepository.create(camera);
    }

    public void updateCamera(String id, String denumire, float pret, int pat, String tip) throws RuntimeException {
        Camera camera = new Camera(id, denumire, pret, pat, tip);
        this.cameraValidator.validate(camera);
        this.cameraRepository.update(camera);
    }

    public void deleteCamera(String id) throws RuntimeException {
        this.cameraRepository.delete(id);
    }

    public List<CameraRaportProfitabilitate> getCamereByProfitabilitate() {
        List<CameraRaportProfitabilitate> result = new ArrayList<>();
        for (Camera camera: this.getAll()) {
            result.add(new CameraRaportProfitabilitate(camera));
        }

        result.sort(new Comparator<CameraRaportProfitabilitate>() {
            @Override
            public int compare(CameraRaportProfitabilitate o1, CameraRaportProfitabilitate o2) {
                return Float.compare(o2.getProfitabilitate(), o1.getProfitabilitate());
            }
        });

        return result;
    }

    public List<TipCameraCuMediePaturi> getTipuriCamereCuMediePaturi() {
        Map<String, List<Float>> groupings = new HashMap<>();
        for (Camera camera: this.getAll()) {
            String tip = camera.getTip();
            float pat = camera.getPat();
            if (groupings.containsKey(tip)) {
                groupings.get(tip).add(pat);
            } else {
                List<Float> paturi = new ArrayList<>();
                paturi.add(pat);
                groupings.put(tip, paturi);
            }
        }

        List<TipCameraCuMediePaturi> result = new ArrayList<>();
        for (String tip : groupings.keySet()) {
            float medie = 0;
            for (float pat : groupings.get(tip)) {
                medie += pat;
            }
            medie /= groupings.get(tip).size();

            result.add(new TipCameraCuMediePaturi(tip, medie));
        }

        return result;
    }

    public List<Camera> getAll() {
        return cameraRepository.read();
    }


}