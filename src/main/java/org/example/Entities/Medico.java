package org.example.Entities;

import org.example.Types.Especialidades;
import org.example.Types.Genero;

import java.time.LocalDate;

import static org.example.Utils.DateFormatter.formatStringToLocalDate;

public class Medico extends Pessoa {
    private long id;
    private String crm;
    private Especialidades especialidade;
    private LocalDate dataAdmissao;
    private double salario;

    public Medico(
            String nome,
            Genero genero,
            String cpf,
            String dataNascimento,
            long id,
            String crm,
            Especialidades especialidade,
            String dataAdmissao,
            double salario
    ) {
        super(nome, genero, cpf, dataNascimento);
        this.id = id;
        this.crm = crm;
        this.especialidade = especialidade;
        this.dataAdmissao = formatStringToLocalDate(dataAdmissao);
        this.salario = salario;
    }

    public long getId() {
        return id;
    }

    public String getCrm() {
        return crm;
    }

    public Especialidades getEspecialidade() {
        return especialidade;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public double getSalario() {
        return salario;
    }
}
