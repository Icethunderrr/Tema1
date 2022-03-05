package com.ubb.postuniv.repository;

import com.ubb.postuniv.domain.Camera;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCameraRepository {
    private Map<String, Camera> storage = new HashMap<>();

    public void create(Camera camera) {
        if (storage.containsKey(camera.getId())) {
           throw new RuntimeException("Exista deja o camera cu id-ul " + camera.getId());
        }

        this.storage.put(camera.getId(), camera);
    }

    public List<Camera> read() {
        return new ArrayList<>(storage.values());
    }

    public void update(Camera camera) {
        if (!storage.containsKey(camera.getId())) {
            throw new RuntimeException("Nu exista nicio camera cu id-ul " + camera.getId());
        }

        this.storage.put(camera.getId(), camera);
    }

    public void delete(String idCamera) {
        if (!storage.containsKey(idCamera)) {
            throw new RuntimeException("Nu exista nicio camera cu id-ul " + idCamera);
        }

        this.storage.remove(idCamera);

    }
}
