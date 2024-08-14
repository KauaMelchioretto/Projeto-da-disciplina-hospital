package org.example.Entities;

import org.example.Types.Genero;
import org.example.Utils.DateFormatter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa {
    private List<String> historicoMedico;
    private LocalDateTime dataAdmissao;
    private Integer codigoPaciente;

    public List<String> getHistoricoMedico() {
        return historicoMedico;
    }

    public LocalDateTime getDataAdmissao() {
        return dataAdmissao;
    }

    public Integer getCodigoPaciente() {
        return codigoPaciente;
    }

    public Paciente(String nome, Integer idade, Genero genero, String cpf, String dataNascimento, List<String> historicoMedico, String dataAdmissao, Integer codigoPaciente) {
        super(nome, idade, genero, cpf, dataNascimento);
        historicoMedico = historicoMedico;
        this.dataAdmissao = DateFormatter.formatStringToDateTime(dataAdmissao);
        this.codigoPaciente = codigoPaciente;
    }
}
