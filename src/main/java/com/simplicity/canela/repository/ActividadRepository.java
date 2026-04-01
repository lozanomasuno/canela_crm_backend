package com.simplicity.canela.repository;

import com.simplicity.canela.model.Actividad;

import java.util.List;
import java.util.Optional;

public interface ActividadRepository {

    Actividad save(Actividad actividad);

    List<Actividad> findAll();

    Optional<Actividad> findById(String id);

    List<Actividad> findByLeadId(String leadId);

    void delete(String id);
}
