
public class DemoRunnable implements Runnable{
	
	String nombre;
	
	public DemoRunnable(String n) {
		nombre = n;
	}
	
	@Override
	public void run() {
		
		for (int j = 0; j< 5; j++) {
			System.out.println("Este es el hilo " + nombre);
		}
		
	}

	public static void main(String[] args) {
		
		Thread t1 = new Thread (new DemoRunnable("hilo1"));
		t1.start();
		

	}



}
