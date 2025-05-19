package model;

import java.time.LocalDate;

public class Consulta {
    private Paciente paciente;
    private LocalDate dataConsulta;    // Data da consulta
    private LocalDate dataSolicitacao; // Data que foi solicitada
    private boolean realizada;          // Se a consulta aconteceu (true) ou foi cancelada (false)

    public Consulta(Paciente paciente, LocalDate dataConsulta, LocalDate dataSolicitacao, boolean realizada) {
        this.paciente = paciente;
        this.dataConsulta = dataConsulta;
        this.dataSolicitacao = dataSolicitacao;
        this.realizada = realizada;
    }

    public Paciente getPaciente() { return paciente; }
    public LocalDate getDataConsulta() { return dataConsulta; }
    public LocalDate getDataSolicitacao() { return dataSolicitacao; }
    public boolean isRealizada() { return realizada; }

    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public void setDataConsulta(LocalDate dataConsulta) { this.dataConsulta = dataConsulta; }
    public void setDataSolicitacao(LocalDate dataSolicitacao) { this.dataSolicitacao = dataSolicitacao; }
    public void setRealizada(boolean realizada) { this.realizada = realizada; }

    @Override
    public String toString() {
        return "Consulta{" +
                "Paciente=" + paciente.getNome() +
                ", Data Consulta=" + dataConsulta +
                ", Data Solicitação=" + dataSolicitacao +
                ", Realizada=" + (realizada ? "Sim" : "Não") +
                '}';
    }
}
