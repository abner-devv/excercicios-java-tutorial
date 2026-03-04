/*
EXERCÍCIO 1 – ARRAYLIST

Objetivo:
Criar um sistema simples de cadastro de notas.

Instruções:
1. Crie um ArrayList de Double para armazenar 5 notas.
2. Adicione manualmente 5 notas.
3. Calcule a média das notas.
4. Mostre:
   - Todas as notas
   - A média
   - Se o aluno está APROVADO (média >= 7)
     ou REPROVADO (média < 7)

Desafio extra:
Use um loop para percorrer a lista.
*/

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {

        ArrayList<Double> notas = new ArrayList<>();
        notas.add(10.0);
        notas.add(8.2);
        notas.add(5.5);
        notas.add(9.5);
        notas.add(5.5);

        double soma = 0;
        System.out.println("Notas do aluno:");
        int i;
        for (i = 0; i < notas.size(); i++) {
            System.out.println("Nota " + (i+1) + ": " + notas.get(i));
            soma += notas.get(i);
        }
        double media = soma / i;
        System.out.println("A média do aluno foi: " + media);

        String situacao = media >= 7 ?"Aprovado" : "Reprovado";
        System.out.println(situacao);
    }
}