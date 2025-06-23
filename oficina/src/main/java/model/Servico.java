package model;

import java.time.LocalDate;

public class Servico {
    private String descricao;
    private double valor;
    private LocalDate data;

    public Servico(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = LocalDate.now();
    }

    public String getDescricao() { return descricao; }
    public double getValor() { return valor; }
    public LocalDate getData() { return data; }

    @Override
    public String toString() {
        return data + " - " + descricao + ": R$ " + valor;
    }
}
