
public class Mensajes {

	//M�todo est�tico sincronizado
	public static synchronized void escribeMensaje(String mensaje){
		
		for (int i = 0; i<5; i++) {
			
			System.out.println(mensaje);
		}
	}
}
