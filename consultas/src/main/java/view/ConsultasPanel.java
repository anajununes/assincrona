package view;

import model.Consulta;
import model.Paciente;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConsultasPanel extends JPanel {
    private JComboBox<Paciente> pacienteCombo;
    private JTextField dataConsultaField;
    private JTextField dataSolicitacaoField;
    private JCheckBox realizadaCheck;

    private JTextArea listaArea;
    private List<Consulta> consultas = new ArrayList<>();
    private List<Paciente> pacientes; // Recebe a lista de pacientes do sistema

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ConsultasPanel(List<Paciente> pacientes) {
        this.pacientes = pacientes;

        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(5, 2, 5, 5));
        form.setBorder(BorderFactory.createTitledBorder("Cadastro de Consulta"));

        pacienteCombo = new JComboBox<>();
        for (Paciente p : pacientes) {
            pacienteCombo.addItem(p);
        }
        pacienteCombo.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Paciente) {
                    value = ((Paciente) value).getNome();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });

        dataConsultaField = new JTextField();
        dataSolicitacaoField = new JTextField();
        realizadaCheck = new JCheckBox("Consulta realizada?");

        form.add(new JLabel("Paciente:"));
        form.add(pacienteCombo);
        form.add(new JLabel("Data da Consulta (dd/MM/yyyy):"));
        form.add(dataConsultaField);
        form.add(new JLabel("Data da Solicitação (dd/MM/yyyy):"));
        form.add(dataSolicitacaoField);
        form.add(new JLabel(""));
        form.add(realizadaCheck);

        JButton salvarBtn = new JButton("Salvar Consulta");
        form.add(salvarBtn);

        listaArea = new JTextArea(10, 50);
        listaArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(listaArea);

        add(form, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        salvarBtn.addActionListener(e -> salvarConsulta());
        atualizarLista();
    }

    private void salvarConsulta() {
        Paciente paciente = (Paciente) pacienteCombo.getSelectedItem();
        String dataConsultaStr = dataConsultaField.getText().trim();
        String dataSolicitacaoStr = dataSolicitacaoField.getText().trim();
        boolean realizada = realizadaCheck.isSelected();

        if (paciente == null || dataConsultaStr.isEmpty() || dataSolicitacaoStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!");
            return;
        }

        try {
            LocalDate dataConsulta = LocalDate.parse(dataConsultaStr, formatter);
            LocalDate dataSolicitacao = LocalDate.parse(dataSolicitacaoStr, formatter);

            Consulta consulta = new Consulta(paciente, dataConsulta, dataSolicitacao, realizada);
            consultas.add(consulta);
            atualizarLista();
            limparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Formato de data inválido. Use dd/MM/yyyy.");
        }
    }

    public void atualizarLista() {
        listaArea.setText("");
        for (Consulta c : consultas) {
            listaArea.append(c.toString() + "\n");
        }
    }

    private void limparCampos() {
        dataConsultaField.setText("");
        dataSolicitacaoField.setText("");
        realizadaCheck.setSelected(false);
    }
}
