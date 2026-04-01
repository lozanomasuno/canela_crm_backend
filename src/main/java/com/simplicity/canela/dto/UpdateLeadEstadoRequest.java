package com.simplicity.canela.dto;

import com.simplicity.canela.model.EstadoLead;
import jakarta.validation.constraints.NotNull;

public class UpdateLeadEstadoRequest {

    @NotNull(message = "El estado es obligatorio")
    private EstadoLead estado;

    public EstadoLead getEstado() { return estado; }
    public void setEstado(EstadoLead estado) { this.estado = estado; }
}
