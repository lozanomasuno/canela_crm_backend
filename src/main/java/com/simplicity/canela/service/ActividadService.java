package com.simplicity.canela.service;

import com.simplicity.canela.dto.CreateActividadRequest;
import com.simplicity.canela.model.Actividad;
import com.simplicity.canela.model.EstadoActividad;
import com.simplicity.canela.repository.ActividadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ActividadService {

    private final ActividadRepository actividadRepository;
    private final CalendarioService calendarioService;

    public ActividadService(ActividadRepository actividadRepository,
                            CalendarioService calendarioService) {
        this.actividadRepository = actividadRepository;
        this.calendarioService = calendarioService;
    }

    public Actividad crearActividad(CreateActividadRequest request) {
        Actividad actividad = new Actividad(
                UUID.randomUUID().toString(),
                request.getTipo(),
                request.getDescripcion(),
                request.getFecha(),
                EstadoActividad.PENDIENTE,
                request.getLeadId(),
                request.getVendedorId()
        );
        actividadRepository.save(actividad);
        // Sincronización: generar evento automáticamente al crear actividad con fecha
        calendarioService.crearEventoDesdeActividad(actividad);
        return actividad;
    }

    public Actividad completarActividad(String id) {
        Actividad actividad = actividadRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Actividad no encontrada: " + id));
        actividad.setEstado(EstadoActividad.COMPLETADO);
        actividadRepository.save(actividad);
        // Sincronización: reflejar cambio en el evento
        calendarioService.actualizarEvento(actividad);
        return actividad;
    }

    public List<Actividad> listarPorLead(String leadId) {
        return actividadRepository.findByLeadId(leadId);
    }

    public List<Actividad> listarTodas() {
        return actividadRepository.findAll();
    }

    public void eliminarActividad(String id) {
        actividadRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Actividad no encontrada: " + id));
        // Sincronización: eliminar evento asociado
        calendarioService.eliminarEventoPorActividad(id);
        actividadRepository.delete(id);
    }
}
