package org.example.Entities;

import org.example.Types.Especialidades;
import org.example.Types.EstadoAtendimento;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.example.Utils.DateFormatter.formatDateToString;
import static org.example.Utils.DateFormatter.formatStringToLocalDateTime;

public class AtendimentoMedico implements Atendimento {

    private Paciente paciente;
    private Medico medico;

    private LocalDateTime dataHoraAtendimento;
    private EstadoAtendimento estadoAtendimento;
    private String descricao;

    // Ao criar uma instância de atendimento médico, o próprio atendimento já se inicia,
    // sem a necessidade de um método a parte para inicializar o atendimento
    public AtendimentoMedico(Paciente paciente, Medico medico, String dataHoraAtendimento, String descricao) {
        this.paciente = paciente;
        if (paciente.getIdade() < 18) {
            System.out.println("Paciente menor de idade, encaminhado para pediatria");
        }

        this.medico = medico;
        if (paciente.getIdade() < 18 && !medico.getEspecialidade().equals(Especialidades.PEDIATRA)) {
            System.out.println("O médico de menores de idade deve ser um médico Pediatra");
            return;
        }

        this.dataHoraAtendimento = formatStringToLocalDateTime(dataHoraAtendimento);
        this.estadoAtendimento = EstadoAtendimento.ABERTO;
        this.descricao = descricao;
        System.out.println("Atendimento cadastrado com sucesso");
    }

    public static void listaInfoAtendimentos(ArrayList<AtendimentoMedico> atendimentosMedicos) {
        if (atendimentosMedicos.isEmpty()) {
            System.err.println("Não há atendimentos a serem listados");
            return;
        }

        // Ordena lista por data do atendimento
        Comparator<AtendimentoMedico> comparator = Comparator.comparing(AtendimentoMedico::getDataHoraAtendimento);
        atendimentosMedicos.sort(comparator);

        for (int i = 0; i < atendimentosMedicos.size(); i++) {
            AtendimentoMedico atendimentoMedico = atendimentosMedicos.get(i);

            System.out.printf("Index: %d, Paciente: %s, Medico (CRM): %s, Data: %s, Estado do atendimento: %s, Descrição: %s\n", i, atendimentoMedico.paciente.getNome(), atendimentoMedico.medico.getCrm(), formatDateToString(atendimentoMedico.dataHoraAtendimento), atendimentoMedico.estadoAtendimento.name(), atendimentoMedico.descricao);
        }
    }

    public static boolean validaAtendimentos(ArrayList<Medico> medicos, ArrayList<Paciente> pacientes, ArrayList<AtendimentoMedico> atendimentos, AtendimentoMedico atendimentoMedico) {
        for (int i = 0; i < atendimentos.size(); i++) {
            AtendimentoMedico atendimentoAtual = atendimentos.get(i);
            Medico medicoAtual = atendimentoMedico.getMedico();
            Paciente pacienteAtual = atendimentoMedico.getPaciente();
            LocalDateTime horarioAtual = atendimentoMedico.dataHoraAtendimento;

            // Verifica conflito de médico
            if (medicoAtual.getCrm().equals(atendimentoAtual.getMedico().getCrm()) &&
                    horarioAtual.equals(atendimentoAtual.dataHoraAtendimento) && !atendimentoAtual.estadoAtendimento.equals(EstadoAtendimento.ENCERRADO)) {
                System.err.println("Conflito de horário para o médico: " + medicoAtual.getNome());
                return false;
            }

            // Verifica conflito de paciente
            if (pacienteAtual.getCpf().equals(atendimentoAtual.getPaciente().getCpf()) &&
                    horarioAtual.equals(atendimentoAtual.dataHoraAtendimento) && !atendimentoAtual.estadoAtendimento.equals(EstadoAtendimento.ENCERRADO)) {
                System.err.println("Conflito de horário para o paciente: " + pacienteAtual.getNome());
                return false;
            }
        }
        return true;
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
    public void encerrarAtendimento(AtendimentoMedico atendimentoMedico) {
        if (atendimentoMedico.estadoAtendimento == EstadoAtendimento.ENCERRADO) {
            System.out.println("Este atendimento já esta encerrado");
            return;
        }
        System.out.println("Atendimento encerrado.");
        atendimentoMedico.estadoAtendimento = EstadoAtendimento.ENCERRADO;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDateTime getDataHoraAtendimento() {
        return dataHoraAtendimento;
    }
}
