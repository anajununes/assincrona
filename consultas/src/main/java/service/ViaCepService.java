package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class ViaCepService {

	public static JSONObject buscarEndereco(String cep) throws Exception {
        URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder json = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            json.append(inputLine);

        in.close();
        return new JSONObject(json.toString());
    }
}