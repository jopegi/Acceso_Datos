
public class NadidadThread extends Thread {

	private String mensaje = null;
	private String nombre;

	public NadidadThread(String nombre, String mensaje) {

		this.nombre = nombre;
		this.mensaje = mensaje;
	}

	public NadidadThread(String nombre) {

		this.nombre = nombre;
	}

	@Override
	public void run() {

		for (int j = 0; j < 10; j++) {

			if (mensaje == null) {

				System.out.println("Estamos en la iteración: " + j);

			} else {

				System.out.println(mensaje);
			}
			
		}
		
		System.out.println("Finaliza el hilo llamado: " + nombre);

	}

	public static void main(String[] args) {

		Thread t1 = new NadidadThread("hilo1", "Feliz Navidad!");
		Thread t2 = new NadidadThread("hilo2", "StarWars 8 is comming!");
		Thread t3 = new NadidadThread("hilo3");

		t1.start();
		t2.start();
		t3.start();

		try {
			
			t1.join();
			t2.join();
			t3.join();
			
		} catch (InterruptedException e) {
			
			
			e.printStackTrace();
		}

		System.out.println("El hilo principal ha terminado y yo sin los polvorones comprados!!");
	}

}
