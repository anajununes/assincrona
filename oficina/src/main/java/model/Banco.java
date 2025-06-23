package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.stream.Collectors;

public class Banco {
    private static final String URL = "jdbc:sqlite:oficina.db";

    // Conectar ao banco
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // Executa o create.sql automaticamente
    public static void inicializarBanco() {
        try (Connection conn = conectar()) {
            String sql = lerSQL("create.sql");
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Banco inicializado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao inicializar o banco: " + e.getMessage());
        }
    }

    // Ler conteúdo do arquivo SQL da pasta resources
    private static String lerSQL(String nomeArquivo) throws Exception {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(Banco.class.getClassLoader().getResourceAsStream(nomeArquivo)))) {
            return reader.lines().collect(Collectors.joining("\n"));
        }
    }

    // Salvar serviço
    public static void salvarServico(String placa, String descricao, double valor) {
        String sql = "INSERT INTO servicos (placa, descricao, valor, data) VALUES (?, ?, ?, CURRENT_DATE)";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, placa);
            stmt.setString(2, descricao);
            stmt.setDouble(3, valor);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar serviço: " + e.getMessage());
        }
    }
}
