package com.simplicity.canela.controller;

import com.simplicity.canela.dto.CreateLeadRequest;
import com.simplicity.canela.dto.LeadResponse;
import com.simplicity.canela.dto.UpdateLeadEstadoRequest;
import com.simplicity.canela.service.LeadService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    private final LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @GetMapping
    public ResponseEntity<List<LeadResponse>> listar() {
        List<LeadResponse> leads = leadService.listarLeads().stream()
                .map(LeadResponse::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(leads);
    }

    @PostMapping
    public ResponseEntity<LeadResponse> crear(@Valid @RequestBody CreateLeadRequest request) {
        LeadResponse response = LeadResponse.from(leadService.crearLead(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeadResponse> actualizarEstado(
            @PathVariable String id,
            @Valid @RequestBody UpdateLeadEstadoRequest request) {
        LeadResponse response = LeadResponse.from(
                leadService.actualizarEstado(id, request.getEstado()));
        return ResponseEntity.ok(response);
    }
}
