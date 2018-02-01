
public class Usuario {
	
	private int id;
	private String nombre;
	
	public Usuario(String n) {
		
		nombre = n;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
