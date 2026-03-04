/*
EXERCÍCIO 2 – HASHSET

Objetivo:
Simular um sistema de registro de nomes em um evento.

Instruções:
1. Crie um HashSet de String.
2. Adicione 6 nomes (inclua pelo menos 1 nome repetido).
3. Mostre:
   - Todos os nomes registrados
   - A quantidade total de participantes
4. Verifique se um nome específico está no conjunto usando contains().

Pergunta para refletir:
Por que o nome repetido não aparece duas vezes?
*/

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<String> nomes = new HashSet<>();
        nomes.add("pedro");
        nomes.add("lucas");
        nomes.add("joao");
        nomes.add("sanderson");
        nomes.add("vitor");
        nomes.add("vitor");

        for(String nome : nomes){
            System.out.println(nome);
        }

        System.out.println("Quantidade total: " + nomes.size());
        System.out.println("Buscando por (joao): " + nomes.contains("joao"));
    }
}