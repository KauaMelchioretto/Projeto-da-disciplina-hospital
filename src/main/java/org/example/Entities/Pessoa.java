package org.example.Entities;

import org.example.Types.Genero;
import org.example.Utils.DateFormatter;

import java.util.Date;

public class Pessoa {
    private String nome;
    private Integer idade;
    private Genero genero;
    private String cpf;
    private Date dataNascimento;

    public Pessoa(String nome, Integer idade, Genero genero, String cpf, String dataNascimento) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.cpf = cpf;
        this.dataNascimento = (Date) DateFormatter.formatStringToDate(dataNascimento);
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return DateFormatter.formatDateToString(dataNascimento);
    }
}


