package model;

import javax.swing.*;
import view.*;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Agenda Médica");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            JTabbedPane abas = new JTabbedPane();
            abas.addTab("Consultas Pendentes", new ConsultasPendentesPanel());
            abas.addTab("Consultas Realizadas", new ConsultasRealizadasPanel());
            abas.addTab("Pacientes", new PacientesPanel());

            frame.add(abas);
            frame.setVisible(true);
        });
    }
}
