package org.example.Entities;

import org.example.Types.Especialidades;
import org.example.Types.EstadoAtendimento;

import java.time.LocalDateTime;

import static org.example.Utils.DateFormatter.formatDateToString;

public class AtendimentoMedico implements Atendimento {
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataHoraAtendimento;
    private EstadoAtendimento estadoAtendimento;
    private String descricao;

    // Ao criar uma instância de atendimento médico, o próprio atendimento já se inicia,
    // sem a necessidade de um método a parte para inicializar o atendimento
    public AtendimentoMedico(Paciente paciente, Medico medico) {
        this.paciente = paciente;
        if (paciente.getIdade() < 18) {
            System.out.println("Paciente menor de idade, encaminhado para pediatria");
        }

        this.medico = medico;
        if (paciente.getIdade() < 18 && !medico.getEspecialidade().equals(Especialidades.PEDIATRA)) {
            System.out.println("O médico de menores de idade deve ser um médico Pediatra");
            return;
        }

        this.dataHoraAtendimento = LocalDateTime.now();
        this.estadoAtendimento = EstadoAtendimento.ABERTO;
    }

    @Override
    public void realizarDiagnostico() {
        System.out.println("Diagnóstico do atendimento: ");
        System.out.printf("     Paciente '%s' atendido pelo médico '%s' na data '%s' com a descrição '%s'\n", paciente.getNome(), medico.getNome(), formatDateToString(this.dataHoraAtendimento), this.descricao);
    }

    @Override
    public void prescreverMedicacao(String medicacao) {
        if (this.estadoAtendimento == EstadoAtendimento.ENCERRADO) {
            System.out.println("Este atendimento esta encerrado");
            return;
        }
        System.out.println("Medicação prescrita: " + medicacao);
    }

    @Override
    public void registrarHistorico(String descricao) {
        if (this.estadoAtendimento == EstadoAtendimento.ENCERRADO) {
            System.out.println("Este atendimento esta encerrado");
            return;
        }

        this.descricao = descricao;
        paciente.adicionarHistoricoMedico(
                new HistoricoMedico(
                        formatDateToString(dataHoraAtendimento),
                        descricao,
                        medico
                )
        );
    }

    @Override
    public void encerrarAtendimento() {
        if (this.estadoAtendimento == EstadoAtendimento.ENCERRADO) {
            System.out.println("Este atendimento esta encerrado");
            return;
        }
        System.out.println("Atendimento encerrado.");
        this.estadoAtendimento = EstadoAtendimento.ENCERRADO;
    }
}
