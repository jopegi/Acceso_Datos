package josevi.serializable;

public class Principal {

	public static void main(String[] args) {
		
		Coche c1 = new Coche("Renault", "blanco", 56, 5);
		Coche c2 = new Coche("Ford", "rojo", 56, 3);
		Coche c3 = new Coche("Kia", "azul", 56, 5);
		
		
		Controlador c = new Controlador();
		
		c.guardarObjeto(c1, "coches.dat");
		
		Coche c4 = c.recuperarObjeto("coches.dat");
		
		c4.print();
		
		

	}

}
