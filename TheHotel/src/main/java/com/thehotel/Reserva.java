package com.thehotel;

import java.time.LocalDate;
import java.util.List;

public class Reserva {
    private int idReserva;
    private Quarto quarto;
    private LocalDate checkin;
    private LocalDate checkout;
    private String status;
    
    public Reserva(int idReserva, Quarto quarto, LocalDate checkin, LocalDate checkout) {
        this.idReserva = idReserva;
        this.quarto = quarto;
        this.checkin = checkin;
        this.checkout = checkout;
        this.status = "Pendente";
    }

    public int getIdReserva() {
        return idReserva;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public String getStatus() {
        return status;
    }

    public static Quarto sugerirQuarto(List<Quarto> quartosDisponiveis) {
        for (Quarto quarto : quartosDisponiveis) {
            if (!quarto.isOcupado()) {
                return quarto;
            }
        }
        return null;
    }

    public void confirmarReserva() {
        if (!quarto.isOcupado()) {
            this.status = "Confirmada";
            quarto.ocupar();
            System.out.println("Reserva #" + idReserva + " confirmada para o quarto " + quarto.getNumero());
        } else {
            System.out.println("Erro: O quarto " + quarto.getNumero() + " já está ocupado.");
        }
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "ID Reserva=" + idReserva +
                ", Quarto=" + quarto.getNumero() +
                ", Check-in=" + checkin +
                ", Check-out=" + checkout +
                ", Status='" + status + '\'' +
                '}';
    }
}
