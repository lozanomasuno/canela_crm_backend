package com.simplicity.canela.repository;

import com.simplicity.canela.model.EventoCalendario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class InMemoryEventoCalendarioRepository implements EventoCalendarioRepository {

    private final Map<String, EventoCalendario> store = new ConcurrentHashMap<>();

    @Override
    public EventoCalendario save(EventoCalendario evento) {
        store.put(evento.getId(), evento);
        return evento;
    }

    @Override
    public List<EventoCalendario> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<EventoCalendario> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<EventoCalendario> findByActividadId(String actividadId) {
        return store.values().stream()
                .filter(e -> actividadId.equals(e.getActividadId()))
                .findFirst();
    }

    @Override
    public List<EventoCalendario> findByVendedorId(String vendedorId) {
        return store.values().stream()
                .filter(e -> vendedorId.equals(e.getVendedorId()))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        store.remove(id);
    }
}
