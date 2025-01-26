package com.thehotel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class FuncionarioTest {

    @Test
    void testCriacaoFuncionario() {
        Funcionario funcionario = new Funcionario(1);
        assertEquals(1, funcionario.getIdFuncionario());
        assertTrue(funcionario.getManutencoes().isEmpty());
    }

    @Test
    void testRegistrarManutencao() {
        Funcionario funcionario = new Funcionario(2);
        funcionario.realizarManutencao("Troca de lâmpada no quarto 101");
        List<String> manutencoes = funcionario.getManutencoes();

        assertEquals(1, manutencoes.size());
        assertEquals("Troca de lâmpada no quarto 101", manutencoes.get(0));
    }

    @Test
    void testRegistrarManutencaoInvalida() {
        Funcionario funcionario = new Funcionario(3);
        funcionario.realizarManutencao(""); // Entrada inválida
        funcionario.realizarManutencao(null); // Entrada inválida

        assertTrue(funcionario.getManutencoes().isEmpty()); // Nenhuma manutenção deve ser registada
    }

    @Test
    void testToString() {
        Funcionario funcionario = new Funcionario(4);
        funcionario.realizarManutencao("Reparo na fechadura do quarto 203");

        String esperado = "Funcionário{ID=4, Manutenções=[Reparo na fechadura do quarto 203]}";
        assertEquals(esperado, funcionario.toString());
    }
}