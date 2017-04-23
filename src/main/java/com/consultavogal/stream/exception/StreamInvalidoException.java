package com.consultavogal.stream.exception;

/**
 * Excepetion personalizado para Stream
 *
 * @author sergiofjunior@gmail.com
 */
public class StreamInvalidoException extends RuntimeException {

    private static final long serialVersionUID = -1;

    public StreamInvalidoException() {
        super("Nao existem mais caracteres para serem processados");
    }
}
