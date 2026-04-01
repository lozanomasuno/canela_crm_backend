package com.simplicity.canela.model;

import java.time.LocalDateTime;

public class Lead {

    private String id;
    private String nombre;
    private String telefono;
    private String email;
    private EstadoLead estado;
    private String vendedorId;
    private LocalDateTime createdAt;

    public Lead() {}

    public Lead(String id, String nombre, String telefono, String email,
                EstadoLead estado, String vendedorId, LocalDateTime createdAt) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.estado = estado;
        this.vendedorId = vendedorId;
        this.createdAt = createdAt;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public EstadoLead getEstado() { return estado; }
    public void setEstado(EstadoLead estado) { this.estado = estado; }

    public String getVendedorId() { return vendedorId; }
    public void setVendedorId(String vendedorId) { this.vendedorId = vendedorId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
