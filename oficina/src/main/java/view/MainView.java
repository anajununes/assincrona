package view;

import controller.OficinaController;
import model.*;
import mock.APIVeiculoMock;

import java.util.Map;
import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        // Inicia e cria as tabelas se não existirem
        Banco.inicializarBanco();

        OficinaController controller = new OficinaController();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do condutor: ");
        String nome = scanner.nextLine();

        System.out.print("Placa do veículo: ");
        String placa = scanner.nextLine();

        Map<String, String> dados = APIVeiculoMock.getDados(placa);
        Veiculo veiculo = new Veiculo(placa, dados.get("modelo"), dados.get("marca"));
        Condutor condutor = new Condutor(nome, veiculo);

        controller.registrarCondutor(condutor);

        System.out.print("Descrição do serviço: ");
        String desc = scanner.nextLine();
        System.out.print("Valor do serviço: ");
        double valor = scanner.nextDouble();

        Servico servico = new Servico(desc, valor);
        controller.registrarServico(condutor, servico);

        System.out.println("Serviço registrado com sucesso.");
        controller.listarCondutores();

        scanner.close();
    }
}
