package com.thehotel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class ManutencaoTest {

    @Test
    void testCriacaoManutencaoValida() {
        Manutencao manutencao = new Manutencao(101, "Elétrica", LocalDate.of(2025, 2, 10));

        assertEquals(101, manutencao.getIdQuarto());
        assertEquals("Elétrica", manutencao.getTipo());
        assertEquals(LocalDate.of(2025, 2, 10), manutencao.getData());
        assertEquals("Pendente", manutencao.getStatusManutencao());
    }

    @Test
    void testCriacaoManutencaoInvalida() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Manutencao(0, "", null);
        });
        assertEquals("Erro: Dados inválidos para registrar manutenção.", exception.getMessage());
    }

    @Test
    void testCompletarManutencao() {
        Manutencao manutencao = new Manutencao(102, "Hidráulica", LocalDate.of(2025, 3, 5));
        manutencao.completarManutencao();

        assertEquals("Concluída", manutencao.getStatusManutencao());
    }

    @Test
    void testCompletarManutencaoJaConcluida() {
        Manutencao manutencao = new Manutencao(103, "Pintura", LocalDate.of(2025, 4, 15));
        manutencao.completarManutencao();

        Exception exception = assertThrows(IllegalStateException.class, manutencao::completarManutencao);
        assertEquals("Erro: Apenas manutenções pendentes podem ser concluídas.", exception.getMessage());
    }

    @Test
    void testToString() {
        Manutencao manutencao = new Manutencao(104, "Ar Condicionado", LocalDate.of(2025, 5, 20));
        String esperado = "Manutenção{ID=1, Quarto=104, Tipo='Ar Condicionado', Data=2025-05-20, Status='Pendente'}";
        assertTrue(manutencao.toString().contains("Quarto=104"));
        assertTrue(manutencao.toString().contains("Tipo='Ar Condicionado'"));
        assertTrue(manutencao.toString().contains("Status='Pendente'"));
    }
}
