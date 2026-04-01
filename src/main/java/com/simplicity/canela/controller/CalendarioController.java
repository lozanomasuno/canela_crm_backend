package com.simplicity.canela.controller;

import com.simplicity.canela.dto.EventoCalendarioResponse;
import com.simplicity.canela.service.CalendarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/calendario")
public class CalendarioController {

    private final CalendarioService calendarioService;

    public CalendarioController(CalendarioService calendarioService) {
        this.calendarioService = calendarioService;
    }

    @GetMapping
    public ResponseEntity<List<EventoCalendarioResponse>> listarTodos() {
        List<EventoCalendarioResponse> eventos = calendarioService.listarTodos().stream()
                .map(EventoCalendarioResponse::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/vendedor/{vendedorId}")
    public ResponseEntity<List<EventoCalendarioResponse>> listarPorVendedor(
            @PathVariable String vendedorId) {
        List<EventoCalendarioResponse> eventos = calendarioService
                .listarPorVendedor(vendedorId).stream()
                .map(EventoCalendarioResponse::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(eventos);
    }
}
