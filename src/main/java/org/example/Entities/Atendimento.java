package org.example.Entities;

public interface Atendimento {
    void realizarDiagnostico();
    void prescreverMedicacao(String medicacao);
    void registrarHistorico(String descricao);
    void encerrarAtendimento(AtendimentoMedico atendimentoMedico);
}
