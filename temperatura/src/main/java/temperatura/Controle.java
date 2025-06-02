package temperatura;

import java.util.Scanner;

public class Controle {

	public static void main(String[] args) {
	        final double TEMP_MINIMA = 18.0;
	        final double TEMP_MAXIMA = 30.0;
	        double[] temperaturas = new double[24];

	        Scanner scanner = new Scanner(System.in);
	        double soma = 0;
	        int acimaMax = 0;
	        int abaixoMin = 0;
	        double menor = Double.MAX_VALUE;
	        double maior = Double.MIN_VALUE;

	        System.out.println("Sistema Para controle de Temperatura da Estufa");
	        System.out.println("Informe abaixo as temperaturas registradas últimas 24 horas:");

	        for (int i = 1; i <= 24; i++) {
	            System.out.print("Hora " + i + ": ");
	            temperaturas[i] = scanner.nextDouble();
	            soma += temperaturas[i];

	            if (temperaturas[i] > TEMP_MAXIMA) {
	                acimaMax++;
	                System.out.println("Alerta: temperatura acima do máximo permitido");
	            } else if (temperaturas[i] < TEMP_MINIMA) {
	            			abaixoMin++;
	                System.out.println("Alerta: temperatura abaixo do mínimo permitido");
	            }

	            if (temperaturas[i] < menor) {
	                menor = temperaturas[i];
	            }
	            if (temperaturas[i] > maior) {
	                maior = temperaturas[i];
	            }
	        }

	        double media = soma / 24;

	        System.out.println("\n Relatório:");
	        System.out.printf("Temperatura média: %.2f °C%n", media);
	        System.out.println("Temperaturas acima do limite máximo: " + acimaMax);
	        System.out.println("Temperaturas abaixo do limite mínimo: " + abaixoMin);
	        System.out.printf("Menor temperatura registrada: %.2f °C%n", menor);
	        System.out.printf("Maior temperatura registrada: %.2f °C%n", maior);

	        scanner.close();
	    }

}
