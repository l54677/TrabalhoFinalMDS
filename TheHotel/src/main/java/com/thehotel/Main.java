package com.thehotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Quarto> listaQuartos = new ArrayList<>();
        List<Reserva> listaReservas = new ArrayList<>();
        List<Hospede> listaHospedes = new ArrayList<>();
        List<Manutencao> listaManutencoes = new ArrayList<>();

        Gestor gestor = new Gestor(1, listaQuartos, listaReservas, listaHospedes);
        Funcionario funcionario = new Funcionario(2);

        while (true) {
            System.out.println("--- Sistema de Gestão Hoteleira ---");
            System.out.println("1. Adicionar Quarto");
            System.out.println("2. Criar Hóspede");
            System.out.println("3. Fazer Reserva");
            System.out.println("4. Ver Reservas");
            System.out.println("5. Registrar Manutenção");
            System.out.println("6. Completar Manutenção");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Número do quarto: ");
                    int numQuarto = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tipo do quarto: ");
                    String tipoQuarto = scanner.nextLine();
                    listaQuartos.add(new Quarto(numQuarto, tipoQuarto));
                    System.out.println("Quarto adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("ID do hóspede: ");
                    int idHospede = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do hóspede: ");
                    String nomeHospede = scanner.nextLine();
                    System.out.print("Email do hóspede: ");
                    String emailHospede = scanner.nextLine();
                    listaHospedes.add(new Hospede(idHospede, nomeHospede, emailHospede));
                    System.out.println("Hóspede criado com sucesso!");
                    break;
                case 3:
                    System.out.print("ID do hóspede: ");
                    int idHosp = scanner.nextInt();
                    System.out.print("Número do quarto: ");
                    int idQuarto = scanner.nextInt();
                    System.out.print("Data de check-in (AAAA-MM-DD): ");
                    String checkinStr = scanner.next();
                    System.out.print("Data de check-out (AAAA-MM-DD): ");
                    String checkoutStr = scanner.next();
                    LocalDate checkin = LocalDate.parse(checkinStr);
                    LocalDate checkout = LocalDate.parse(checkoutStr);
                    gestor.realizarReserva(idHosp, idQuarto, checkin, checkout);
                    break;
                case 4:
                    gestor.verificarReservas();
                    break;
                case 5:
                    System.out.print("ID do quarto: ");
                    int idQuartoManut = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tipo de manutenção: ");
                    String tipoManut = scanner.nextLine();
                    System.out.print("Data da manutenção (AAAA-MM-DD): ");
                    String dataManutStr = scanner.next();
                    LocalDate dataManut = LocalDate.parse(dataManutStr);
                    Manutencao manutencao = new Manutencao(idQuartoManut, tipoManut, dataManut);
                    listaManutencoes.add(manutencao);
                    System.out.println("Manutenção registrada com sucesso!");
                    break;
                case 6:
                    System.out.print("ID da manutenção: ");
                    int idManut = scanner.nextInt();
                    for (Manutencao m : listaManutencoes) {
                        if (m.getIdManutencao() == idManut) {
                            m.completarManutencao();
                            System.out.println("Manutenção concluída!");
                            break;
                        }
                    }
                    break;
                case 7:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
