
public class ArraysBidimensionales {
	


	public static void main(String[] args) {
		
		int[][] miArray = new int [2][3];
		
		miArray[0][0] = 1;
		miArray[0][1] = 1;
		miArray[0][2] = 1;
		
		miArray[1][0] = 2;
		miArray[1][1] = 2;
		miArray[1][2] = 2;
		
		ArraysBidimensionales a = new ArraysBidimensionales();
		//a.mostrarValoresArray(miArray);
		

		//Mostrar el número de filas de un array bidimensional
		System.out.println("Número de filas: "+miArray.length);
		//Mostrar el número de columnas de un array bidimensional. En este caso le
		//decimos a Java que muestre el número de columnas de la segunda fila
		System.out.println("Número de columnas: "+miArray[1].length);
		//También le podríamos indicar que mostrase el número columnas de la primera fila
		System.out.println("Número de columnas: "+miArray[0].length);

	}
	
	public ArraysBidimensionales() {
		

		
	}
	
	public void mostrarValoresArray (int[][] arraybi) {
		
		for (int i = 0; i<2 ; i++) {
			System.out.println();
			for (int j = 0; j<3; j++) {
				System.out.print(arraybi[i][j] + " ");
			}
		}
		

	}

}
