package view;

import java.awt.Dimension;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class LaunchView extends JFrame {

	private JButton comparar,buscar,ordenar,copiar,rotar90, especular, guardar, recuperar, recuperarTodos, modificar,mostrar_palabras;
	private JTextArea textArea;
	private JTextField fichero1,fichero2,palabra,fichero3,fichero4,fichero5,fichero6,fichero7,fichero8,fichero9,fichero10,fichero11,fichero12,fichero13,
	fichero14,fichero15,fichero16,fichero17,fichero18, fichero19,fichero20;
	private JLabel label_f1,lblLongitud,lbl_f3,lbl_f4,lbl_f5,lbl_f6,lbl_f7,lbl_f8,lbl_f9,lbl_f10,lbl_f11,lbl_f12,lbl_f13,lbl_f14,lbl_f15,lbl_f16,lbl_f17,lbl_f18,
	lbl_f21,lbl_f22, mostrarCoincidencias;
	private JCheckBox primera;
	private JRadioButton RBOrden;
	private JPanel panel;


	public LaunchView() {
		
		setBounds(200,200,1229,613);
		setTitle("Proyecto Buffers");	
		panel = new JPanel();
		
		RBOrden=new JRadioButton("Orden Ascendente",true);
		RBOrden.setBounds(8, 218, 133, 25);
		comparar = new JButton("Palabra + larga");
		comparar.setBounds(12, 80, 150, 26);
		comparar.setPreferredSize(new Dimension(150, 26));
		buscar = new JButton("Buscar palabra");
		buscar.setBounds(12, 401, 150, 26);
		buscar.setPreferredSize(new Dimension(150, 26));
		ordenar = new JButton("Ordenar palabras");
		ordenar.setBounds(12, 252, 150, 26);
		ordenar.setPreferredSize(new Dimension(150, 26));
					
		fichero1 = new JTextField("",10);
		fichero1.setBounds(75, 13, 116, 22);
		fichero2 = new JTextField("",10);
		fichero2.setBounds(75, 45, 116, 22);
		palabra = new JTextField("",10);
		palabra.setBounds(65, 339, 116, 22);
		
		label_f1 = new JLabel("Fichero 1:");
		label_f1.setBounds(12, 16, 58, 16);
		lblLongitud = new JLabel("Longitud:");
		lblLongitud.setBounds(12, 48, 58, 16);
		lbl_f6 = new JLabel("Palabra:");
		lbl_f6.setBounds(12, 342, 48, 16);
		
		primera = new JCheckBox("Primera aparición");
		primera.setBounds(12, 367, 129, 25);

		textArea = new JTextArea(20, 80);
		textArea.setBounds(235,45,644,364);
		textArea.setEditable(false);		
		panel.setLayout(null);
		
		panel.add(comparar);
		panel.add(buscar);
		panel.add(ordenar);
		panel.add(label_f1);
		panel.add(fichero1);
		panel.add(lblLongitud);
		panel.add(fichero2);
		panel.add(lbl_f6);
		panel.add(palabra);
		panel.add(primera);
		panel.add(textArea);
		panel.add(RBOrden);

		
        // Añadimos el JPanel al JFrame
        this.getContentPane().add(panel);		
        
        lbl_f3 = new JLabel("Fichero or\u00EDgen:");
        lbl_f3.setBounds(12, 130, 104, 16);
        panel.add(lbl_f3);
        
        fichero3 = new JTextField("", 10);
        fichero3.setBounds(12, 148, 179, 22);
        panel.add(fichero3);
        
        lbl_f4 = new JLabel("Fichero destino:");
        lbl_f4.setBounds(12, 172, 104, 16);
        panel.add(lbl_f4);
        
        fichero4 = new JTextField("", 10);
        fichero4.setBounds(12, 189, 179, 22);
        panel.add(fichero4);
        
        fichero5 = new JTextField("", 10);
        fichero5.setBounds(106, 310, 124, 22);
        panel.add(fichero5);
        
        lbl_f5 = new JLabel("Fichero \r\nor\u00EDgen:");
        lbl_f5.setBounds(12, 313, 93, 16);
        panel.add(lbl_f5);
        
        fichero6 = new JTextField("", 10);
        fichero6.setBounds(891, 42, 143, 22);
        panel.add(fichero6);
        
        fichero7 = new JTextField("", 10);
        fichero7.setBounds(891, 90, 143, 22);
        panel.add(fichero7);
        
        lbl_f7 = new JLabel("Fichero or\u00EDgen:");
        lbl_f7.setBounds(891, 19, 98, 16);
        panel.add(lbl_f7);
        
        lbl_f8 = new JLabel("Fichero destino:");
        lbl_f8.setBounds(891, 69, 98, 16);
        panel.add(lbl_f8);
        
        copiar = new JButton("Copiar fichero");
        copiar.setPreferredSize(new Dimension(150, 26));
        copiar.setBounds(901, 125, 116, 26);
        panel.add(copiar);
        
        lbl_f9 = new JLabel("Imagen or\u00EDgen:");
        lbl_f9.setBounds(891, 186, 98, 16);
        panel.add(lbl_f9);
        
        fichero8 = new JTextField("", 10);
        fichero8.setBounds(891, 209, 143, 22);
        panel.add(fichero8);
        
        lbl_f10 = new JLabel("Imagen destino:");
        lbl_f10.setBounds(891, 236, 98, 16);
        panel.add(lbl_f10);
        
        fichero9 = new JTextField("", 10);
        fichero9.setBounds(891, 257, 143, 22);
        panel.add(fichero9);
        
        rotar90 = new JButton("Rotar 90\u00BA");
        rotar90.setPreferredSize(new Dimension(150, 26));
        rotar90.setBounds(901, 292, 116, 26);
        panel.add(rotar90);
        
        especular = new JButton("Giro especular");
        especular.setPreferredSize(new Dimension(150, 26));
        especular.setBounds(901, 332, 116, 26);
        panel.add(especular);
        
        lbl_f11 = new JLabel("INSERTAR DATOS LIBRO");
        lbl_f11.setBounds(245, 422, 150, 16);
        panel.add(lbl_f11);
        
        lbl_f12 = new JLabel("T\u00EDtulo:");
        lbl_f12.setBounds(235, 451, 98, 16);
        panel.add(lbl_f12);
        
        fichero10 = new JTextField("", 10);
        fichero10.setBounds(235, 474, 302, 22);
        panel.add(fichero10);
        
        lbl_f13 = new JLabel("Autor:");
        lbl_f13.setBounds(235, 505, 98, 16);
        panel.add(lbl_f13);
        
        fichero11 = new JTextField("", 10);
        fichero11.setBounds(235, 528, 302, 22);
        panel.add(fichero11);
        
        lbl_f14 = new JLabel("A\u00F1o:");
        lbl_f14.setBounds(573, 451, 98, 16);
        panel.add(lbl_f14);
        
        fichero12 = new JTextField("", 10);
        fichero12.setBounds(573, 474, 82, 22);
        panel.add(fichero12);
        
        lbl_f15 = new JLabel("Editor:");
        lbl_f15.setBounds(573, 505, 98, 16);
        panel.add(lbl_f15);
        
        fichero13 = new JTextField("", 10);
        fichero13.setBounds(573, 528, 143, 22);
        panel.add(fichero13);
        
        lbl_f16 = new JLabel("P\u00E1ginas:");
        lbl_f16.setBounds(683, 451, 98, 16);
        panel.add(lbl_f16);
        
        fichero14 = new JTextField("", 10);
        fichero14.setBounds(683, 474, 66, 22);
        panel.add(fichero14);
        
        guardar =new JButton("Guardar libro");
        guardar.setPreferredSize(new Dimension(150, 26));
        guardar.setBounds(761, 472, 133, 26);
        panel.add(guardar);
        
        recuperar = new JButton("Recuperar libro");
        recuperar.setPreferredSize(new Dimension(150, 26));
        recuperar.setBounds(901, 466, 133, 26);
        panel.add(recuperar);
        
        recuperarTodos = new JButton("Recuperar libros");
        recuperarTodos.setPreferredSize(new Dimension(150, 26));
        recuperarTodos.setBounds(763, 526, 133, 26);
        panel.add(recuperarTodos);
        
        fichero15 = new JTextField("", 10);
        fichero15.setBounds(901, 430, 133, 22);
        panel.add(fichero15);
        
        lbl_f17 = new JLabel("Id libro a recuperar:");
        lbl_f17.setBounds(901, 401, 132, 16);
        panel.add(lbl_f17);
        
        fichero16 = new JTextField("", 10);
        fichero16.setForeground(Color.ORANGE);
        fichero16.setEnabled(false);
        fichero16.setEditable(false);
        fichero16.setBounds(93, 499, 82, 22);
        panel.add(fichero16);
        
        lbl_f18 = new JLabel("Id libro:");
        lbl_f18.setBounds(93, 476, 98, 16);
        panel.add(lbl_f18);
        
        JLabel lbl_f19 = new JLabel("Libro a modificar:");
        lbl_f19.setBounds(1046, 401, 143, 16);
        panel.add(lbl_f19);
        
        fichero17 = new JTextField("", 10);
        fichero17.setBounds(1046, 424, 143, 22);
        panel.add(fichero17);
        
        JLabel lbl_f20 = new JLabel("Nuevo autor:");
        lbl_f20.setBounds(1046, 451, 98, 16);
        panel.add(lbl_f20);
        
        fichero18 = new JTextField("", 10);
        fichero18.setBounds(1046, 472, 143, 22);
        panel.add(fichero18);
        
        modificar = new JButton("Modificar autor");
        modificar.setPreferredSize(new Dimension(150, 26));
        modificar.setBounds(1046, 505, 133, 26);
        panel.add(modificar);
        
        lbl_f21 = new JLabel("Fichero:");
        lbl_f21.setBounds(1046, 21, 143, 16);
        panel.add(lbl_f21);
        
        fichero19 = new JTextField("", 10);
        fichero19.setBounds(1046, 45, 143, 22);
        panel.add(fichero19);
        
        lbl_f22 = new JLabel("Longitud palabra:");
        lbl_f22.setBounds(1046, 71, 143, 16);
        panel.add(lbl_f22);
        
        fichero20 = new JTextField("", 10);
        fichero20.setBounds(1046, 92, 143, 22);
        panel.add(fichero20);
        
        mostrar_palabras = new JButton("Mostrar coincidencias");
        mostrar_palabras.setPreferredSize(new Dimension(150, 26));
        mostrar_palabras.setBounds(1046, 125, 133, 26);
        panel.add(mostrar_palabras);
        
        mostrarCoincidencias = new JLabel("");
        mostrarCoincidencias.setFont(new Font("Tahoma", Font.BOLD, 14));
        mostrarCoincidencias.setForeground(Color.RED);
        mostrarCoincidencias.setBounds(1056, 172, 123, 30);
        panel.add(mostrarCoincidencias);
		
	}	
	
	public JButton getComparar() {
		return comparar;
	}

	public void setComparar(JButton comparar) {
		this.comparar = comparar;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}

	
	//****Añadimos los métodos set y get correspondientes al nuevo botón ordenar******
	
	public JButton getOrdenar() {
		return ordenar;
	}


	public void setOrdenar(JButton ordenar) {
		this.ordenar = ordenar;
	}

	//*******************************************************************************
	
	//****Añadimos los métodos get correspondientes a los nuevos Radio Button******

	public int getRBOrden() {

		int orden = 0;

		
		if (RBOrden.isSelected()) {

			orden = 1;
		}
		
		return orden;

	}

		//*******************************************************************************
	
	//****Añadimos los métodos set y get correspondientes al nuevo botón copiar******
	
		public JButton getCopiar() {
			return copiar;
		}


		public void setCopiar(JButton copiar) {
			this.copiar = copiar;
		}

	//*******************************************************************************
		
	//****Añadimos los métodos set y get correspondientes al nuevo botón rotar90******
		
		public JButton getRotar90() {
			return rotar90;
		}


		public void setRotar90(JButton rotar90) {
			this.rotar90 = rotar90;
		}

	//*******************************************************************************
		
	// ****Añadimos los métodos set y get correspondientes al nuevo botón especular******

	public JButton getEspecular() {
		return especular;
	}

	public void setEspecular(JButton especular) {
		this.especular = especular;
	}

	// *******************************************************************************
	
	// ****Añadimos los métodos set y get correspondientes al nuevo botón guardar******

		public JButton getGuardar() {
			return guardar;
		}

		public void setGuardar(JButton guardar) {
			this.guardar = guardar;
		}

		// *******************************************************************************
		
		// ****Añadimos los métodos set y get correspondientes al nuevo botón recuperar******

		public JButton getRecuperar() {
			return recuperar;
		}

		public void setRecuperar(JButton recuperar) {
			this.recuperar = recuperar;
		}

		// *******************************************************************************
		
		// ****Añadimos los métodos set y get correspondientes al nuevo botón recuperarTodos******

		public JButton getRecuperarTodos() {
			return recuperarTodos;
		}

		public void setRecuperarTodos(JButton recuperarTodos) {
			this.recuperarTodos = recuperarTodos;
		}

		// *******************************************************************************
		
		
		//****ACTIVIDAD 1 EXÁMEN*************************************************************
		// ****Añadimos los métodos set y get correspondientes al nuevo botón modificar******

		public JButton getModificar() {
			return modificar;
		}

		public void setModificar(JButton modificar) {
			this.modificar = modificar;
		}

		// *******************************************************************************
		
		//****ACTIVIDAD 2 EXÁMEN*************************************************************
		// ****Añadimos los métodos set y get correspondientes al nuevo botón mostrar_palabras******

		public JButton getMostrar_palabras() {
			return mostrar_palabras;
		}

		public void setMostrar_palabras(JButton mostrar_palabras) {
			this.mostrar_palabras = mostrar_palabras;
		}

		// *******************************************************************************
	
	
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

	public JTextField getFichero2() {
		return fichero2;
	}

	public void setFichero2(JTextField fichero2) {
		this.fichero2 = fichero2;
	}
	
	public JTextField getFichero3() {
		return fichero3;
	}
	
	public void setFichero3(JTextField fichero3) {
		this.fichero3 = fichero3;
	}
	
	public JTextField getFichero4() {
		return fichero4;
	}
	
	public void setFichero4(JTextField fichero4) {
		this.fichero4 = fichero4;
	}
	
	public JTextField getFichero5() {
		return fichero5;
	}
	
	public void setFichero5(JTextField fichero5) {
		this.fichero5 = fichero5;
	}
	
	public JTextField getFichero6() {
		return fichero6;
	}
	
	public void setFichero6(JTextField fichero6) {
		this.fichero6 = fichero6;
	}
	
	public JTextField getFichero7() {
		return fichero7;
	}
	
	public void setFichero7(JTextField fichero7) {
		this.fichero7 = fichero7;
	}
	
	public JTextField getFichero8() {
		return fichero8;
	}
	
	public void setFichero8(JTextField fichero8) {
		this.fichero8 = fichero8;
	}
	
	public JTextField getFichero9() {
		return fichero9;
	}
	
	public void setFichero9(JTextField fichero9) {
		this.fichero9 = fichero9;
	}
	
	public JTextField getFichero10() {
		return fichero10;
	}
	
	public void setFichero10(JTextField fichero10) {
		this.fichero10 = fichero10;
	}
	
	public JTextField getFichero11() {
		return fichero11;
	}
	
	public void setFichero11(JTextField fichero11) {
		this.fichero11 = fichero11;
	}
	
	public JTextField getFichero12() {
		return fichero12;
	}
	
	public void setFichero12(JTextField fichero12) {
		this.fichero12 = fichero12;
	}
	
	public JTextField getFichero13() {
		return fichero13;
	}
	
	public void setFichero13(JTextField fichero13) {
		this.fichero13 = fichero13;
	}
	
	public JTextField getFichero14() {
		return fichero14;
	}
	
	public void setFichero14(JTextField fichero14) {
		this.fichero14 = fichero14;
	}
	
	public JTextField getFichero15() {
		return fichero15;
	}
	
	public void setFichero15(JTextField fichero15) {
		this.fichero15 = fichero15;
	}
	
	public JTextField getFichero16() {
		return fichero16;
	}
	
	public void setFichero16(JTextField fichero16) {
		this.fichero16 = fichero16;
	}
	
	//ACTIVIDAD 1 EXÁMEN - DEFINIR LOS MÉTODOS SETTER Y GETTER DE LOS NUEVOS JTEXTFIELDS
	public JTextField getFichero17() {
		return fichero17;
	}
	
	public void setFichero17(JTextField fichero17) {
		this.fichero17 = fichero17;
	}
	
	public JTextField getFichero18() {
		return fichero18;
	}
	
	public void setFichero18(JTextField fichero18) {
		this.fichero18 = fichero18;
	}
	
	//ACTIVIDAD 2 EXÁMEN - DEFINIR LOS MÉTODOS SETTER Y GETTER DE LOS NUEVOS JTEXTFIELDS
		public JTextField getFichero19() {
			return fichero19;
		}
		
		public void setFichero19(JTextField fichero19) {
			this.fichero19 = fichero19;
		}
		
		public JTextField getFichero20() {
			return fichero20;
		}
		
		public void setFichero20(JTextField fichero20) {
			this.fichero20 = fichero20;
		}
	
	
	//Métodos setter y getter para palabra y primera
	
	public JTextField getPalabra() {
		return palabra;
	}

	public void setPalabra(JTextField palabra) {
		this.palabra = palabra;
	}

	public JCheckBox getPrimera() {
		return primera;
	}
	

	public void setPrimera(JCheckBox primera) {
		this.primera = primera;
	}

	//********************************************
	
	public JLabel getMostrarCoincidencias() {
		return mostrarCoincidencias;
	}

	public void setMostrarCoincidencias(JLabel mostrarCoincidencias) {
		this.mostrarCoincidencias = mostrarCoincidencias;
	}
	
	//********************************************
	
	
	public void showError(String m) {
		JOptionPane.showMessageDialog(this.panel, m, "Error", JOptionPane.ERROR_MESSAGE);
	}


}

