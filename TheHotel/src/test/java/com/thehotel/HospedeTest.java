package com.thehotel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HospedeTest {

    @Test
    void testCriacaoHospede() {
        Hospede hospede = new Hospede(1, "Tozé marreco", "toze.123@example.com");

        assertEquals(1, hospede.getIdHospede());
        assertEquals("Tozé marreco", hospede.getNome());
        assertEquals("toze.123@example.com", hospede.getEmail());
    }

    @Test
    void testCriacaoHospedeSemEmail() {
        Hospede hospede = new Hospede(2, "Lebron James");

        assertEquals(2, hospede.getIdHospede());
        assertEquals("Lebron James", hospede.getNome());
        assertEquals("", hospede.getEmail()); // vê se o email nao foi inserido
    }

    @Test
    void testToString() {
        Hospede hospede = new Hospede(3, "Carlos Amilcar", "carlos.amilcar@example.com");

        String esperado = "Hóspede{ID=3, Nome='Carlos Amilcar', Email='carlos.amilcar@example.com'}";
        assertEquals(esperado, hospede.toString());
    }
}
