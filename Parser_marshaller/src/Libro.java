import java.util.ArrayList;

public class Libro {
	
	//******************Variables de la clase Libro******************************
	private String titulo;
	private String editor;
	private int paginas;
	private int anyo;
	//ArrayList es una clase que permite almacenar datos en memoria de forma similar a los Arrays, con la ventaja
	//de que nos es necesario declarar su tamaño ya su tamaño se define de forma dinámica
	private ArrayList<String> nombres;
	//****************Fin de las variables de la clase****************************
	
	//*************Constructor de la clase libro********************************
	public Libro(String titulo,ArrayList<String> lista, String e,int p,int anyo) {
		this.titulo=titulo;
		editor=e;
		paginas=p;
		nombres=lista;
		this.anyo=anyo;
	}
	//***********Fin del constructor de la clase********************************
	
	//***********Métodos setter y getter de la clase Libro**********************
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public ArrayList<String> getNombres() {
		return nombres;
	}
	public void setNombres(ArrayList<String> nombres) {
		this.nombres = nombres;
	}
	//************Fin de métodos setter y getter**********************
	
	//****Método para imprimir por consola los datos de un Libro*****
	public void print() {
		
		System.out.println("Titulo: "+titulo+"\nEditor: "+editor+"\nPaginas: "+paginas+
				"\nAnyo: "+anyo);
		System.out.println("Autores: ");
		for(int i=0;i<nombres.size();i++)
			System.out.println(nombres.get(i));
		
	}
	//****Fin método para imprimir por consola los datos de un Libro****
	

}
