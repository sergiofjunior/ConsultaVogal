package com.consultavogal.stream.main;

import com.consultavogal.stream.finder.VogalLocalizador;
import com.consultavogal.stream.stream.CaracterStream;

/**
 * Class Main, rode o aplicatiovo através desta classe (Run).
 *
 * @author sergiofjunior@gmail.com
 */
public class MainApplication {

    public static void main(String[] args) {
        /*
         * Para executar, altere a Stream abaixo (aAbBABacafe) para a Stream de desejada.
         */
        char vogalEncontrada = VogalLocalizador.primeiroCaracter(new CaracterStream("aAbBABacafe"));
        if (vogalEncontrada != VogalLocalizador.VAZIO) {
            System.out.println("\nCaracter encontrado: " + vogalEncontrada);
        } else {
            System.out.println("\nCaracter nao localizado.");
        }
    }
}
