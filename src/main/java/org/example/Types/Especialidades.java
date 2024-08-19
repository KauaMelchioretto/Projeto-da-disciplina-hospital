package org.example.Types;

public enum Especialidades {
    CLINICO_GERAL('G'),
    DENTISTA('D'),
    CARDIOLOGISTA('C'),
    ONCOLOGISTA('O'),
    PEDIATRA('P');

    private final char valor;

    Especialidades(char valor) {
        this.valor = valor;
    }

    public char getValor() {
        return valor;
    }

    public static Especialidades fromChar(char valor) {
        for (Especialidades especialidade : Especialidades.values()) {
            if (especialidade.getValor() == valor) {
                return especialidade;
            }
        }

        System.err.println("Nenhuma especialidade encontrado para o valor: " + valor);
        return null;
    }
}
