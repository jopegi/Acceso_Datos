package josevi.parser;

import java.util.ArrayList;
import java.util.Iterator;

public class Accion {

	private String nombre;
	private ArrayList<Operacion> operaciones;

	public Accion(String nombre) {
		this.nombre = nombre;
		//this.operaciones = operaciones;
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

		System.out.println("Operaciones de la Acción: " + nombre);
		System.out.println("Operación: ");

		Iterator it = operaciones.iterator();

		while (it.hasNext()) {

			Operacion o = (Operacion) it.next();
			System.out.println("\t\t" + "Tipo: " + o.getTipo());
			System.out.println("\t\t" + "Cantidad: " + o.getCantidad());
			System.out.println("\t\t" + "Precio: " + o.getPrecio());

		}

	}

}
