package mock;

import java.util.HashMap;
import java.util.Map;

public class APIVeiculoMock {
    public static Map<String, String> getDados(String placa) {
        Map<String, String> dados = new HashMap<>();
        dados.put("modelo", "Civic");
        dados.put("marca", "Honda");
        return dados;
    }
}
