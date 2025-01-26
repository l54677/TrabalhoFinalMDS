package com.thehotel;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Gestor {
    private int idGestor;
    private List<Quarto> quartos;
    private List<Reserva> reservas;
    private List<Hospede> hospedes;

    public Gestor(int idGestor, List<Quarto> quartos, List<Reserva> reservas, List<Hospede> hospedes) {
        this.idGestor = idGestor;
        this.quartos = quartos;
        this.reservas = reservas;
        this.hospedes = hospedes;
    }

    public int getIdGestor() {
        return idGestor;
    }

    public void gerirQuartos(String operacao, Quarto quarto) {
        switch (operacao.toLowerCase()) {
            case "adicionar":
                quartos.add(quarto);
                System.out.println("Quarto adicionado com sucesso.");
                break;
            case "editar":
                for (Quarto q : quartos) {
                    if (q.getNumero() == quarto.getNumero()) {
                        q = quarto;
                        System.out.println("Quarto atualizado com sucesso.");
                        return;
                    }
                }
                System.out.println("Erro: Quarto não encontrado.");
                break;
            case "remover":
                if (quartos.remove(quarto)) {
                    System.out.println("Quarto removido com sucesso.");
                } else {
                    System.out.println("Erro: Quarto não encontrado.");
                }
                break;
            default:
                System.out.println("Erro: Operação inválida. Use 'adicionar', 'editar' ou 'remover'.");
        }
    }

    public Reserva realizarReserva(int idHospede, int idQuarto, LocalDate checkin, LocalDate checkout) {
        Hospede hospede = encontrarHospede(idHospede);
        if (hospede == null) {
            throw new IllegalArgumentException("Erro: Hóspede não encontrado.");
        }

        Quarto quarto = encontrarQuarto(idQuarto);
        if (quarto == null || quarto.isOcupado()) {
            throw new IllegalArgumentException("Erro: Quarto não disponível.");
        }

        Reserva novaReserva = new Reserva(reservas.size() + 1, quarto, checkin, checkout);
        reservas.add(novaReserva);
        novaReserva.confirmarReserva();

        System.out.println("Reserva realizada com sucesso.");
        return novaReserva;
    }

    public void verificarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Não existem reservas registadas.");
        } else {
            for (Reserva r : reservas) {
                System.out.println(r);
            }
        }
    }

    private Hospede encontrarHospede(int idHospede) {
        for (Hospede h : hospedes) {
            if (h.getIdHospede() == idHospede) {
                return h;
            }
        }
        return null;
    }

    private Quarto encontrarQuarto(int idQuarto) {
        for (Quarto q : quartos) {
            if (q.getNumero() == idQuarto) {
                return q;
            }
        }
        return null;
    }
}
