import java.util.ArrayList;

public class Libro {
	
	private String titulo;
	private String editor;
	private int paginas;
	private int anyo;
	private ArrayList<String> nombres;
	
	
	public Libro (int anyo, String titulo, String editor, int paginas, ArrayList<String>nombres) {
		
		this.anyo = anyo;
		this.titulo = titulo;
		this.editor = editor;
		this.paginas = paginas;
		this.nombres = nombres;
		
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

	public void print() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("INFO LIBRO\n");
		sb.append("Título: "+titulo+"\n");
		sb.append("Autores: \n");
		sb.append(nombres.get(0)+"\n");
		sb.append(nombres.get(1)+"\n");
		sb.append("Editor: "+editor+"\n");
		sb.append("Páginas: "+paginas+"\n");
		System.out.println(sb);
		
		
	}

}
