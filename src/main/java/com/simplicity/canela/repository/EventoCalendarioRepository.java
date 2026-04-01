package com.simplicity.canela.repository;

import com.simplicity.canela.model.EventoCalendario;

import java.util.List;
import java.util.Optional;

public interface EventoCalendarioRepository {

    EventoCalendario save(EventoCalendario evento);

    List<EventoCalendario> findAll();

    Optional<EventoCalendario> findById(String id);

    Optional<EventoCalendario> findByActividadId(String actividadId);

    List<EventoCalendario> findByVendedorId(String vendedorId);

    void delete(String id);
}
