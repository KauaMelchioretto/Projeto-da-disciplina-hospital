package org.example.Entities;

import org.example.Types.Especialidades;
import org.example.Types.Genero;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.example.Utils.DateFormatter.formatStringToLocalDate;

public class Medico extends Pessoa {
    private String crm;
    private Especialidades especialidade;
    private LocalDate dataAdmissao;
    private double salario;

    public Medico(
            String nome,
            Genero genero,
            String cpf,
            String dataNascimento,
            String crm,
            Especialidades especialidade,
            String dataAdmissao,
            double salario
    ) {
        super(nome, genero, cpf, dataNascimento);

        if (this.getIdade() < 18) {
            System.out.println("Um médico não pode ser menor de idade");
            return;
        }

        this.crm = crm;
        this.especialidade = especialidade;
        this.dataAdmissao = formatStringToLocalDate(dataAdmissao);
        if(this.dataAdmissao.isBefore(formatStringToLocalDate(super.getDataNascimento()))) {
            // Tu é burro cara?
            System.err.println("A data de admissão não pode ser menor do que a data de nascimento");
            return;
        }
        // Para validar a data de nascimento do médico com a data de admissão dele, para garantir que vai ter sido contratado após completar seus 18 anos
        // Pedro filho da puta
        else if((int) ChronoUnit.YEARS.between(formatStringToLocalDate(this.getDataNascimento()), this.dataAdmissao) < 18) {
            System.err.println("A data de admissão não está de acordo com a data de nascimento do médico");
            return;
        }
        this.salario = salario;
        System.out.println("Médico cadastrado com sucesso!");
    }

    public String getCrm() {
        return crm;
    }

    public Especialidades getEspecialidade() {
        return especialidade;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public double getSalario() {
        return salario;
    }
}
