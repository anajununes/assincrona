package agenda;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class AgendaTelefonica extends JFrame {

    private JTextField nomeField;
    private JTextField telefoneField;
    private JTextArea listaContatos;
    private List<String> contatos;

    public AgendaTelefonica() {
        setTitle("Agenda Telefônica");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        contatos = new ArrayList<>();

        // Painel principal
        JPanel painel = new JPanel(new BorderLayout());

        // Painel de entrada
        JPanel painelEntrada = new JPanel(new GridLayout(3, 2, 5, 5));
        painelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        painelEntrada.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        painelEntrada.add(nomeField);

        painelEntrada.add(new JLabel("Telefone:"));
        telefoneField = new JTextField();
        painelEntrada.add(telefoneField);

        JButton adicionarButton = new JButton("Adicionar");
        painelEntrada.add(adicionarButton);

        // Espaço vazio para alinhar botão
        painelEntrada.add(new JLabel());

        painel.add(painelEntrada, BorderLayout.NORTH);

        // Área de texto para exibir os contatos
        listaContatos = new JTextArea();
        listaContatos.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listaContatos);
        painel.add(scrollPane, BorderLayout.CENTER);

        // Ação do botão
        adicionarButton.addActionListener(e -> adicionarContato());

        add(painel);
        setVisible(true);
    }

    private void adicionarContato() {
        String nome = nomeField.getText().trim();
        String telefone = telefoneField.getText().trim();

        if (nome.isEmpty() || telefone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha o nome e o telefone.");
            return;
        }

        String contato = nome + " - " + telefone;
        contatos.add(contato);
        atualizarLista();
        nomeField.setText("");
        telefoneField.setText("");
    }

    private void atualizarLista() {
        StringBuilder sb = new StringBuilder();
        for (String c : contatos) {
            sb.append("- ").append(c).append("\n");
        }
        listaContatos.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AgendaTelefonica::new);
    }
}

