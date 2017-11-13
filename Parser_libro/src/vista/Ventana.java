package vista;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	
	private JTextArea textArea;
	private JTextField fichero1;
	private JLabel lblFichero;
	private JPanel panel;
	private JButton botonParsear;


	public Ventana() {
		
		setBounds(200,200,973,613);
		setTitle("Proyecto Buffers");	
		panel = new JPanel();
		
		
					
		fichero1 = new JTextField("",10);
		fichero1.setBounds(75, 13, 140, 22);
		
		
		lblFichero = new JLabel("Fichero:");
		lblFichero.setBounds(12, 16, 58, 16);
		

		textArea = new JTextArea(20, 80);
		textArea.setBounds(268,29,644,364);
		textArea.setEditable(false);		
		panel.setLayout(null);
		

		panel.add(lblFichero);
		panel.add(fichero1);
		panel.add(textArea);


		
        // Añadimos el JPanel al JFrame
        this.getContentPane().add(panel);		
        
        
        JButton botonParsear = new JButton("Parsear xml");
        botonParsear.setBounds(12, 44, 203, 25);
        panel.add(botonParsear);
      
	}
	
	
	//Métodos setter y getter de los elementos de la venatana
	
	public JTextArea getTextArea() {
		return textArea;
	}
	
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
			
	public JTextField getFichero1() {
		return fichero1;
	}

	public void setFichero1(JTextField fichero1) {
		this.fichero1 = fichero1;
	}

	
	public void setBotonParsear(JButton parsear) {
		this.botonParsear = parsear;
		
	}
	
	public JButton getBotonParsear() {
		return botonParsear;
	}
	
	
	
	public void showError(String m) {
		JOptionPane.showMessageDialog(this.panel, m, "Error", JOptionPane.ERROR_MESSAGE);
	}
}