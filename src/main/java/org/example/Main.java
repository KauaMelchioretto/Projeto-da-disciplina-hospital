package org.example;

import org.example.Entities.*;
import org.example.Types.Especialidades;
import org.example.Types.Genero;
import org.example.Types.TipoSanguineo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
//        Medico medico = new Medico(
//                "Lucas",
//                Genero.MASCULINO,
//                "111.222.333-44",
//                "29/10/2000",
//                123,
//                "980",
//                Especialidades.ONCOLOGISTA,
//                "15/08/1999",
//                3500
//        );
//
//        Paciente paciente = new Paciente(
//                "Kaua",
//                Genero.MASCULINO,
//                "555.999.777-88",
//                "12/05/2004",
//                456,
//                "16/08/2024",
//                TipoSanguineo.AB,
//                List.of("Alergia a abelhas", "Alergia a vape"),
//                1.7,
//                70
//        );
//
//        Atendimento atendimento = new AtendimentoMedico(paciente, medico);
//
//        atendimento.prescreverMedicacao("Rivotril");
//        atendimento.registrarHistorico("Tem diabetes, após o tratamento ficou bem");
//        atendimento.encerrarAtendimento();
//        atendimento.realizarDiagnostico();
//
//      paciente.consultaHistoricoMedico();

        boolean run = true;
        while (run) {
            System.out.println("=========================================================");
            System.out.println("Bem vindo ao sistema de hospital, segue abaixo as opções");
            System.out.println("0 - Encerrar programa");
            System.out.println("1 - Cadastrar médico");
            System.out.println("2 - Cadastrar paciente");
            System.out.println("3 - Cadastrar atendimento");
            System.out.println("Digite um número para determinada ação:");

            Scanner commandScanner = new Scanner(System.in);
            int command = commandScanner.nextInt();
            ArrayList<Medico> medicos = new ArrayList<>();
            ArrayList<Paciente> pacientes = new ArrayList<>();

            if (command == 1) {
                System.out.println("++++ Cadastro de médico ++++");
                Scanner infoScanner = new Scanner(System.in);
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
                    medicos.add(new Medico(nome, genero, cpf, dataNascimento, "1323", especialidade, dataAdmissao, salario));
                } catch (Exception e) {
                    throw new Exception("Erro ao cadastrar médico! Revise as informações. Erro:" + e.toString());
                }
            }
            else if (command == 2) {
                System.out.println("++++ Cadastro de paciente ++++");
                Scanner infoScanner = new Scanner(System.in);
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
                }
                catch (Exception e) {
                    throw new Exception("Erro ao cadastrar paciente! Revise as informações. Erro:" + e.toString());
                }

            }

            if(command == 0)
                run = false;
        }
    }
}