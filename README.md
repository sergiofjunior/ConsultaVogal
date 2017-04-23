# ConsultaVogal
Consulta Vogal Teste - NS 

3) Dada uma stream, encontre o primeiro caracter Vogal, após uma consoante, onde a mesma é antecessora a uma vogal e que não se repita no resto da stream. O termino da leitura da stream deve ser  garantido através do método hasNext(), ou seja, retorna falso para o termino da leitura da stream. Voce tera acesso a leitura da stream através dos métodos de interface fornecidos ao termino do enunciado. (15 pontos)

*Leia todo o enunciado

Premissas:
Uma chamada para hasNext() ir retornar se a stream ainda contem caracteres para processar.
Uma chamada para getNext() ir retornar o proximo caracter a ser processado na stream.
Não será possível reiniciar o fluxo da leitura da stream.
Não poderá ser utilizado nenhum framework Java, apenas código nativo.

Exemplo:
Input:  aAbBABacafe
Output: e
No exemplo, ‘e’ é o primeiro caracter Vogal da stream que não se repete após a primeira Consoante ‘f’o qual tem uma vogal ‘a’ como antecessora.

Segue o exemplo da interface em Java:
public interface Stream{
    public char getNext();
    public boolean hasNext();
}
public static char firstChar(Stream input) {
}

O que espera-se como resultado - Dicas e direcionamentos:
•	Tente criar sua implementação pensando em performance;
•	Efetuar casos de teste para diversos cenários e uma boa pratica;
•	Documentar o código seguindo as boas práticas de mercado;
•	Os códigos mais simples tendem a serem mais elegantes;
•	Em caso de não localização do caracter, o sistema deve informar uma mensagem amigável;
•	Ao finalizar o desenvolvimento você pode compartilhar o código pelo Github ou de outra maneira que preferir (como arquivo compactado). Se possível, em caso de arquivo compacto, envie o mesmo para um virtual drive e compartilha o link na prova;
•	Caso utilize o Git/Bitbucket, não esqueça de criar o .gitignore
•	Não copie os códigos gerados na ferramenta.
•	Não utilizar o nome da Netshoes nos projetos ou packages da prova.
