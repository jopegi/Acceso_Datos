import java.util.ArrayList;

public class Accion {

	String nombre;
	ArrayList<Operacion> operaciones = new ArrayList<Operacion>();
	
	public Accion() {
		
	}
	
	public Accion(String n, ArrayList<Operacion> o) {
		nombre=n;
		operaciones=o;
	}
	
	public Accion(String n) {
		nombre=n;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Operacion> getOperaciones() {
		return operaciones;
	}
	public void setOperaciones(ArrayList<Operacion> operaciones) {
		this.operaciones = operaciones;
	}

	

}
