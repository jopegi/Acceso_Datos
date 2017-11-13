import java.util.ArrayList;

public class Libro {

	private String titulo;
	private String editor;
	private int paginas;
	private ArrayList<String> nombres;
	
	public Libro(String t,ArrayList<String> n, String e, int p) {
		
		this.titulo = t;
		this.nombres = n;
		this.editor = e;
		this.paginas = p;
	}

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

	public ArrayList<String> getNombres() {
		return nombres;
	}

	public void setNombres(ArrayList<String> nombres) {
		this.nombres = nombres;
	}
	
	public void print() {
		
		System.out.println("Título: "+titulo+"\nEditor: "+editor+"\nPáginas: "+paginas);
		System.out.println("Autor: ");
		for (int i = 0;i<nombres.size();i++) {
			System.out.println(nombres.get(i));
		}
		
	}
	
}
