package com.simplicity.canela.controller;

import com.simplicity.canela.dto.ActividadResponse;
import com.simplicity.canela.dto.CreateActividadRequest;
import com.simplicity.canela.service.ActividadService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/actividades")
public class ActividadController {

    private final ActividadService actividadService;

    public ActividadController(ActividadService actividadService) {
        this.actividadService = actividadService;
    }

    @GetMapping("/lead/{leadId}")
    public ResponseEntity<List<ActividadResponse>> listarPorLead(@PathVariable String leadId) {
        List<ActividadResponse> actividades = actividadService.listarPorLead(leadId).stream()
                .map(ActividadResponse::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(actividades);
    }

    @PostMapping
    public ResponseEntity<ActividadResponse> crear(
            @Valid @RequestBody CreateActividadRequest request) {
        ActividadResponse response = ActividadResponse.from(
                actividadService.crearActividad(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}/completar")
    public ResponseEntity<ActividadResponse> completar(@PathVariable String id) {
        ActividadResponse response = ActividadResponse.from(
                actividadService.completarActividad(id));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        actividadService.eliminarActividad(id);
        return ResponseEntity.noContent().build();
    }
}
