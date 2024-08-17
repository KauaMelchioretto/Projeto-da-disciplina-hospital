package org.example.Entities;

import org.example.Types.EstadoAtendimento;

import java.time.LocalDateTime;

import static org.example.Utils.DateFormatter.formatDateToString;

public class AtendimentoMedico implements Atendimento {
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataHoraAtendimento;
    private EstadoAtendimento estadoAtendimento;

    public AtendimentoMedico(Paciente paciente, Medico medico) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHoraAtendimento = LocalDateTime.now();
        this.estadoAtendimento = EstadoAtendimento.ABERTO;
    }

    @Override
    public void realizarDiagnostico() {
        if (this.estadoAtendimento == EstadoAtendimento.ENCERRADO) {
            System.out.println("Este atendimento esta encerrado");
            return;
        }
        System.out.println("Diagnóstico realizado: Diagnóstico feito");
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
