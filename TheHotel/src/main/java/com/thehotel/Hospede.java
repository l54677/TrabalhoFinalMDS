package com.thehotel;

public class Hospede {
    private int idHospede;
    private String nome;
    private String email;

    // Construtor existente
    public Hospede(int idHospede, String nome, String email) {
        this.idHospede = idHospede;
        this.nome = nome;
        this.email = email;
    }

    // Novo construtor que aceita apenas idHospede e nome
    public Hospede(int idHospede, String nome) {
        this.idHospede = idHospede;
        this.nome = nome;
        this.email = ""; // Ou pode definir como null ou outro valor padrão
    }

    // Getters e setters
    public int getIdHospede() {
        return idHospede;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Hóspede{" +
                "ID=" + idHospede +
                ", Nome='" + nome + '\'' +
                ", Email='" + email + '\'' +
                '}';
    }
}
