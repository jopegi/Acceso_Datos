import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
	
		/*try {
			Rotacion90GradosDerecha r = new Rotacion90GradosDerecha ("lena.png", "lena90.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		try {
			RotacionEspecular re = new RotacionEspecular ("lena.png", "lenaespejo.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
