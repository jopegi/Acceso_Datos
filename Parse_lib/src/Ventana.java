import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	//Declaraci�n de componentes de la ventana
	
	//Contenedor
	private JPanel contentPane;
	//Labels
	private JLabel labelParsear;
	private JLabel labelSerializar;
	private JLabel labelId;
	private JLabel labelTitulo;
	private JLabel labelAutor;
	private JLabel labelAnyo;
	private JLabel labelEditor;
	private JLabel labelPaginas;
	//Cajas de texto
	private JTextField cajaId;
	private JTextField cajaTitulo;
	private JTextField cajaAutor;
	private JTextField cajaAnyo;
	private JTextField cajaEditor;
	private JTextField cajaPaginas;
	private JTextField cajaParsear;
	//Botones
	private JButton botonSerializar;
	private JButton botonParsear;


	/**
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	 **/

	//Constructor de la ventana
	public Ventana() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 443);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Bot�n Parsear
		botonParsear = new JButton("Parsear fichero");
		botonParsear.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonParsear.setForeground(Color.RED);
		botonParsear.setBounds(12, 98, 198, 25);
		contentPane.add(botonParsear);
		
		//ActionListener bot�n Parsear
		botonParsear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		//Bot�n serializar
		botonSerializar = new JButton("Serializar");
		botonSerializar.setForeground(Color.RED);
		botonSerializar.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonSerializar.setBounds(471, 268, 285, 25);
		contentPane.add(botonSerializar);
		
		//ActionListener bot�n serializar
		botonSerializar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		labelParsear = new JLabel("Fichero:");
		labelParsear.setBounds(12, 13, 56, 16);
		contentPane.add(labelParsear);
		
		cajaParsear = new JTextField();
		cajaParsear.setBounds(12, 42, 198, 22);
		contentPane.add(cajaParsear);
		cajaParsear.setColumns(10);
		
		labelSerializar = new JLabel("ATRIBUTOS LIBRO");
		labelSerializar.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelSerializar.setBounds(316, 13, 168, 16);
		contentPane.add(labelSerializar);
		
		cajaId = new JTextField();
		cajaId.setBounds(471, 42, 285, 22);
		contentPane.add(cajaId);
		cajaId.setColumns(10);
		
		cajaTitulo = new JTextField();
		cajaTitulo.setColumns(10);
		cajaTitulo.setBounds(471, 77, 285, 22);
		contentPane.add(cajaTitulo);
		
		cajaAutor = new JTextField();
		cajaAutor.setColumns(10);
		cajaAutor.setBounds(471, 112, 285, 22);
		contentPane.add(cajaAutor);
		
		cajaAnyo = new JTextField();
		cajaAnyo.setColumns(10);
		cajaAnyo.setBounds(471, 147, 285, 22);
		contentPane.add(cajaAnyo);
		
		cajaEditor = new JTextField();
		cajaEditor.setColumns(10);
		cajaEditor.setBounds(471, 182, 285, 22);
		contentPane.add(cajaEditor);
		
		cajaPaginas = new JTextField();
		cajaPaginas.setColumns(10);
		cajaPaginas.setBounds(471, 217, 285, 22);
		contentPane.add(cajaPaginas);
		

		
		labelId = new JLabel("Id:");
		labelId.setBounds(356, 45, 99, 16);
		contentPane.add(labelId);
		
		labelTitulo = new JLabel("T\u00EDtulo:");
		labelTitulo.setBounds(356, 80, 99, 16);
		contentPane.add(labelTitulo);
		
		labelAutor = new JLabel("Autor:");
		labelAutor.setBounds(356, 115, 99, 16);
		contentPane.add(labelAutor);
		
		labelAnyo = new JLabel("A\u00F1o:");
		labelAnyo.setBounds(356, 150, 99, 16);
		contentPane.add(labelAnyo);
		
		labelEditor = new JLabel("Editor:");
		labelEditor.setBounds(356, 185, 99, 16);
		contentPane.add(labelEditor);
		
		labelPaginas = new JLabel("P\u00E1ginas:");
		labelPaginas.setBounds(356, 220, 99, 16);
		contentPane.add(labelPaginas);
	}

	//M�todos setter & getter
	
	public JTextField getCajaParsear() {
		return cajaParsear;
	}

	public void setCajaParsear(JTextField cajaParsear) {
		this.cajaParsear = cajaParsear;
	}

	public JButton getBotonParsear() {
		return botonParsear;
	}

	public void setBotonParsear(JButton botonParsear) {
		this.botonParsear = botonParsear;
	}

	public JTextField getCajaId() {
		return cajaId;
	}

	public void setCajaId(JTextField cajaId) {
		this.cajaId = cajaId;
	}

	public JTextField getCajaTitulo() {
		return cajaTitulo;
	}

	public void setCajatitulo(JTextField cajatitulo) {
		this.cajaTitulo = cajatitulo;
	}

	public JTextField getCajaAutor() {
		return cajaAutor;
	}

	public void setCajaAutor(JTextField cajaAutor) {
		this.cajaAutor = cajaAutor;
	}

	public JTextField getCajaAnyo() {
		return cajaAnyo;
	}

	public void setCajaAnyo(JTextField cajaAnyo) {
		this.cajaAnyo = cajaAnyo;
	}

	public JTextField getCajaEditor() {
		return cajaEditor;
	}

	public void setCajaEditor(JTextField cajaEditor) {
		this.cajaEditor = cajaEditor;
	}

	public JTextField getCajaPaginas() {
		return cajaPaginas;
	}

	public void setCajaPaginas(JTextField cajaPaginas) {
		this.cajaPaginas = cajaPaginas;
	}

	public JButton getBotonSerializar() {
		return botonSerializar;
	}

	public void setBotonSerializar(JButton botonSerializar) {
		this.botonSerializar = botonSerializar;
	}
	
	
}
