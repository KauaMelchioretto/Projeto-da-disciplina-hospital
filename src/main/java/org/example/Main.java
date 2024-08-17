package org.example;

import org.example.Entities.*;
import org.example.Types.Especialidades;
import org.example.Types.Genero;
import org.example.Types.TipoSanguineo;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Medico medico = new Medico(
                "Lucas",
                Genero.MASCULINO,
                "111.222.333-44",
                "29/10/2000",
                123,
                "980",
                Especialidades.ONCOLOGISTA,
                "15/08/2024",
                3500
        );

        Paciente paciente = new Paciente(
                "Kaua",
                Genero.MASCULINO,
                "555.999.777-88",
                "12/05/2004",
                456,
                "16/08/2024",
                TipoSanguineo.AB,
                List.of("Alergia a abelhas", "Alergia a vape"),
                1.7,
                70
        );

        Atendimento atendimento = new AtendimentoMedico(paciente, medico);

        atendimento.prescreverMedicacao("Rivotril");
        atendimento.registrarHistorico("Tem diabetes");
        atendimento.registrarHistorico("Ficou bem");
        atendimento.encerrarAtendimento();
        atendimento.realizarDiagnostico();

        for(HistoricoMedico historicoMedico : paciente.getHistoricoMedico()){
            System.out.println(historicoMedico.getDescricao());
        }
    }
}