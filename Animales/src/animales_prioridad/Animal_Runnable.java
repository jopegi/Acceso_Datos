package animales_prioridad;

//Clase que implementa la interfaz Runnable
public class Animal_Runnable implements Runnable{

	//Variables de la clase
    private String nombre;
    
    //Constructor de la clase
    public Animal_Runnable(String nombre) {
    	this.nombre=nombre;
    }
	
    //M�todo abstracto run() propio de la interfaz Runnable
    //En �l se define el c�digo a ejecutar por cada nuevo hilo 
    //que se instancie
	@Override
	public void run() {
		//Definimos 5 iteraciones para hilo que se instancie
		for (int i =0; i<5; i++) {
			
			System.out.println(nombre);
		}
		//Mensaje que se mostrar� al finalizar cada hilo
		System.out.println(nombre+" terminado");
		
	}

	//M�todo main que lanzar� la app
	public static void main (String[] args) {
		
		//Instanciamos 3 objetos distintos de tipo Thread haciendo uso de un objeto de tipo Runnable distinto en cada caso
		Thread tortuga = new Thread (new Animal_Runnable("hilo_tortuga"));
		Thread liebre = new Thread (new Animal_Runnable("hilo_liebre"));
		Thread guepardo = new Thread (new Animal_Runnable("hilo_guepardo"));
		
		//Asignamos prioridades a cada hilo de forma directa, sin hacer uso de las constantes de clase
		tortuga.setPriority(1);
		liebre.setPriority(5);
		guepardo.setPriority(10);
		
		//Lanzamos los hilos con el m�todo start() propio de la clase Thread
		//Este m�todo invocar� al m�todo run() de cada hilo
		tortuga.start();
		liebre.start();
		guepardo.start();
		
	}


}
