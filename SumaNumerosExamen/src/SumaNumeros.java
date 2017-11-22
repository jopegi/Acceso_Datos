import javax.swing.JOptionPane;

public class SumaNumeros {

	private int numeros;
	private int contadorNumeros = 0;
	private int numeroASumar;
	private int SumaNumeros = 0;

	public SumaNumeros() {

	}

	public int metodoSumar() {

		numeros = Integer.parseInt(JOptionPane.showInputDialog("Por favor, dime cuantos números quieres que sume"));

		while (contadorNumeros < numeros) {

			contadorNumeros++;
			numeroASumar = Integer.parseInt(JOptionPane.showInputDialog("Por favor, dame un número:"));
			SumaNumeros = SumaNumeros + numeroASumar;
		}
		
		System.out.println("Has introducido un total de "+numeros+" números y su suma total es "+SumaNumeros);
		JOptionPane.showMessageDialog(null,"Has introducido un total de "+numeros+" y su suma total es "+SumaNumeros);

		return SumaNumeros;

	}

	public static void main(String[] args) {
		
		SumaNumeros s = new SumaNumeros();
		
		s.metodoSumar();

	}

}