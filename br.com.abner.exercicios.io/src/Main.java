/*
===========================================
EXERCÍCIO – JAVA I/O (Streams)
===========================================

Objetivo:
Praticar leitura e escrita de arquivos utilizando
FileWriter, BufferedWriter, FileReader e BufferedReader.

Instruções:

1) Crie um arquivo chamado "alunos.txt".
   - Caso não exista, ele deve ser criado automaticamente
     ao utilizar FileWriter.

2) Solicite ao usuário que digite:
      • Nome do aluno
      • Nota 1
      • Nota 2

3) Grave no arquivo "alunos.txt" no seguinte formato:
      Nome: João
      Nota 1: 8.5
      Nota 2: 7.0
      Média: 7.75
   - Utilize:
        • FileWriter
        • BufferedWriter
        • write()
        • newLine()
        • flush()

4) Após gravar os dados, feche o arquivo corretamente.

5) Em seguida, leia todo o conteúdo do arquivo utilizando:
      • FileReader
      • BufferedReader
      • readLine()

6) Exiba o conteúdo completo no console linha por linha.

Regras:
- Utilize try-with-resources ou try/catch.
- Não utilize java.nio.
- Não utilize a classe File.
- Utilize obrigatoriamente:
      • write()
      • newLine()
      • readLine()
      • flush()

Desafio extra (opcional):
- Permita que o usuário escolha se deseja adicionar
  novos alunos ao final do arquivo (modo append).
*/

import java.io.*;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {

        //Diretorio atual do script
        String diretorioAtual = System.getProperty("user.dir");
        System.out.println("Diretório atual: " + diretorioAtual);

        Scanner sc = new Scanner(System.in);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("./projeto/aluno.txt"))) {

            String nome = sc.nextLine();
            int notaOne = sc.nextInt();
            int notaTwo = sc.nextInt();

            bw.write("Nome: " + nome);
            bw.newLine();
            bw.write("Nota 1: " + notaOne);
            bw.newLine();
            bw.write("Nota 2: " + notaTwo);
            bw.newLine();
            int media = (notaOne + notaTwo) / 2;
            bw.write("Média: " + media);
            bw.flush();

            try (BufferedReader br = new BufferedReader(new FileReader("./projeto/aluno.txt"))) {
                System.out.println("Conteudo do arquivo\n");
                String linha;
                while ((linha = br.readLine()) != null){
                    System.out.println(linha);
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        sc.close();
    }
}
