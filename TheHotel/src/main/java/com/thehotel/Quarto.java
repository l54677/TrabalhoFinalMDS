package com.thehotel;

public class Quarto {
    private int numero;
    private String tipo;
    private boolean ocupado;

    public Quarto(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.ocupado = false; // Inicialmente, o quarto está desocupado
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void ocupar() {
        if (this.ocupado) {
            throw new IllegalStateException("O quarto " + this.numero + " já está ocupado.");
        }
        this.ocupado = true;
    }

    public void libertar() {
        if (!this.ocupado) {
            throw new IllegalStateException("O quarto " + this.numero + " já está desocupado.");
        }
        this.ocupado = false;
    }
}
