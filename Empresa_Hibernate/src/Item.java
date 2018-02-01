
public class Item {
	

	private String nombre;
	private int cantidad;
	
	//Constructor de la clase
	public Item() {
		
	}
	
	//Constructor de la clase
	public Item(String nombre, int cantidad) {
		
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	//Método setter y getter
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}

