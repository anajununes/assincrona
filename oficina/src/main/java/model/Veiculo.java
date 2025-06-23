package model;

public class Veiculo {
    private String placa;
    private String modelo;
    private String marca;

    public Veiculo(String placa, String modelo, String marca) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public String getMarca() { return marca; }

    @Override
    public String toString() {
        return marca + " " + modelo + " - Placa: " + placa;
    }
}
