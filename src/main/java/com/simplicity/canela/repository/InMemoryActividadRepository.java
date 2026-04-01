package com.simplicity.canela.repository;

import com.simplicity.canela.model.Actividad;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class InMemoryActividadRepository implements ActividadRepository {

    private final Map<String, Actividad> store = new ConcurrentHashMap<>();

    @Override
    public Actividad save(Actividad actividad) {
        store.put(actividad.getId(), actividad);
        return actividad;
    }

    @Override
    public List<Actividad> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Actividad> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Actividad> findByLeadId(String leadId) {
        return store.values().stream()
                .filter(a -> leadId.equals(a.getLeadId()))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        store.remove(id);
    }
}
