package org.example.Utils;

import org.example.Entities.AtendimentoMedico;
import org.example.Entities.Medico;
import org.example.Entities.Paciente;
import org.example.Types.Especialidades;
import org.example.Types.Genero;
import org.example.Types.TipoSanguineo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    public static void exibirMenuPrincipal() {
        System.out.println("=========================================================");
        System.out.println("Bem vindo ao sistema de hospital, segue abaixo as opções");
        System.out.println("0 - Encerrar programa");
        System.out.println("1 - Cadastrar médico");
        System.out.println("2 - Cadastrar paciente");
        System.out.println("3 - Cadastrar atendimento");
        System.out.println("4 - Listar atendimentos");
        System.out.println("5 - Cancelar atendimento");
        System.out.println("Digite um número para determinada ação:");
    }

    public static void cadastrarMedico(ArrayList<Medico> medicos) throws Exception {
        Scanner infoScanner = new Scanner(System.in);
        System.out.println("++++ Cadastro de médico ++++");
        System.out.println("Digite um nome: ");
        String nome = infoScanner.nextLine();
        System.out.println("Digite um gênero: (F) ou (M)");
        Genero genero = Genero.fromChar(Character.toUpperCase(infoScanner.nextLine().charAt(0)));
        System.out.println("Digite um CPF: ");
        String cpf = infoScanner.nextLine();
        System.out.println("Digite a data de Nascimento: ");
        String dataNascimento = infoScanner.nextLine();
        System.out.println("Digite o crm: ");
        String crm = infoScanner.nextLine();
        System.out.println("Digite a especialidade (G) 'Clinico geral', (D) Dentista, (C) Cardiologista, (O) Oncologista, (P) Pediatra :");
        Especialidades especialidade = Especialidades.fromChar(Character.toUpperCase(infoScanner.nextLine().charAt(0)));
        System.out.println("Digite a data de admissão: ");
        String dataAdmissao = infoScanner.nextLine();
        System.out.println("Digite o salário: ");
        double salario = infoScanner.nextDouble();

        try {
            medicos.add(new Medico(nome, genero, cpf, dataNascimento, crm, especialidade, dataAdmissao, salario));
        } catch (Exception e) {
            throw new Exception("Erro ao cadastrar médico! Revise as informações. Erro:" + e.toString());
        }
    }

    public static void cadastrarPaciente(ArrayList<Paciente> pacientes) throws Exception {
        Scanner infoScanner = new Scanner(System.in);
        System.out.println("++++ Cadastro de paciente ++++");
        System.out.println("Digite um nome: ");
        String nome = infoScanner.nextLine();
        System.out.println("Digite um gênero: (F) ou (M)");
        Genero genero = Genero.fromChar(Character.toUpperCase(infoScanner.nextLine().charAt(0)));
        System.out.println("Digite um CPF: ");
        String cpf = infoScanner.nextLine();
        System.out.println("Digite a data de Nascimento: ");
        String dataNascimento = infoScanner.nextLine();
        System.out.println("Digite a data de registro/entrada do paciente: ");
        String dataRegistro = infoScanner.nextLine();
        System.out.println("Digite o tipo sanguíneo A(A), B(B), AB(X), O(O): ");
        TipoSanguineo tipoSanguineo = TipoSanguineo.fromChar(Character.toUpperCase(infoScanner.nextLine().charAt(0)));
        System.out.println("Digite alergias (se possuir): ");
        String alergias = infoScanner.nextLine();
        List<String> alergiasList = new ArrayList<>();
        alergiasList.add(alergias);
        System.out.println("Digite a altura: ");
        double altura = infoScanner.nextDouble();
        System.out.println("Digite o peso: ");
        double peso = infoScanner.nextDouble();

        try {
            pacientes.add(new Paciente(nome, genero, cpf, dataNascimento, dataRegistro, tipoSanguineo, alergiasList, altura, peso));
        } catch (Exception e) {
            throw new Exception("Erro ao cadastrar paciente! Revise as informações. Erro:" + e.toString());
        }
    }

    public static void cadastrarAtendimento(ArrayList<Medico> medicos, ArrayList<Paciente> pacientes, ArrayList<AtendimentoMedico> atendimentos) throws Exception {
        Scanner infoScanner = new Scanner(System.in);
        System.out.println("++++ Cadastro de atendimento ++++");

        if (medicos.isEmpty()) {
            System.err.println("Não há médicos cadastrados, cadastre um médico para cadastrar um atendimento");
            return;
        }

        if (pacientes.isEmpty()) {
            System.err.println("Não há pacientes cadastrados, cadastre um paciente para cadastrar um atendimento");
            return;
        }

        System.out.println("Digite o horário do atendimento (dd/MM/yyyy HH:mm) ");
        String dataHoraAtendimento = infoScanner.nextLine();
        System.out.println("Digite a descrição: ");
        String descricao = infoScanner.nextLine();
        System.out.println("Digite o index do Paciente: ");
        Paciente.listaPacientesIndex(pacientes);
        int indexPaciente = infoScanner.nextInt();
        System.out.println("Digite o index do Médico: ");
        Medico.listaMedicosIndex(medicos);
        int indexMedico = infoScanner.nextInt();

        try {
            final AtendimentoMedico novoAtendimentoMedico = new AtendimentoMedico(pacientes.get(indexPaciente), medicos.get(indexMedico), dataHoraAtendimento, descricao);
            if (AtendimentoMedico.validaAtendimentos(medicos, pacientes, atendimentos, novoAtendimentoMedico))
                atendimentos.add(novoAtendimentoMedico);
        } catch (Exception e) {
            throw new Exception("Erro ao cadastrar atendimento! Revise as informações. Erro:" + e.toString());
        }
    }

    public static void encerrarAtendimento(ArrayList<AtendimentoMedico> atendimentos) throws Exception {
        if(atendimentos.isEmpty()){
            System.err.println("Não há atendimentos para serem cancelados");
            return;
        }

        Scanner infoScanner = new Scanner(System.in);
        System.out.println("++++ Cancelamento de atendimento ++++");
        AtendimentoMedico.listaInfoAtendimentos(atendimentos);
        System.out.println("Digite o index para cancelar o atendimento: ");
        int index = infoScanner.nextInt();
        AtendimentoMedico atendimentoMedico = atendimentos.get(index);

        try {
            atendimentoMedico.encerrarAtendimento(atendimentoMedico);
        } catch (Exception e) {
            throw new Exception("Erro ao cadastrar atendimento! Revise as informações. Erro:" + e.toString());
        }
    }

    public static void listaInfoAtendimentos(ArrayList<AtendimentoMedico> atendimentos) {
        AtendimentoMedico.listaInfoAtendimentos(atendimentos);
    }
}
