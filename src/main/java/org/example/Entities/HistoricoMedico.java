package org.example.Entities;

import java.time.LocalDateTime;

import static org.example.Utils.DateFormatter.formatStringToLocalDateTime;
import static org.example.Utils.DateFormatter.formatDateToString;

public class HistoricoMedico {
    private LocalDateTime dataHoraOcorrencia;
    private String descricao;
    private Medico medico;

    public HistoricoMedico(
            String dataHoraOcorrencia,
            String descricao,
            Medico medico
    ) {
        this.dataHoraOcorrencia = formatStringToLocalDateTime(dataHoraOcorrencia);
        this.descricao = descricao;
        this.medico = medico;
    }

    public String getDataHoraOcorrencia() {
        return formatDateToString(dataHoraOcorrencia);
    }

    public String getDescricao() {
        return descricao;
    }

    public Medico getMedico() {
        return medico;
    }
}
