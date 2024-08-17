package org.example.Entities;

import org.example.Types.Genero;
import org.example.Types.TipoSanguineo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.example.Utils.DateFormatter.formatStringToLocalDate;
import static org.example.Utils.DateFormatter.formatDateToString;

public class Paciente extends Pessoa {
    private long id;
    private List<HistoricoMedico> historicoMedico;
    private LocalDate dataRegistro;
    private TipoSanguineo tipoSanguineo;
    private List<String> alergias;
    private double altura;
    private double peso;

    public Paciente(
            String nome,
            Genero genero,
            String cpf,
            String dataNascimento,
            long id,
            String dataRegistro,
            TipoSanguineo tipoSanguineo,
            List<String> alergias,
            double altura,
            double peso
    ) {
        super(nome, genero, cpf, dataNascimento);
        this.id = id;
        this.dataRegistro = formatStringToLocalDate(dataRegistro);
        this.tipoSanguineo = tipoSanguineo;
        this.alergias = alergias;
        this.altura = altura;
        this.peso = peso;
        this.historicoMedico = new ArrayList<>();
    }

    public void adicionarHistoricoMedico(HistoricoMedico value) {
        historicoMedico.add(value);
    }

    public long getId() {
        return id;
    }

    public List<HistoricoMedico> getHistoricoMedico() {
        return historicoMedico;
    }

    public String getDataRegistro() {
        return formatDateToString(dataRegistro);
    }

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }
}
