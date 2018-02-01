
public class Empresa {
	
	private String CIF;
	private String nombre;
	private int empleados;
	private String direccion;
	
	//Constructor de la clase
	public Empresa(String nombre) {

		this.nombre = nombre;
	}

	//Métodos setter y getter
	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEmpleados() {
		return empleados;
	}

	public void setEmpleados(int empleados) {
		this.empleados = empleados;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	//Método toString
	@Override
	public String toString() {
		return "Empresa [CIF=" + CIF + ", nombre=" + nombre + ", empleados=" + empleados + ", direccion=" + direccion
				+ "]";
	}
	
}

