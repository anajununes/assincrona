package model;

public class Endereco {

    private String cidade;
    private String rua;
    private String numero;
    private String cep;

    public Endereco(String cidade, String rua, String numero, String cep) {
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }

    public String getCidade() { return cidade; }
    public String getRua() { return rua; }
    public String getNumero() { return numero; }
    public String getCep() { return cep; }

    @Override
    public String toString() {
        return rua + ", " + numero + " - " + cidade + " (" + cep + ")";
    }
}
