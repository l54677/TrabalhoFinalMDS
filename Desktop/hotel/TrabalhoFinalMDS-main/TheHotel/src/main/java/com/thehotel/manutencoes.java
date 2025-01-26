package com.thehotel;

import java.time.LocalDate;

public class Manutencao {
    private int idManutencao;
    private int idQuarto;
    private String tipo;
    private String descricao;
    private LocalDate data;
    private boolean concluida;

    // Construtor
    public Manutencao(int idManutencao, int idQuarto, String tipo, String descricao, LocalDate data) {
        this.idManutencao = idManutencao;
        this.idQuarto = idQuarto;
        this.tipo = tipo;
        this.descricao = descricao;
        this.data = data;
        this.concluida = false;


    public int getIdManutencao() {
        return idManutencao;
    }

    public int getIdQuarto() {
        return idQuarto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void concluir() {
        this.concluida = true;
        System.out.println("Manutenção concluída para o quarto " + idQuarto + ".");
    }

    @Override
    public String toString() {
        return "Manutencao{" +
                "ID Manutencao=" + idManutencao +
                ", ID Quarto=" + idQuarto +
                ", Tipo='" + tipo + '\'' +
                ", Descricao='" + descricao + '\'' +
                ", Data=" + data +
                ", Concluida=" + concluida +
                '}';
    }
}
