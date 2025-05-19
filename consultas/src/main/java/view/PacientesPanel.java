package view;

import javax.swing.*;
import java.awt.*;

public class PacientesPanel extends JPanel {
    public PacientesPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(new JLabel("Lista de pacientes:"));

        JTextArea area = new JTextArea(10, 40);
        area.setText("Nenhum paciente cadastrado.");
        area.setEditable(false);
        add(area);
    }
}
