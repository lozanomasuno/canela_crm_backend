package com.simplicity.canela.dto;

import com.simplicity.canela.model.EventoCalendario;

import java.time.LocalDateTime;

public class EventoCalendarioResponse {

    private String id;
    private String titulo;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String actividadId;
    private String vendedorId;

    public static EventoCalendarioResponse from(EventoCalendario evento) {
        EventoCalendarioResponse r = new EventoCalendarioResponse();
        r.id = evento.getId();
        r.titulo = evento.getTitulo();
        r.fechaInicio = evento.getFechaInicio();
        r.fechaFin = evento.getFechaFin();
        r.actividadId = evento.getActividadId();
        r.vendedorId = evento.getVendedorId();
        return r;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public LocalDateTime getFechaFin() { return fechaFin; }
    public String getActividadId() { return actividadId; }
    public String getVendedorId() { return vendedorId; }
}
