
public class Operacion {
	
	String tipo;
	int cantidad;
	double precio;
	
	public Operacion (String tipo, int cantidad, double precio) {
		
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.precio = precio;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
