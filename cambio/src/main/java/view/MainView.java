package view;

import controller.CotacaoController;
import model.Cotacao;
import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CotacaoController controller = new CotacaoController();

        System.out.println("Cotação de Moedas: ");
        System.out.println("Moedas: USD (dólar), EUR (euro), PYG (guarani)");
        System.out.print("Informe o código da moeda desejada: ");
        String codigo = scanner.nextLine().toUpperCase();

        Cotacao cotacao = controller.obterCotacao(codigo);

        if (cotacao != null) {
            System.out.println(cotacao);
        } else {
            System.out.println("Não foi possível obter a cotação para o código informado.");
        }

        scanner.close();
    }
}
