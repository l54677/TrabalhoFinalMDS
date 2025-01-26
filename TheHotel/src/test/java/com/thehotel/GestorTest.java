package com.thehotel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorTest {
    private Gestor gestor;
    private List<Quarto> quartos;
    private List<Reserva> reservas;
    private List<Hospede> hospedes;

    @BeforeEach
    void setUp() {
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
        hospedes = new ArrayList<>();

        gestor = new Gestor(1, quartos, reservas, hospedes);
    }

    @Test
    void testGerirQuartosAdicionar() {
        Quarto quarto = new Quarto(101, "Suite");
        gestor.gerirQuartos("adicionar", quarto);
        assertEquals(1, quartos.size());
        assertEquals(quarto, quartos.get(0));
    }

    @Test
    void testGerirQuartosRemover() {
        Quarto quarto = new Quarto(101, "Suite");
        quartos.add(quarto);
        gestor.gerirQuartos("remover", quarto);
        assertEquals(0, quartos.size());
    }

    @Test
    void testRealizarReservaSucesso() {
        Hospede hospede = new Hospede(1, "João Silva", "joao.silva@example.com");
        Quarto quarto = new Quarto(101, "Suite");
        hospedes.add(hospede);
        quartos.add(quarto);

        Reserva reserva = gestor.realizarReserva(1, 101, LocalDate.of(2025, 2, 10), LocalDate.of(2025, 2, 15));

        assertNotNull(reserva);
        assertEquals(1, reservas.size());
        assertEquals("Confirmada", reserva.getStatus());
        assertTrue(quarto.isOcupado());
    }

    @Test
    void testRealizarReservaQuartoOcupado() {
        Hospede hospede = new Hospede(1, "João Silva", "joao.silva@example.com");
        Quarto quarto = new Quarto(101, "Suite");
        hospedes.add(hospede);
        quartos.add(quarto);
        quarto.ocupar();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gestor.realizarReserva(1, 101, LocalDate.of(2025, 2, 10), LocalDate.of(2025, 2, 15));
        });

        assertEquals("Erro: Quarto não disponível.", exception.getMessage());
    }

    @Test
    void testVerificarReservasSemReservas() {
        gestor.verificarReservas();
        assertEquals(0, reservas.size());
    }
}
