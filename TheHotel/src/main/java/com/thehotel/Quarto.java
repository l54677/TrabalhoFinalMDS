package com.thehotel;

public class Quarto {
    private int numero;
    private String tipo;
    private boolean ocupado;

    // Construtor
    public Quarto(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.ocupado = false; // Inicialmente, o quarto está desocupado
    }

    // Métodos de acesso (Getters)
    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    // Métodos para alterar o estado do quarto
    public void ocupar() {
        if (!ocupado) {
            this.ocupado = true;
            System.out.println("O quarto " + numero + " foi ocupado.");
        } else {
            System.out.println("Erro: O quarto " + numero + " já está ocupado.");
        }
    }

    public void libertar() {
        if (ocupado) {
            this.ocupado = false;
            System.out.println("O quarto " + numero + " foi libertado.");
        } else {
            System.out.println("Erro: O quarto " + numero + " já está desocupado.");
        }
    }

    // Método para exibir informações do quarto
    @Override
    public String toString() {
        return "Quarto{" +
                "Número=" + numero +
                ", Tipo='" + tipo + '\'' +
                ", Ocupado=" + (ocupado ? "Sim" : "Não") +
                '}';
    }
}

