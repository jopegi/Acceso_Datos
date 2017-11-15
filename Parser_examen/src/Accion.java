import java.util.ArrayList;

public class Accion {
	
	String nombre;
	ArrayList<Operacion> operaciones;
	
	public Accion(String nombre, ArrayList<Operacion> o) {
		
		this.nombre = nombre;
		operaciones = o;
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
	
	public void print() {
		
		System.out.println("Acción: " + nombre);
		System.out.println();
		System.out.println("\t"+"Operaciones: ");
		
		for (int i = 0; i < operaciones.size();i++){
			System.out.println("\t\t"+"Operación: ");
			System.out.println("\t\t"+"Tipo: "+operaciones.get(i).getTipo());
			System.out.println("\t\t"+"Cantidad: "+operaciones.get(i).getCantidad());
			System.out.println("\t\t"+"Precio: "+operaciones.get(i).getPrecio());
		}
		
		
	}

}
