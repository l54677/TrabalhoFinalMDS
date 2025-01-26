package com.thehotel;

import java.time.LocalDate;
import java.util.List;

public class GestorDeReservas {

    private List<Reserva> reservas;
    private List<Quarto> quartos;
    private List<Hospede> hospedes;

    public GestorDeReservas(List<Reserva> reservas, List<Quarto> quartos, List<Hospede> hospedes) {
        this.reservas = reservas;
        this.quartos = quartos;
        this.hospedes = hospedes;
    }

    // Méodo para realizar a tarefa (verificação da sua role)
    public Reserva realizarReserva(int idHospede, int idQuarto, LocalDate checkin, LocalDate checkout, String tipoUsuario) {
        // Verifica se é funcionário ou gestor
        if (!tipoUsuario.equalsIgnoreCase("funcionario") && !tipoUsuario.equalsIgnoreCase("gestor")) {
            throw new IllegalArgumentException("Apenas funcionários e gestores podem realizar reservas.");
        }

        // Hospede existe?
        Hospede hospede = encontrarHospede(idHospede);
        if (hospede == null) {
            throw new IllegalArgumentException("Hóspede com ID " + idHospede + " não encontrado.");
        }

        // Quarto existe?
        Quarto quarto = encontrarQuarto(idQuarto);
        if (quarto == null) {
            throw new IllegalArgumentException("Quarto com ID " + idQuarto + " não encontrado.");
        }
        if (quarto.isOcupado()) {
            throw new IllegalArgumentException("O quarto " + idQuarto + " já está ocupado.");
        }

        // Criar a nova reserva
        Reserva novaReserva = new Reserva(reservas.size() + 1, quarto, checkin, checkout);
        reservas.add(novaReserva);

        // Atualizar o estado do quarto para ocupado
        quarto.ocupar();

        System.out.println("Reserva #" + novaReserva.getIdReserva() + " realizada com sucesso por um " + tipoUsuario);

        return novaReserva;
    }

    // Método encontrarHospede
    private Hospede encontrarHospede(int idHospede) {
        for (Hospede h : hospedes) {
            if (h.getIdHospede() == idHospede) {
                return h;
            }
        }
        return null;
    }


    // Método para encontrar quarto
    private Quarto encontrarQuarto(int idQuarto) {
        for (Quarto q : quartos) {
            if (q.getNumero() == idQuarto) {
                return q;
            }
        }
        return null;
    }
    // Método para cancelar uma reserva
    public void cancelarReserva(int idReserva, String tipoUtilizador) {
        // verifica a role (funcionario ou gestor)
        if (!tipoUtilizador.equalsIgnoreCase("funcionário") && !tipoUtilizador.equalsIgnoreCase("gestor")) {
            throw new IllegalArgumentException("Apenas funcionários e gestores podem cancelar reservas.");
        }

        // Procura a reserva pelo idReserva
        Reserva reservaParaCancelar = null;
        for (Reserva r : reservas) {
            if (r.getIdReserva() == idReserva) {
                reservaParaCancelar = r;
                break;
            }
        }

        // caso a reserva nao seja encontrada
        if (reservaParaCancelar == null) {
            throw new IllegalArgumentException("Reserva com ID " + idReserva + " não encontrada.");
        }

        // atualiza o estado do quarto (disponivel/indesponivel)
        Quarto quarto = reservaParaCancelar.getQuarto();
        quarto.libertar();

        // Remove a reserva da lista
        reservas.remove(reservaParaCancelar);

        System.out.println("Reserva #" + idReserva + " cancelada com sucesso por um " + tipoUtilizador);
    }
}

