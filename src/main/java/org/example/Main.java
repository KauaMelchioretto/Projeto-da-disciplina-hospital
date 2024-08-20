package org.example;

import org.example.Entities.*;
import org.example.Types.Especialidades;
import org.example.Types.Genero;
import org.example.Types.TipoSanguineo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.Utils.InterfaceUsuario.*;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean run = true;
        ArrayList<Medico> medicos = new ArrayList<>();
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<AtendimentoMedico> atendimentos = new ArrayList<>();
        Scanner commandScanner = new Scanner(System.in);

        while (run) {
            exibirMenuPrincipal();
            int command = commandScanner.nextInt();

            switch (command) {
                case 1:
                    cadastrarMedico(medicos);
                    break;
                case 2:
                    cadastrarPaciente(pacientes);
                    break;
                case 3:
                    cadastrarAtendimento(medicos, pacientes, atendimentos);
                    break;
                case 4:
                    listaInfoAtendimentos(atendimentos);
                    break;
                case 5:
                    encerrarAtendimento(atendimentos);
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println("Comando inválido. Por favor, tente novamente.");
            }
        }
    }
}
