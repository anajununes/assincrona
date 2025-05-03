package calculadoraimc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraIMC extends JFrame {

    private JTextField campoPeso;
    private JTextField campoAltura;
    private JLabel resultadoLabel;
    private JLabel imagemLabel;

    public CalculadoraIMC() {
        setTitle("Calculadora de IMC");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Peso (kg):"));
        campoPeso = new JTextField(10);
        add(campoPeso);

        add(new JLabel("Altura (m):"));
        campoAltura = new JTextField(10);
        add(campoAltura);

        JButton calcularButton = new JButton("Calcular IMC");
        add(calcularButton);

        resultadoLabel = new JLabel("");
        add(resultadoLabel);

        imagemLabel = new JLabel();
        add(imagemLabel);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        try {
            double peso = Double.parseDouble(campoPeso.getText());
            double altura = Double.parseDouble(campoAltura.getText());
            double imc = peso / (altura * altura);
            String classificacao = "";
            String caminhoImagem = "";

            if (imc < 18.5) {
                classificacao = "Abaixo do peso";
                caminhoImagem = "imagens/abaixo.png";
            } else if (imc < 24.9) {
                classificacao = "Peso normal";
                caminhoImagem = "imagens/normal.png";
            } else if (imc < 29.9) {
                classificacao = "Sobrepeso";
                caminhoImagem = "imagens/sobrepeso.png";
            } else if (imc < 34.9) {
                classificacao = "Obesidade grau I";
                caminhoImagem = "imagens/obesidade1.png";
            } else if (imc < 39.9) {
                classificacao = "Obesidade grau II";
                caminhoImagem = "imagens/obesidade2.png";
            } else {
                classificacao = "Obesidade grau III";
                caminhoImagem = "imagens/obesidade3.png";
            }

            resultadoLabel.setText(String.format("IMC: %.2f - %s", imc, classificacao));

            ImageIcon imagem = new ImageIcon(caminhoImagem);
            imagemLabel.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraIMC tela = new CalculadoraIMC();
            tela.setVisible(true);
        });
    }
}
