package josevi.personas;

public class Persona {
	
	private String dni;
	private String nombre;
	private float altura;
	private int edad;
	
	public Persona(String dni, String nombre, float altura, int edad) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.altura = altura;
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void print() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("DATOS DE LA PERSONA\t");
		sb.append("Dni: " +dni+ "\t");
		sb.append("Nombre: " +nombre+ "\t");
		sb.append("Altura: " +altura+ "\t");
		sb.append("Edad: " +edad+ "\t");
		
		System.out.println(sb);
		
	}

}
