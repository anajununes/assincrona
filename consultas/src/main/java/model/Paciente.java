package model;

public class Paciente {

    private String nome;
    private String email;
    private String telefone;
    private Endereco endereco;

    public Paciente(String nome, String email, String telefone, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public Endereco getEndereco() { return endereco; }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Email: " + email + ", Tel: " + telefone + ", Endereço: " + endereco.toString();
    }
}
