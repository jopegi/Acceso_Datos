
public class Persona {
	
	private String nom;
	private int edad;
	private Direccion dir;
	
	public Persona(String n, int e, Direccion d) {
		nom=n;
		edad=e;
		dir=d;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Direccion getDir() {
		return dir;
	}
	public void setDir(Direccion dir) {
		this.dir = dir;
	}
	
	

}
