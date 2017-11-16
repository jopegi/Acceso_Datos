import java.util.ArrayList;
import java.util.Iterator;


public class Accion {
	
	private String nombre;
	private ArrayList<Compra>compras;
	private ArrayList<Venta>ventas;
	
	public Accion(String nombre) {
		
		this.nombre = nombre;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Compra> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Compra> compras) {
		this.compras = compras;
	}

	public ArrayList<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}
	
	public void print() {
		
		System.out.println("Nombre de la acción: " + nombre);
		
		System.out.println("\tCompras: ");
		
		Iterator it = compras.iterator();

		while (it.hasNext()) {

			Compra c = (Compra) it.next();
			System.out.println("\t\t" + "Cantidad: " + c.getCantidad());
			System.out.println("\t\t" + "Precio: " + c.getPrecio());

		}
		
		System.out.println("\tVentas: ");
		
		Iterator it2 = ventas.iterator();
		
		while (it.hasNext()) {

			Venta v = (Venta) it.next();
			System.out.println("\t\t" + "Cantidad: " + v.getCantidad());
			System.out.println("\t\t" + "Precio: " + v.getPrecio());

		}
		
	}

}
