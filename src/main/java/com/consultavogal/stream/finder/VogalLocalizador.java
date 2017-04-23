package com.consultavogal.stream.finder;

import com.consultavogal.stream.stream.Stream;

import java.util.*;

/**
 * Localizador de Vogal
 *
 * @author sergiofjunior@gmail.com
 */
public class VogalLocalizador {

    /*
    Regex necessários e campo Vazio
     */
    public static final char VAZIO = ' ';
    private static final String REGEX_VOGAIS = "(?i)[aáàãâÁÀÃÂeéêÉÊiíÍoóõôÓÕÔuúÚ]";
    private static final String REGEX_CARACTER_ESPECIAL = "[^\\w]";
    private static final String DIGITO_REGEX = "\\d";

    private VogalLocalizador() {
    }


    /*
     * Método que inicia o processo da busca da vogal
     */
    public static char primeiroCaracter(Stream input) {
        if (input == null) {
            throw new IllegalArgumentException("Stream não pode ser nula");
        }

        Map<Character, Boolean> vogaisEncontradas = new LinkedHashMap<Character, Boolean>();
        Map<Character, List<Character>> predecessores = new HashMap<Character, List<Character>>();

        char caracterAnterior = ' ';
        while (input.hasNext()) {
            char atualCaracter = input.getNext();

            registraVogalCaracter(vogaisEncontradas, atualCaracter);
            computaPredecessor(predecessores, atualCaracter, caracterAnterior);

            caracterAnterior = atualCaracter;
        }

        return localizaVogal(vogaisEncontradas, predecessores);
    }

    /*
     * Localiza Vogal que possui um MAP<Character, Boolean> que contém qual vogal foi encontrada
     * e também um MAP <Character, List<Character>> que possui o caracter atual e seus anteriores.
     */
    private static Character localizaVogal(Map<Character, Boolean> vogaisEncontradas,
                                         Map<Character, List<Character>> predecessores) {
        for (Map.Entry<Character, Boolean> ocorrenciaVogal : vogaisEncontradas.entrySet()) {
            if (!ocorrenciaVogal.getValue()) {
                continue;
            }

            for (Character vogalPredecessora : predecessores.get(ocorrenciaVogal.getKey())) {
                if (!isConsoante(vogalPredecessora)) {
                    continue;
                }

                for (Character consoantePredecessor : predecessores.get(vogalPredecessora)) {
                    if (isVogal(consoantePredecessor)) {
                        return ocorrenciaVogal.getKey();
                    }
                }
            }
        }
        return VAZIO;
    }

    /*
     * Computa a vogal predecessora
     */
    private static void computaPredecessor(Map<Character, List<Character>> predecessores,
                                           char atualCaracter,
                                           char caracterAnterior) {
        List<Character> caracteres = predecessores.get(atualCaracter);
        if (caracteres == null) {
            caracteres = new ArrayList<Character>();
            predecessores.put(atualCaracter, caracteres);
        }
        if (caracterAnterior != ' ') {
            caracteres.add(caracterAnterior);
        }
    }

    /*
     * Registra uma vogal
     */
    private static void registraVogalCaracter(Map<Character, Boolean> vogaisEncontradas,
                                                  char atualCaracter) {
        if (!isVogal(atualCaracter)) {
            return;
        }
        if (vogaisEncontradas.get(atualCaracter) == null) {
            vogaisEncontradas.put(atualCaracter, true);
        } else {
            vogaisEncontradas.put(atualCaracter, false);
        }
    }

    /*
     * Verifica se o caracter é uma vogal
     */
    private static boolean isVogal(char caracter) {
        return isVogal(String.valueOf(caracter));
    }

    /*
     * Verifica se o caracter é uma consoante
     */
    private static boolean isConsoante(char vogalPredecessora) {
        String caracter = String.valueOf(vogalPredecessora);
        return !isVogal(caracter) &&
                !isCaracterEspecial(caracter) &&
                !isDigito(caracter);
    }

    /*
     * Valida se é uma Vogal (através do REGEX, sendo acentuadas, maiusculas e minusculas
     */
    private static boolean isVogal(String caracter) {
        return caracter.matches(REGEX_VOGAIS);
    }

    private static boolean isDigito(String caracter) {
        return caracter.matches(DIGITO_REGEX);
    }

    /*
     * Verifica se é um caracter especial (@ * ! % ; : .)
     */
    private static boolean isCaracterEspecial(String caracter) {
        return caracter.matches(REGEX_CARACTER_ESPECIAL);
    }
}
