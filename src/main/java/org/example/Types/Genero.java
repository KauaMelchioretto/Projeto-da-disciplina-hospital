package org.example.Types;

public enum Genero {
    MASCULINO('M'),
    FEMININO('F');

    private final char valor;

    Genero(char valor) {
        this.valor = valor;
    }

    public char getValor() {
        return this.valor;
    }

    public static Genero fromChar(char valor) {
        for (Genero genero : Genero.values()) {
            if(genero.getValor() == valor) {
                return genero;
            }
        }

        System.err.println("Nenhum genero encontrado para o valor: " + valor);
        return null;
    }
}