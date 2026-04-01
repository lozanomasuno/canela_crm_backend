package com.simplicity.canela.model;

import java.time.LocalDateTime;

public class Actividad {

    private String id;
    private TipoActividad tipo;
    private String descripcion;
    private LocalDateTime fecha;
    private EstadoActividad estado;
    private String leadId;
    private String vendedorId;

    public Actividad() {}

    public Actividad(String id, TipoActividad tipo, String descripcion,
                     LocalDateTime fecha, EstadoActividad estado,
                     String leadId, String vendedorId) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
        this.leadId = leadId;
        this.vendedorId = vendedorId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public TipoActividad getTipo() { return tipo; }
    public void setTipo(TipoActividad tipo) { this.tipo = tipo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public EstadoActividad getEstado() { return estado; }
    public void setEstado(EstadoActividad estado) { this.estado = estado; }

    public String getLeadId() { return leadId; }
    public void setLeadId(String leadId) { this.leadId = leadId; }

    public String getVendedorId() { return vendedorId; }
    public void setVendedorId(String vendedorId) { this.vendedorId = vendedorId; }
}
