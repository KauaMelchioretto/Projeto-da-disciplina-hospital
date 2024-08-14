package org.example;

import org.example.Entities.Paciente;
import org.example.Entities.Pessoa;
import org.example.Types.Genero;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("t", 18, Genero.MASCULINO, "999.999.999-99", "16/12/2024");
        System.out.println(pessoa.getDataNascimento());
        System.out.println(pessoa.getGenero().name());

        // Dados do paciente
        String nome = "João da Silva";
        Integer idade = 45;
        Genero genero = Genero.MASCULINO;
        String cpf = "123.456.789-00";
        String dataNascimento = "01/01/1979";
        List<String> historicoMedico = new ArrayList<>();
        historicoMedico.add("Hipertensão");
        historicoMedico.add("Cirurgia de apendicite em 2010");
        String dataAdmissao = "14/08/2024 10:30:00";
        Integer codigoPaciente = 123456;

        // Instância de Paciente
        Paciente paciente = new Paciente(nome, idade, genero, cpf, dataNascimento, historicoMedico, dataAdmissao, codigoPaciente);

        // Exemplo de saída
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Código do Paciente: " + paciente.getCodigoPaciente());
        System.out.println("Data de Admissão: " + paciente.getDataAdmissao());
        System.out.println("Histórico Médico: " + paciente.getHistoricoMedico());
    }
}