
public class Operacion {
	
	private String tipo;
	private String cantidad;
	private String precio;
	
	public Operacion() {
		
	}
	
	public Operacion(String t, String c, String p) {
		tipo=t;
		cantidad=c;
		precio=p;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	

}
