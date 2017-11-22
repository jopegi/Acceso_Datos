
public class NavidadThread extends Thread {

	String nombre;
	String mensaje = null;;

	public NavidadThread(String nombre, String mensaje) {

		this.nombre = nombre;
		this.mensaje = mensaje;

	}

	public NavidadThread(String nombre) {

		this.nombre = nombre;

	}

	@Override
	public void run() {

		for (int j = 1; j < 10; j++) {
			
			if (mensaje == null) {
				System.out.println("Estoy en la iteración: " + j);
			} else {
				System.out.println(mensaje);
			}
		}

		System.out.println("Finaliza el hilo**");

	}

	public static void main(String[] args) {

		Thread t1 = new NavidadThread("hilo1", "Feliz Navidad");
		Thread t2 = new NavidadThread("hilo2", "StarWars is comming");
		Thread t3 = new NavidadThread("hilo3");

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

		System.out.println("el hilo ptincipal terminado y yo sin polvorones comprados!!");

	}

}
