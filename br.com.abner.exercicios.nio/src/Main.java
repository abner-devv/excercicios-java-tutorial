import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

/*
===========================================
EXERCÍCIO – JAVA NIO (java.nio.file)
===========================================

Objetivo:
Praticar manipulação de arquivos e diretórios
utilizando a API moderna Java NIO (Path e Files).

Instruções:

1) Crie um diretório chamado "relatorios".
   - Utilize Path.of().
   - Verifique se o diretório já existe usando Files.exists().
   - Caso não exista, crie com Files.createDirectory().

2) Dentro do diretório "relatorios", crie um arquivo chamado
   "vendas.txt".
   - Utilize Files.createFile().
   - Verifique antes se o arquivo já existe.

3) Solicite ao usuário que digite:
      • Nome do produto
      • Quantidade vendida
      • Valor unitário

4) Calcule o valor total (quantidade × valor unitário).

5) Grave no arquivo "vendas.txt" no seguinte formato:
      Produto: Notebook
      Quantidade: 3
      Valor Unitário: 2500.00
      Total: 7500.00
   - Utilize Files.writeString() ou Files.write().
   - Utilize a opção StandardOpenOption.APPEND
     para permitir adicionar novos registros.

6) Após gravar, leia todo o conteúdo do arquivo utilizando:
      • Files.readAllLines() ou Files.readString()

7) Exiba o conteúdo completo no console.

Regras:
- Utilize apenas Java NIO (java.nio.file).
- Não utilize FileWriter, BufferedWriter ou FileReader.
- Não utilize a classe java.io.File.
- Utilize try-with-resources ou tratamento de exceção adequado.

Desafio extra (opcional):
- Liste todos os arquivos dentro do diretório "relatorios"
  utilizando Files.list().
- Exiba o caminho absoluto do arquivo criado usando
  path.toAbsolutePath().
*/
public class Main {
    public static void main(String[] args) {
        try{
            Path diretorio = Path.of("./relatorios/");
            Path arquivo = diretorio.resolve("vendas.txt");

            if (!Files.exists(diretorio)) {
                Files.createDirectories(diretorio);
            }

            if (!Files.exists(arquivo)) {
                Files.createFile(arquivo);
            }

            Scanner sc = new Scanner(System.in);
            String nomeProduto = sc.nextLine();
            int quantidadeVendida = sc.nextInt();
            double valorUnitario = sc.nextDouble();
            double valorTotal = quantidadeVendida * valorUnitario;

            String conteudo =
                    "Produto: " + nomeProduto + "\n" +
                    "Quantidade: " + quantidadeVendida + "\n" +
                    "Valor unitario: " + valorUnitario + "\n" +
                    "Total: " + valorTotal + "\n\n";

            Files.write(arquivo, conteudo.getBytes(), StandardOpenOption.APPEND);

            List<String> lerConteudo = Files.readAllLines(arquivo);

            for (String linha : lerConteudo) {
                System.out.println(linha);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}