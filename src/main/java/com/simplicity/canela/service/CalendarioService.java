package com.simplicity.canela.service;

import com.simplicity.canela.model.EventoCalendario;
import com.simplicity.canela.model.Actividad;
import com.simplicity.canela.repository.EventoCalendarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class CalendarioService {

    private final EventoCalendarioRepository eventoRepository;

    public CalendarioService(EventoCalendarioRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public EventoCalendario crearEventoDesdeActividad(Actividad actividad) {
        EventoCalendario evento = new EventoCalendario(
                UUID.randomUUID().toString(),
                buildTitulo(actividad),
                actividad.getFecha(),
                actividad.getFecha().plusHours(1),
                actividad.getId(),
                actividad.getVendedorId()
        );
        return eventoRepository.save(evento);
    }

    public EventoCalendario actualizarEvento(Actividad actividad) {
        EventoCalendario evento = eventoRepository.findByActividadId(actividad.getId())
                .orElseThrow(() -> new NoSuchElementException(
                        "Evento no encontrado para actividad: " + actividad.getId()));
        evento.setTitulo(buildTitulo(actividad));
        evento.setFechaInicio(actividad.getFecha());
        evento.setFechaFin(actividad.getFecha().plusHours(1));
        evento.setVendedorId(actividad.getVendedorId());
        return eventoRepository.save(evento);
    }

    public void eliminarEventoPorActividad(String actividadId) {
        eventoRepository.findByActividadId(actividadId)
                .ifPresent(e -> eventoRepository.delete(e.getId()));
    }

    public List<EventoCalendario> listarTodos() {
        return eventoRepository.findAll();
    }

    public List<EventoCalendario> listarPorVendedor(String vendedorId) {
        return eventoRepository.findByVendedorId(vendedorId);
    }

    private String buildTitulo(Actividad actividad) {
        return actividad.getTipo().name() + ": " + actividad.getDescripcion();
    }
}
