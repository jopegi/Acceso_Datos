package ejercicio2;

import java.text.DecimalFormat;

/*
 * ClaseCalculo cuyo m�todo nuevoValor realiza la suma del valor que recibe como par�metro de 
 * forma acumulativa y calcula la media aritm�tica en funci�n del n�mero de veces que ha sido invocado.
 * 
 */

public class ClaseCalculo {
	
	

	private static double cont = 0;					//Variable encargada de guardar el n�mero de valores sumados. 
	private static int contador_compartido = 1;		//Variable de clase que servir� para contear, de forma acumulativa, el n�mero de valores sumados.
												
	private static double suma = 0;					//Variable encargada de guardar la suma de valores insertados.
	private static double suma_compartida = 0;		//Variable de clase que servir� para ir acumulando las sumas realizadas.

	private static double media  = 0;				//Variable encargada de guardar el valor de la media en cada momento
	
	
	//Constructor de la clase
	public ClaseCalculo() {
		
	}
	
	//M�todo de acumulaci�n de sumas de valores insertados y c�lculo de la media 
	//Se declara est�tico para que no tengamos que instanciar un nuevo objeto de la clase 
	//cada vez que queramos utilizarlo.
	//Se declara sincronizado para que no pueda ser accedido por m�s de un hilo cada vez.
	public static synchronized double nuevoValor(double valor) {
		
		cont = contador_compartido; 
		
		suma = suma_compartida + valor;

		suma_compartida = suma;
		
		media = suma_compartida / cont;
		
		DecimalFormat df = new DecimalFormat("#.00");
		
		String media_formateada = df.format(media);
		
		System.out.println("**********************************************");
		System.out.println("suma acumulada de valores = "+suma_compartida);
		System.out.println("contador de valores insertados = "+cont);
		System.out.println("media de valores actualizada = "+media_formateada+"\n");
		//System.out.print(String.format("%.2f", media));
		System.out.println("**********************************************");
		System.out.println("");

		contador_compartido++;

		return media;
	}
	
	//M�todos Setter y Getter
	public double getCont() {
		return cont;
	}

	public void setCont(double cont) {
		ClaseCalculo.cont = cont;
	}

	public static int getContador_compartido() {
		return contador_compartido;
	}

	public static void setContador_compartido(int contador_compartido) {
		ClaseCalculo.contador_compartido = contador_compartido;
	}

	public static double getSuma_compartida() {
		return suma_compartida;
	}

	public static void setSuma_compartida(double suma_compartida) {
		ClaseCalculo.suma_compartida = suma_compartida;
	}

	public double getSuma() {
		return suma;
	}

	public void setSuma(double suma) {
		ClaseCalculo.suma = suma;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		ClaseCalculo.media = media;
	}

}
