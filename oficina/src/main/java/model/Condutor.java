package model;

public class Condutor {
    private String nome;
    private Veiculo veiculo;

    public Condutor(String nome, Veiculo veiculo) {
        this.nome = nome;
        this.veiculo = veiculo;
    }

    public String getNome() { return nome; }
    public Veiculo getVeiculo() { return veiculo; }

    @Override
    public String toString() {
        return nome + " - " + veiculo.toString();
    }
}
