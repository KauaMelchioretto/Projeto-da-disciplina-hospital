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
            String dataRegistro,
            TipoSanguineo tipoSanguineo,
            List<String> alergias,
            double altura,
            double peso
    ) {
        super(nome, genero, cpf, dataNascimento);
        this.dataRegistro = formatStringToLocalDate(dataRegistro);
        if (this.dataRegistro.isBefore(formatStringToLocalDate(this.getDataNascimento()))) {
            System.err.println("A data de registro/entrada do paciente não pode ser menor que sua data de nascimento");
            return;
        }
        this.tipoSanguineo = tipoSanguineo;
        this.alergias = alergias;
        this.altura = altura;
        this.peso = peso;
        this.historicoMedico = new ArrayList<>();
        System.out.println("Paciente cadastrado com sucesso!");
    }

    public void adicionarHistoricoMedico(HistoricoMedico value) {
        historicoMedico.add(value);
    }

    public List<HistoricoMedico> getHistoricoMedico() {
        return historicoMedico;
    }

    public void consultaHistoricoMedico() {
        System.out.println("\nHistórico médico do paciente: " + this.getNome());
        for(HistoricoMedico historicoMedico : this.getHistoricoMedico()){
            System.out.println("======================================");
            System.out.println("Data: " + historicoMedico.getDataHoraOcorrencia());
            System.out.println("Descrição: " + historicoMedico.getDescricao());
            System.out.println("Atendido pelo Médico: " + historicoMedico.getMedico().getNome());
            System.out.println("======================================");
        }
    }

    public static void listaPacientesIndex(List<Paciente> pacientes) {
        System.out.println("=== Lista index/nome paciente ===");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.printf("Index: %d, Nome: %s\n", i, pacientes.get(i).getNome());
        }
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
