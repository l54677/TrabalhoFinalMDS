package com.thehotel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaTest {

    private Quarto quarto1;
    private Quarto quarto2;
    private Reserva reserva;

    @BeforeEach
    void setUp() {
        quarto1 = new Quarto(101, "Duplo");
        quarto2 = new Quarto(102, "Suite");
        reserva = new Reserva(1, quarto1, LocalDate.of(2025, 1, 26), LocalDate.of(2025, 1, 30));
    }

    @Test
    void testCriacaoReserva() {
        assertEquals(1, reserva.getIdReserva());
        assertEquals(quarto1, reserva.getQuarto());
        assertEquals(LocalDate.of(2025, 1, 26), reserva.getCheckin());
        assertEquals(LocalDate.of(2025, 1, 30), reserva.getCheckout());
        assertEquals("Pendente", reserva.getStatus());
    }

    @Test
    void testConfirmarReserva() {
        reserva.confirmarReserva();
        assertEquals("Confirmada", reserva.getStatus());
        assertTrue(quarto1.isOcupado());
    }

    @Test
    void testConfirmarReservaComQuartoOcupado() {
        quarto1.ocupar();
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            reserva.confirmarReserva();
        });
        assertEquals("Erro: O quarto 101 já está ocupado.", exception.getMessage());
    }

    @Test
    void testSugerirQuarto() {
        List<Quarto> quartosDisponiveis = Arrays.asList(quarto1, quarto2);
        Quarto sugerido = Reserva.sugerirQuarto(quartosDisponiveis);
        assertNotNull(sugerido);
        assertEquals(quarto1, sugerido);
    }

    @Test
    void testSugerirQuartoTodosOcupados() {
        quarto1.ocupar();
        quarto2.ocupar();
        List<Quarto> quartosDisponiveis = Arrays.asList(quarto1, quarto2);
        Quarto sugerido = Reserva.sugerirQuarto(quartosDisponiveis);
        assertNull(sugerido);
    }
}
