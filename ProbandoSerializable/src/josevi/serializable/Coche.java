package josevi.serializable;

import java.io.Serializable;

public class Coche implements Serializable {

	private String marca;
	private String color;
	private float potencia;
	private int num_plazas;

	public Coche(String marca, String color, float potencia, int num_plazas) {

		this.marca = marca;
		this.color = color;
		this.potencia = potencia;
		this.num_plazas = num_plazas;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getPotencia() {
		return potencia;
	}

	public void setPotencia(float potencia) {
		this.potencia = potencia;
	}

	public int getNum_plazas() {
		return num_plazas;
	}

	public void setNum_plazas(int num_plazas) {
		this.num_plazas = num_plazas;
	}
	
	public void print() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("CARACTERÍSTICAS DEL COCHE\n");
		sb.append("\tMarca: " + marca+"\n");
		sb.append("\tColor: " + color+"\n");
		sb.append("\tPotencia: " + potencia+"\n");
		sb.append("\tPlazas: " + num_plazas+"\n");
		
		System.out.println(sb);
		
	}

}
