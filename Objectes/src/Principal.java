
public class Principal {

	public static void main(String[] args) {

		//Direccion d1 = new Direccion("Carrer nou",5);
		Persona p1 = new Persona("Josevi",40,new Direccion("Carrer nou",5));
		
		//int e=p1.getEdad();
		if(p1.getEdad()>35)
			System.out.println("Es mayor de edad");
		
		Direccion d2=p1.getDir();
		int n=d2.getNumero();
		
		System.out.println("El numero es "+n);
		System.out.println("El numero es "+d2.getNumero());
		System.out.println("El numero es "+p1.getDir().getNumero());
		
		
	}

}
