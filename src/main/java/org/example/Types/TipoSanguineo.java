package org.example.Types;

public enum TipoSanguineo {
    A('A'),
    B('B'),
    AB('X'),
    O('O');

    private final char valor;

    TipoSanguineo(char valor) {
        this.valor = valor;
    }

    public char getValor() {
        return valor;
    }

    public static TipoSanguineo fromChar(char valor) {
        for(TipoSanguineo tipoSanguineo : TipoSanguineo.values()) {
            if(tipoSanguineo.getValor() == valor ) {
                return tipoSanguineo;
            }
        }

        System.err.println("Nenhum tipo sanguíneo encontrado para o valor: " + valor);
        return null;
    }
}
