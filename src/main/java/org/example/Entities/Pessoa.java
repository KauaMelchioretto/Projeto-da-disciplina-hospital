package org.example.Entities;

import org.example.Types.Genero;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.example.Utils.DateFormatter.formatStringToLocalDate;
import static org.example.Utils.DateFormatter.formatDateToString;


public abstract class Pessoa {
    private String nome;
    private Integer idade;
    private Genero genero;
    private String cpf;
    private LocalDate dataNascimento;

    public Pessoa(
            String nome,
            Genero genero,
            String cpf,
            String dataNascimento
    ) {
        this.nome = nome;
        this.genero = genero;
        this.cpf = cpf;
        this.dataNascimento = formatStringToLocalDate(dataNascimento);
        this.idade = calculaIdade();
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
        return formatDateToString(dataNascimento);
    }

    private int calculaIdade() {
        return (int) ChronoUnit.YEARS.between(this.dataNascimento, LocalDate.now());
    }
}


