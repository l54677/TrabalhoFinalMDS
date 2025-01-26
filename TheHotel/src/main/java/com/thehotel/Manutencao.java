package com.thehotel;

import java.time.LocalDate;

public class Manutencao {
    private static int contadorManutencao = 1;
    private int idManutencao;
    private int idQuarto;
    private String tipo;
    private LocalDate data;
    private String statusManutencao;

    public Manutencao(int idQuarto, String tipo, LocalDate data) {
        if (idQuarto <= 0 || tipo == null || tipo.trim().isEmpty() || data == null) {
            throw new IllegalArgumentException("Erro: Dados inválidos para registrar manutenção.");
        }
        this.idManutencao = contadorManutencao++;
        this.idQuarto = idQuarto;
        this.tipo = tipo;
        this.data = data;
        this.statusManutencao = "Pendente";
    }

    public int getIdManutencao() {
        return idManutencao;
    }

    public int getIdQuarto() {
        return idQuarto;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public String getStatusManutencao() {
        return statusManutencao;
    }

    public void completarManutencao() {
        if (!this.statusManutencao.equals("Pendente")) {
            throw new IllegalStateException("Erro: Apenas manutenções pendentes podem ser concluídas.");
        }
        this.statusManutencao = "Concluída";
        System.out.println("Manutenção ID " + idManutencao + " concluída para o quarto " + idQuarto);
    }

    @Override
    public String toString() {
        return "Manutenção{" +
                "ID=" + idManutencao +
                ", Quarto=" + idQuarto +
                ", Tipo='" + tipo + '\'' +
                ", Data=" + data +
                ", Status='" + statusManutencao + '\'' +
                '}';
    }
}
