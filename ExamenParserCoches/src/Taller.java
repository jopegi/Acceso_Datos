
public class Taller {
	
	private String nombreTaller;
	private Direccion direccion;
	private Coche coche;
	
	
	public Taller (String nombre) {	
		
		this.nombreTaller = nombre;
	}


	public String getNombreTaller() {
		return nombreTaller;
	}


	public void setNombreTaller(String nombreTaller) {
		this.nombreTaller = nombreTaller;
	}


	public Direccion getDireccion() {
		return direccion;
	}


	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


	public Coche getCoche() {
		return coche;
	}


	public void setCoche(Coche coche) {
		this.coche = coche;
	}
	
	
	public void print(){
		
		System.out.println("Nombre taller: "+nombreTaller);
		System.out.println("Nombre calle taller: "+direccion.getNombreCalle());
		System.out.println("Nombre localidad: "+direccion.getLocalidad());
		System.out.println("Nombre marca coche: "+coche.getMarca());
		System.out.println("Nombre modelo coche: "+coche.getModelo());
	}

}
