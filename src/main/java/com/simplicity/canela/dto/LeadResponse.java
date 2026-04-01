package com.simplicity.canela.dto;

import com.simplicity.canela.model.EstadoLead;
import com.simplicity.canela.model.Lead;

import java.time.LocalDateTime;

public class LeadResponse {

    private String id;
    private String nombre;
    private String telefono;
    private String email;
    private EstadoLead estado;
    private String vendedorId;
    private LocalDateTime createdAt;

    public static LeadResponse from(Lead lead) {
        LeadResponse r = new LeadResponse();
        r.id = lead.getId();
        r.nombre = lead.getNombre();
        r.telefono = lead.getTelefono();
        r.email = lead.getEmail();
        r.estado = lead.getEstado();
        r.vendedorId = lead.getVendedorId();
        r.createdAt = lead.getCreatedAt();
        return r;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public EstadoLead getEstado() { return estado; }
    public String getVendedorId() { return vendedorId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
