package com.consultavogal.stream.finder;

import com.consultavogal.stream.stream.Stream;
import com.consultavogal.stream.stream.CaracterStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Teste do VogalLocalizador
 *
 * @author sergiofjunior@gmail.com
 */
@RunWith(Parameterized.class)
public class VogalLocalizadorTest {

    @Parameterized.Parameters(name = "input:{0} - output:{1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new CaracterStream("aAbBABacafe"), 'e'},
                {new CaracterStream("AAAAAaaaa"), ' '},
                {new CaracterStream("afe"), 'e'},
                {new CaracterStream("cafezal"), 'e'},
                {new CaracterStream("aoBABssxacaee"), 'A'},
                {new CaracterStream("brasil"), 'i'},
                {new CaracterStream("yyyyy"), ' '},
                {new CaracterStream("acordar"), 'o'},
                {new CaracterStream(" "), ' '},
                {new CaracterStream("t"), ' '},
                {new CaracterStream("d"), ' '},
                {new CaracterStream("c--a--f--e"), ' '},
                {new CaracterStream("a[f--__e"), ' '},
                {new CaracterStream("---[]afe"), 'e'},
        });
    }

    /*
     * Stream
     */
    private final Stream stream;

    /*
     * Caracter Esperado - para fins do teste
     */
    private final char caracterEsperado;

    /*
     * Construtor da classe, recebe stream e qual caracter é esperado
     */
    public VogalLocalizadorTest(Stream stream, char caracterEsperado) {
        this.stream = stream;
        this.caracterEsperado = caracterEsperado;
    }

    /*
     * Teste para verificar qual a vogal da stream e qual o caracter é esperado
     */
    @Test
    public void verificaVogalNaStream() {
        char actual = VogalLocalizador.primeiroCaracter(stream);
        assertThat(actual, is(equalTo(caracterEsperado)));
    }
}