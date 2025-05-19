package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import model.Consulta;
import model.Endereco;
import model.Paciente;


public class ListaConsultasFrame extends JFrame{

	private DefaultListModel<Consulta> modelo;
	private List<Consulta> consultas;

	public ListaConsultasFrame() {
	    setTitle("Consulta Pendentes");
	    setSize(500, 400);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);

	    consultas = new ArrayList<>();

	    // Exemplo com paciente fictício
	    Endereco end = new Endereco("São Paulo", "Rua A", "123", "01001000");
	    Paciente p = new Paciente("João", "joao@gmail.com", "11999999999", end);
	    consultas.add(new Consulta(p, LocalDate.now().plusDays(2), LocalDate.now(), false));

	    modelo = new DefaultListModel<>();
	    atualizarLista();

	    JList<Consulta> lista = new JList<>(modelo);
	    JScrollPane scroll = new JScrollPane(lista);
	    add(scroll);

	    setVisible(true);
	}

	private void atualizarLista() {
	    modelo.clear();
	    for (Consulta c : consultas) {
	        if (!c.isRealizada()) {
	            modelo.addElement(c);
	        }
	    }
	}
}
