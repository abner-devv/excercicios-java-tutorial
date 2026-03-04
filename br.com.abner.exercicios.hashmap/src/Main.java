/*
EXERCÍCIO 3 – HASHMAP

Objetivo:
Criar um mini sistema de controle de estoque.

Instruções:
1. Crie um HashMap<String, Integer>.
   (String = nome do produto)
   (Integer = quantidade em estoque)
2. Adicione pelo menos 4 produtos.
3. Mostre:
   - Todos os produtos e suas quantidades
4. Busque a quantidade de um produto específico usando get().
5. Atualize a quantidade de um produto.
6. Remova um produto.

Desafio extra:
Mostre apenas os produtos com estoque menor que 5.
*/

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> produtos = new HashMap<>();
        produtos.put("Celular", 3);
        produtos.put("Notebook", 2);
        produtos.put("Tv", 6);
        produtos.put("Cadeira", 1);

        for (String i : produtos.keySet()){
            System.out.print(i + ":" + produtos.get(i)+"\n");
        }

        System.out.println("Quantidade de Tvs: " + produtos.get("Tv"));

        produtos.put("Notebook", 4);
        System.out.println("Notebooks atualizados: " + produtos.get("Notebook"));

        produtos.remove("Cadeira");
        System.out.println("Cadeira removida"+produtos);

        System.out.println("\nProdutos com estoque menor que 5:");

        for (HashMap.Entry<String, Integer> entry : produtos.entrySet()) {
            if (entry.getValue() < 5) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
