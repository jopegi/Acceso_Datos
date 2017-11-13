import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RotacionEspecular {
	
	public RotacionEspecular(String ficheroEntrada, String ficheroSalida) throws IOException{
		
		// Inicialización de variables y objetos
		int anchoImagen;
		int altoImagen;
		int[][] arrayImagen;

		File f = new File(ficheroEntrada);
		BufferedImage bf = ImageIO.read(f);

		// columnas (píxeles) de la imagen
		anchoImagen = bf.getWidth();
		// filas (píxeles) de la imagen
		altoImagen = bf.getHeight();

		// anchoImagen = 512;
		// altoImagen = 512;

		// Creamos un array bidimensional para almacenar los valores RGB de la imagen
		arrayImagen = new int[altoImagen][anchoImagen];

		// Cargamos el array bidimensional con los valores RGB de la imagen
		for (int x = 0; x < altoImagen; x++) {
			for (int y = 0; y < anchoImagen; y++) {

				arrayImagen[x][y] = bf.getRGB(x, y);
			}
		}

		// Por si se quiere comprobar el contenido del array por consola:
		/*
		 * for (int i = 0; i < altoImagen; i++) { System.out.println(); for (int j = 0;
		 * j < anchoImagen; j++) {
		 * 
		 * System.out.print(arrayImagen[i][j] + " "); } }
		 */

		int[][] arrayImagenEspejo = new int[altoImagen][anchoImagen];

		// Rotamos de forma especular
		for (int x = 0; x < altoImagen; x++) {
			for (int y = 0; y < anchoImagen; y++) {
				
				int n = (altoImagen-1); 
				//arrayImagenEspejo[x][n-y] = bf.getRGB(x, y);
				arrayImagenEspejo[n-x][y] = bf.getRGB(x, y);
			}
		}
		
		//Creamos un nuevo BufferedImage para almacenar la imagen rotada
		BufferedImage img = new BufferedImage( 
				512, 512, BufferedImage.TYPE_INT_RGB );
		
		//Creamos un nuevo fichero de salida
		File g = new File(ficheroSalida);
		
		//Cargamos los valores del array que forman la imagen rotada
		//en el BufferedImage
		  for(int x = 0; x < 512; x++){
              for(int y = 0; y < 512; y++){
                  img.setRGB(x, y, arrayImagenEspejo[x][y]);
              }
          }
		  
		  //Con el método estático write de la clase ImageIO escribimos en el fichero de
		  //salida g el contenido del BufferedImage que ya contiene la info de la imagen rotada
		  //y le indicamos que se formatee a imagen de tipo PNG
          ImageIO.write(img, "PNG", g);
	}

}
