package controller;

import model.Cotacao;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CotacaoController {

    public Cotacao obterCotacao(String codigoMoeda) {
        try {
            String urlStr = "https://economia.awesomeapi.com.br/json/last/" + codigoMoeda + "-BRL";
            URL url = new URL(urlStr);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            StringBuilder resposta = new StringBuilder();
            String linha;

            while ((linha = reader.readLine()) != null) {
                resposta.append(linha);
            }
            reader.close();

            JSONObject json = new JSONObject(resposta.toString());
            JSONObject moedaObj = json.getJSONObject(codigoMoeda + "BRL");
            double valor = moedaObj.getDouble("bid");

            return new Cotacao(codigoMoeda, valor);
        } catch (Exception e) {
            System.out.println("Erro ao obter cotação: " + e.getMessage());
            return null;
        }
    }
}
