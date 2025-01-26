package com.thehotel;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private int idFuncionario;
    private List<String> manutencoes;

    // Construtor
    public Funcionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
        this.manutencoes = new ArrayList<>();
    }

    // Método para obter o ID do funcionário
    public int getIdFuncionario() {
        return idFuncionario;
    }

    // Método para registrar uma manutenção
    public void realizarManutencao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            System.out.println("Erro: A descrição da manutenção não pode estar vazia.");
        } else {
            manutencoes.add(descricao);
            System.out.println("Manutenção registrada: " + descricao);
        }
    }

    // Método para obter a lista de manutenções realizadas
    public List<String> getManutencoes() {
        return manutencoes;
    }

    // Representação textual do funcionário
    @Override
    public String toString() {
        return "Funcionário{" +
                "ID=" + idFuncionario +
                ", Manutenções=" + manutencoes +
                '}';
    }
}
