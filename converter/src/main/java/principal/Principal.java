package principal;

import model.ConverteMoedas;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import services.ConsumoApi;

import java.io.IOException;
import java.util.Scanner;


@SpringBootApplication
public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        while (true){

            System.out.println("************************************************" + "\n" +
                    "Seja bem-vindo/a ao Conversor de Moedas" + "\n" + "\n" +
                    "1) Dólar =>> Peso argentino" + "\n" +
                    "2) Peso argentino =>> Dólar" + "\n" +
                    "3) Dólar =>> Real brasileiro" + "\n" +
                    "4) Real brasileiro =>> Dólar" + "\n" +
                    "5) Dólar =>> Peso colombiano" + "\n" +
                    "6) Peso colombiano =>> Dólar" + "\n" +
                    "7) Sair" + "\n" +
                    "Escolha uma opção válida:" + "\n" +
                    "************************************************"
            );

            if (sc.hasNextInt()) {
                opcao = sc.nextInt();
                sc.nextLine(); // Limpa o buffer
            } else {
                System.out.println("Opção inválida! Escolha entre 1 e 7.");
            }


            if (opcao == 7) {
                System.out.println("Saindo do programa...");
                break;
            }

            System.out.println("Digite o valor que deseja converter: ");
            Long valor = (long) sc.nextDouble();

            //var sigla = sc.nextLine().toUpperCase();

            ConverteMoedas convercoes = new ConverteMoedas();

            convercoes.escolhaMenu(opcao, valor);


        }


        sc.close();
    }
}
