package view;

import javax.swing.*;
import java.awt.*;

public class ConsultasRealizadasPanel extends JPanel {
    public ConsultasRealizadasPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(new JLabel("Consultas realizadas:"));

        JTextArea area = new JTextArea(10, 40);
        area.setText("Nenhuma consulta realizada.");
        area.setEditable(false);
        add(area);
    }
}
