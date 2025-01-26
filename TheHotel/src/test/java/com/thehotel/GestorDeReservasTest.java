package com.thehotel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GestorDeReservasTest {

    private GestorDeReservas gestor;
    private List<Reserva> reservas;
    private List<Quarto> quartos;
    private List<Hospede> hospedes;

    @BeforeEach
    void setUp() {
        reservas = new ArrayList<>();
        quartos = new ArrayList<>();
        hospedes = new ArrayList<>();

        // Adiciona alguns quartos e hóspedes para os testes
        quartos.add(new Quarto(101, "simples"));
        quartos.add(new Quarto(102, "duplo"));
        hospedes.add(new Hospede(1, "João Silva", "joao.silva@example.com"));
        hospedes.add(new Hospede(2, "Maria Santos", "maria.santos@example.com"));


        gestor = new GestorDeReservas(reservas, quartos, hospedes);
    }


    @Test
    void realizarReservaComSucesso() {
        LocalDate checkin = LocalDate.of(2025, 1, 26);
        LocalDate checkout = LocalDate.of(2025, 1, 28);

        Reserva reserva = gestor.realizarReserva(1, 101, checkin, checkout, "funcionario");

        assertNotNull(reserva);
        assertEquals(1, reserva.getIdReserva());
        assertEquals(101, reserva.getQuarto().getNumero());
            assertEquals("Confirmada", reserva.getStatus());
        assertTrue(reserva.getQuarto().isOcupado());
    }

    @Test
    void realizarReservaComUsuarioNaoAutorizado() {
        LocalDate checkin = LocalDate.of(2025, 1, 26);
        LocalDate checkout = LocalDate.of(2025, 1, 28);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gestor.realizarReserva(1, 101, checkin, checkout, "cliente");
        });

        assertEquals("Apenas funcionários e gestores podem realizar reservas.", exception.getMessage());
    }

    @Test
    void realizarReservaComHospedeInexistente() {
        LocalDate checkin = LocalDate.of(2025, 1, 26);
        LocalDate checkout = LocalDate.of(2025, 1, 28);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gestor.realizarReserva(99, 101, checkin, checkout, "funcionario");
        });

        assertEquals("Hóspede com ID 99 não encontrado.", exception.getMessage());
    }

    @Test
    void realizarReservaComQuartoInexistente() {
        LocalDate checkin = LocalDate.of(2025, 1, 26);
        LocalDate checkout = LocalDate.of(2025, 1, 28);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gestor.realizarReserva(1, 999, checkin, checkout, "funcionario");
        });

        assertEquals("Quarto com ID 999 não encontrado.", exception.getMessage());
    }

    @Test
    void cancelarReservaComSucesso() {
        LocalDate checkin = LocalDate.of(2025, 1, 26);
        LocalDate checkout = LocalDate.of(2025, 1, 28);

        Reserva reserva = gestor.realizarReserva(1, 101, checkin, checkout, "funcionario");
        gestor.cancelarReserva(reserva.getIdReserva(), "gestor");

        assertFalse(reserva.getQuarto().isOcupado());
        assertFalse(reservas.contains(reserva));
    }

    @Test
    void cancelarReservaComUsuarioNaoAutorizado() {
        LocalDate checkin = LocalDate.of(2025, 1, 26);
        LocalDate checkout = LocalDate.of(2025, 1, 28);

        Reserva reserva = gestor.realizarReserva(1, 101, checkin, checkout, "funcionario");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gestor.cancelarReserva(reserva.getIdReserva(), "cliente");
        });

        assertEquals("Apenas funcionários e gestores podem cancelar reservas.", exception.getMessage());
    }

    @Test
    void cancelarReservaInexistente() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gestor.cancelarReserva(999, "gestor");
        });

        assertEquals("Reserva com ID 999 não encontrada.", exception.getMessage());
    }
}
