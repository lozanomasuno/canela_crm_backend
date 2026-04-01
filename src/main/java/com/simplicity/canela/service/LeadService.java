package com.simplicity.canela.service;

import com.simplicity.canela.dto.CreateLeadRequest;
import com.simplicity.canela.model.EstadoLead;
import com.simplicity.canela.model.Lead;
import com.simplicity.canela.repository.LeadRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class LeadService {

    private final LeadRepository leadRepository;

    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public Lead crearLead(CreateLeadRequest request) {
        Lead lead = new Lead(
                UUID.randomUUID().toString(),
                request.getNombre(),
                request.getTelefono(),
                request.getEmail(),
                EstadoLead.NUEVO,
                request.getVendedorId(),
                LocalDateTime.now()
        );
        return leadRepository.save(lead);
    }

    public List<Lead> listarLeads() {
        return leadRepository.findAll();
    }

    public Lead actualizarEstado(String id, EstadoLead nuevoEstado) {
        Lead lead = leadRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Lead no encontrado: " + id));
        lead.setEstado(nuevoEstado);
        return leadRepository.save(lead);
    }

    public Lead buscarPorId(String id) {
        return leadRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Lead no encontrado: " + id));
    }
}
