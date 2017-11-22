package josevi.parser;

public class Operacion {
	
	private String tipo;
	private int cantidad;
	private float precio;
	
	public Operacion(String tipo, int cantidad, float precio) {
		
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.precio = precio;
		
	}
	
	public Operacion() {
		
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	

}
