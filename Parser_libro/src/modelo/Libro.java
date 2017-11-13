package modelo;

import java.io.Serializable;


public class Libro implements Serializable{
	
	//Declaraci�n de variables 
	private int id;
	private String titulo;
	private String autor;
	private int anyoPubli;
	private String editor;
	private int numPaginas;
	
	//************************CONSTRUCTORES DE LA CLASE************************************************************
	// CONSTRUCTOR 1
	public Libro() {}

	// CONSTRUCTOR 2
	public Libro(int id,String titulo, String autor, int anyo, String editor, int numpag) {

		this.id=id;
		this.titulo = titulo;
		this.autor = autor;
		this.anyoPubli = anyo;
		this.editor = editor;
		this.numPaginas = numpag;
	}
	//************************FIN CONSTRUCTORES CLASE*************************************************************	
	
	//************************M�TODOS SETTER Y GETTER*************************************************************
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnyoPubli() {
		return anyoPubli;
	}

	public void setAnyoPubli(int anyoPubli) {
		this.anyoPubli = anyoPubli;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	
	//************************************************************************************************************
	
	
	//************************M�TODOS****************************************************************************
	//M�todo para imprimir por pantalla la info de los libros
	public void printInfo() {
		System.out.println("Id:	" + id);
		System.out.println("T�tulo:	" + titulo);
		System.out.println("Autor: " + autor);
		System.out.println("A�o de publicaci�n: " + anyoPubli);
		System.out.println("Editor: " + editor);
		System.out.println("N�mero de p�ginas: " + numPaginas);
		System.out.println();	
	}
	
	
}

