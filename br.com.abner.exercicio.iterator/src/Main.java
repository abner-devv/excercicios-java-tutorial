/*
EXERCÍCIO 4 – ITERATOR

Objetivo:
Percorrer uma lista e remover elementos específicos.

Instruções:
1. Crie um ArrayList com 8 números inteiros.
2. Use um Iterator para percorrer a lista.
3. Remova todos os números pares usando o método remove() do Iterator.
4. Mostre a lista final apenas com números ímpares.

IMPORTANTE:
Não use for tradicional para remover.
Use o Iterator corretamente.
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(3);
        numeros.add(7);
        numeros.add(8);
        numeros.add(2);
        numeros.add(5);
        numeros.add(9);
        numeros.add(10);

        Iterator<Integer> i = numeros.iterator();
        while (i.hasNext()){
            if((i.next() % 2) == 0){
                i.remove();
            }
        }

        System.out.println(numeros);
    }
}