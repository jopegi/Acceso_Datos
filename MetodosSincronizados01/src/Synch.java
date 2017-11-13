//Se crea una clase Synch encargada de lanzar la app mediante el 
//m�todo main()
public class Synch {
   	public static void main(String args[]) {
		//Se construye un objeto de tipo Callme
		Callme target = new Callme();
		//Se instancian 3 objetos de tipo caller
		//Cada uno de ellos crea un thread y, este a su vez, 
		//ejecuta el c�digo de su correspondiente m�todo
		//run(), el cual est� sincronizado con el objeto
		//target.
		new Caller(target, "Hola");
		new Caller(target, "Mundo");
		new Caller(target, "Sincronizado");
   	}
}