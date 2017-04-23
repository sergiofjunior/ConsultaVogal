package com.consultavogal.stream.stream;

import com.consultavogal.stream.exception.StreamInvalidoException;

/**
 * Bean que representa o CaracterStream - contém a Strem, array de caracteres e o índice atual.
 *
 * @author sergiofjunior@gmail.com
 */
public class CaracterStream implements Stream {

    /**
     * Stream.
     */
    private final String stream;

    /**
     * Caracteres.
     */
    private final char[] caracteres;

    /**
     * Currenti Index.
     */
    private int currentIndex;

    // Construtor - String não pode ser nula na entrada do método main
    public CaracterStream(String stream) {
        if (stream == null) {
            throw new IllegalArgumentException("A Stream não pode ser nula");
        }
        this.stream = stream;
        this.caracteres = stream.toCharArray();
    }

    // Busca próximo caracter na string
    public char getNext() {
        if (!hasNext()) {
            throw new StreamInvalidoException();
        }
        return caracteres[currentIndex++];
    }

    public boolean hasNext() {
        return currentIndex < caracteres.length;
    }

    @Override
    public String toString() {
        return stream;
    }
}
