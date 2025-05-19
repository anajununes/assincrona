package view;

import javax.swing.*;
import java.awt.*;

public class ConsultasPendentesPanel extends JPanel {
    public ConsultasPendentesPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(new JLabel("Consultas pendentes:"));

        JTextArea area = new JTextArea(10, 40);
        area.setText("Nenhuma consulta pendente.");
        area.setEditable(false);
        add(area);
    }
}
