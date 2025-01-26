package com.thehotel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuartoTest {

    @Test
    void testCriacaoQuarto() {
        Quarto quarto = new Quarto(101, "Duplo");
        assertEquals(101, quarto.getNumero());
        assertEquals("Duplo", quarto.getTipo());
        assertFalse(quarto.isOcupado()); // O quarto deve começar desocupado
    }

    @Test
    void testOcuparQuarto() {
        Quarto quarto = new Quarto(102, "Suite");
        assertFalse(quarto.isOcupado()); // Antes de ocupar

        quarto.ocupar();
        assertTrue(quarto.isOcupado()); // Depois de ocupar
    }

    @Test
    void testOcuparQuartoJaOcupado() {
        Quarto quarto = new Quarto(102, "Suite");
        quarto.ocupar();
        IllegalStateException exception = assertThrows(IllegalStateException.class, quarto::ocupar);
        assertEquals("O quarto 102 já está ocupado.", exception.getMessage());
    }

    @Test
    void testLibertarQuarto() {
        Quarto quarto = new Quarto(103, "Simples");
        quarto.ocupar(); // Primeiro ocupa
        assertTrue(quarto.isOcupado());

        quarto.libertar();
        assertFalse(quarto.isOcupado()); // Depois de libertar
    }

    @Test
    void testLibertarQuartoJaDesocupado() {
        Quarto quarto = new Quarto(103, "Simples");
        IllegalStateException exception = assertThrows(IllegalStateException.class, quarto::libertar);
        assertEquals("O quarto 103 já está desocupado.", exception.getMessage());
    }
}
