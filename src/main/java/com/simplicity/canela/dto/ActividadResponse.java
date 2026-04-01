package com.simplicity.canela.dto;

import com.simplicity.canela.model.Actividad;
import com.simplicity.canela.model.EstadoActividad;
import com.simplicity.canela.model.TipoActividad;

import java.time.LocalDateTime;

public class ActividadResponse {

    private String id;
    private TipoActividad tipo;
    private String descripcion;
    private LocalDateTime fecha;
    private EstadoActividad estado;
    private String leadId;
    private String vendedorId;

    public static ActividadResponse from(Actividad actividad) {
        ActividadResponse r = new ActividadResponse();
        r.id = actividad.getId();
        r.tipo = actividad.getTipo();
        r.descripcion = actividad.getDescripcion();
        r.fecha = actividad.getFecha();
        r.estado = actividad.getEstado();
        r.leadId = actividad.getLeadId();
        r.vendedorId = actividad.getVendedorId();
        return r;
    }

    public String getId() { return id; }
    public TipoActividad getTipo() { return tipo; }
    public String getDescripcion() { return descripcion; }
    public LocalDateTime getFecha() { return fecha; }
    public EstadoActividad getEstado() { return estado; }
    public String getLeadId() { return leadId; }
    public String getVendedorId() { return vendedorId; }
}
