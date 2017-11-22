package josevi.parser;

import java.util.ArrayList;
import java.util.Iterator;

public class Accion {

	private String nombre;
	private ArrayList<Operacion> operaciones;

	public Accion() {

	}

	public Accion(String nombre) {

	}

	public Accion(String nombre, ArrayList<Operacion> operaciones) {

		this.nombre = nombre;
		this.operaciones = operaciones;

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

		System.out.println("Nombre de la acción: " + nombre);
		System.out.println("Operaciones que la componen: ");

		Iterator it = operaciones.iterator();

		while (it.hasNext()) {

			Operacion o = (Operacion) it.next();
			System.out.println(o.getTipo());
			System.out.println(o.getCantidad());
			System.out.println(o.getPrecio());
		}

	}
}
