package model;

public class Cotacao {
    private String moeda;
    private double valor;

    public Cotacao(String moeda, double valor) {
        this.moeda = moeda;
        this.valor = valor;
    }

    public String getMoeda() {
        return moeda;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Cotação atual de " + moeda + ": R$ " + String.format("%.4f", valor);
    }
}
