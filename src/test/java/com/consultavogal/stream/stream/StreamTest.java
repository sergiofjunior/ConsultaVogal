package com.consultavogal.stream.stream;

import com.consultavogal.stream.exception.StreamInvalidoException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Excepetion personalizado
 *
 * @author sergiofjunior@gmail.com
 */
public class StreamTest {


    /**
     * Valida que possui mais caracteres a serem processados.
     */
    @Test
    public void notificaMaisCaracteresParaProcessar() {
        Stream stream = new CaracterStream("abcdef");
        assertThat(stream.hasNext(), is(equalTo(true)));
        assertThat(stream.getNext(), is(equalTo('a')));
    }

    /**
     * Notifica que não foi encontrado caracter para o requisito do teste.
     */
    @Test
    public void notificaCaracterNaoEncontrado() {
        Stream stream = new CaracterStream("testehjf");
        while (stream.hasNext()) {
            stream.getNext();
        }
        assertThat(stream.hasNext(), is(equalTo(false)));
    }

    /**
     * Processa todos caracteres da Stream
     */
    @Test
    public void processaTodosCaracteresDaStream() {
        String sequenciaCaracteres = "exercicio";
        char[] values = sequenciaCaracteres.toCharArray();

        Stream stream = new CaracterStream(sequenciaCaracteres);
        int i = 0;
        while (stream.hasNext()) {
            char actual = stream.getNext();
            assertThat(actual, is(equalTo(values[i++])));
        }
        assertThat(stream.hasNext(), is(equalTo(false)));
    }

    /**
     * Lança a exception de Stream Invalida
     */
    @Test(expected = StreamInvalidoException.class)
    public void geraExcecaoQuandoStreamInvalida() {
        Stream stream = new CaracterStream("acb");
        for (int i = 0; i < 5; i++) {
            stream.getNext();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void geraExcecaoStreamInvalida() {
        new CaracterStream(null);
    }
}