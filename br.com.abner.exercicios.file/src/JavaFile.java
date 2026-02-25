/*
===========================================
EXERCÍCIO – JAVA FILE (java.io.File)
===========================================

Objetivo:
Praticar a manipulação estrutural de arquivos e diretórios
utilizando a classe File.

Instruções:

1) Crie um diretório chamado "projeto".
   - Verifique antes se ele já existe.
   - Caso não exista, crie utilizando mkdir().

2) Dentro do diretório "projeto", crie um arquivo chamado
   "dados.txt".
   - Utilize createNewFile().
   - Informe no console se o arquivo foi criado ou se já existia.

3) Verifique se o arquivo realmente existe usando exists().
   - Caso exista, exiba:
        • Nome do arquivo (getName())
        • Caminho absoluto (getAbsolutePath())
        • Tamanho em bytes (length())
        • Permissão de leitura (canRead())
        • Permissão de escrita (canWrite())

4) Liste todos os arquivos presentes dentro do diretório "projeto"
   utilizando listFiles().
   - Mostre apenas o nome de cada arquivo.

5) Pergunte ao usuário se deseja excluir o arquivo "dados.txt".
   - Caso o usuário responda "S", exclua usando delete().
   - Informe se a exclusão foi realizada com sucesso.

Regras:
- Utilize apenas a classe java.io.File.
- Não utilize FileWriter, FileReader ou NIO.
- Utilize try/catch para tratar possíveis exceções.

Desafio extra (opcional):
- Após excluir o arquivo, verifique novamente com exists()
  e informe o resultado no console.
*/

import java.io.File;
import java.util.Scanner;

public class JavaFile {
    public static void main(String[] args) {
        try {
            //Criando o diretorio
            File caminho = new File("./projeto");
            if(!caminho.exists()) {
                caminho.mkdir();
            }

            //Criando o arquivo
            File dados = new File(caminho, "dados.txt");
            if(!dados.exists()){
                dados.createNewFile();
                System.out.println("Arquivo e diretorio criado com sucesso.");
                if(dados.exists()){
                    System.out.println("Nome do arquivo: " + dados.getName());
                    System.out.println("Caminho absoluto: " + dados.getAbsolutePath());
                    System.out.println("Tamanho em bytes: " + dados.length());
                    System.out.println("Permissao de leitura: " + dados.canRead());
                    System.out.println("Permissao de escrita: " + dados.canWrite());
                }
            }

            //Listar os arquivos dentro do diretorio
            File[] listaArquivos = caminho.listFiles();

            for(File a : listaArquivos){
                System.out.println(a.getName());
            }

            //Perguntar ao usuário se deseja excluir o arquivo
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nDeseja excluir o arquivo 'dados.txt'? (S/N): ");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("S")) {

                if (dados.delete()) {
                    System.out.println("Arquivo excluído com sucesso.");
                } else {
                    System.out.println("Não foi possível excluir o arquivo.");
                }

                // 🔹 Desafio extra
                System.out.println("Arquivo ainda existe? " + dados.exists());
            }

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

