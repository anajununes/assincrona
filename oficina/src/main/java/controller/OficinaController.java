package controller;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class OficinaController {
    private List<Condutor> condutores = new ArrayList<>();

    public void registrarCondutor(Condutor condutor) {
        condutores.add(condutor);
    }

    public void registrarServico(Condutor condutor, Servico servico) {
        Banco.salvarServico(condutor.getVeiculo().getPlaca(), servico.getDescricao(), servico.getValor());
    }

    public void listarCondutores() {
        for (Condutor c : condutores) {
            System.out.println(c);
        }
    }
}
