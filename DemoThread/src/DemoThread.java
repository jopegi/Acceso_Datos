
public class DemoThread extends Thread{

	int retardo;
	private String nombre;
	
	public DemoThread(String n, int s) {
		
		super(n);
		
		nombre = n;
		retardo = s;
	}
	
	public void run() {
		
		for (int i = 0; i<5; i++) {
			
			try {
				sleep(retardo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Este hilo se llama " + nombre);
			System.out.println(getName());
		}
	}
	
	
	public static void main(String[] args) {
		
		DemoThread t1 = new DemoThread ("hilo1",3000);
		DemoThread t2 = new DemoThread ("hilo2",4000);
		
		t1.start();
		t2.start();
		
	}

}
