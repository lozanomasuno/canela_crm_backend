package com.simplicity.canela.config;

import com.simplicity.canela.model.*;
import com.simplicity.canela.repository.ActividadRepository;
import com.simplicity.canela.repository.EventoCalendarioRepository;
import com.simplicity.canela.repository.LeadRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class DataInitializer implements ApplicationRunner {

    private final LeadRepository leadRepository;
    private final ActividadRepository actividadRepository;
    private final EventoCalendarioRepository eventoRepository;

    public DataInitializer(LeadRepository leadRepository,
                           ActividadRepository actividadRepository,
                           EventoCalendarioRepository eventoRepository) {
        this.leadRepository = leadRepository;
        this.actividadRepository = actividadRepository;
        this.eventoRepository = eventoRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        // ─── Vendedores simulados
        String vendedor1 = "vendedor-001";
        String vendedor2 = "vendedor-002";

        // ─── Leads
        Lead lead1 = new Lead(UUID.randomUUID().toString(),
                "Carlos Ramírez", "+52 55 1234 5678", "carlos@empresa.com",
                EstadoLead.NUEVO, vendedor1, LocalDateTime.now().minusDays(5));

        Lead lead2 = new Lead(UUID.randomUUID().toString(),
                "Ana Torres", "+52 55 8765 4321", "ana@corporativo.mx",
                EstadoLead.CONTACTADO, vendedor1, LocalDateTime.now().minusDays(3));

        Lead lead3 = new Lead(UUID.randomUUID().toString(),
                "Roberto Méndez", "+52 33 4567 8910", "roberto@negocio.com",
                EstadoLead.CALIFICADO, vendedor2, LocalDateTime.now().minusDays(7));

        Lead lead4 = new Lead(UUID.randomUUID().toString(),
                "Sofía Herrera", "+52 81 2345 6789", "sofia@startup.io",
                EstadoLead.NUEVO, vendedor2, LocalDateTime.now().minusDays(1));

        leadRepository.save(lead1);
        leadRepository.save(lead2);
        leadRepository.save(lead3);
        leadRepository.save(lead4);

        // ─── Actividades
        LocalDateTime manana = LocalDateTime.now().plusDays(1).withHour(10).withMinute(0);
        LocalDateTime pasadoManana = LocalDateTime.now().plusDays(2).withHour(15).withMinute(0);
        LocalDateTime enTresDias = LocalDateTime.now().plusDays(3).withHour(9).withMinute(30);

        Actividad act1 = new Actividad(UUID.randomUUID().toString(),
                TipoActividad.LLAMADA, "Primer contacto para presentar propuesta",
                manana, EstadoActividad.PENDIENTE, lead1.getId(), vendedor1);

        Actividad act2 = new Actividad(UUID.randomUUID().toString(),
                TipoActividad.SEGUIMIENTO, "Enviar cotización por correo y hacer seguimiento",
                pasadoManana, EstadoActividad.PENDIENTE, lead2.getId(), vendedor1);

        Actividad act3 = new Actividad(UUID.randomUUID().toString(),
                TipoActividad.NOTA, "Registrar requerimientos técnicos del cliente",
                LocalDateTime.now().minusHours(2), EstadoActividad.COMPLETADO,
                lead3.getId(), vendedor2);

        Actividad act4 = new Actividad(UUID.randomUUID().toString(),
                TipoActividad.MENSAJE, "Enviar WhatsApp con brochure del producto",
                enTresDias, EstadoActividad.PENDIENTE, lead4.getId(), vendedor2);

        actividadRepository.save(act1);
        actividadRepository.save(act2);
        actividadRepository.save(act3);
        actividadRepository.save(act4);

        // ─── Eventos de calendario (derivados de actividades con fecha futura)
        eventoRepository.save(new EventoCalendario(
                UUID.randomUUID().toString(),
                "LLAMADA: " + act1.getDescripcion(),
                act1.getFecha(), act1.getFecha().plusHours(1),
                act1.getId(), vendedor1));

        eventoRepository.save(new EventoCalendario(
                UUID.randomUUID().toString(),
                "SEGUIMIENTO: " + act2.getDescripcion(),
                act2.getFecha(), act2.getFecha().plusHours(1),
                act2.getId(), vendedor1));

        eventoRepository.save(new EventoCalendario(
                UUID.randomUUID().toString(),
                "MENSAJE: " + act4.getDescripcion(),
                act4.getFecha(), act4.getFecha().plusHours(1),
                act4.getId(), vendedor2));
    }
}
