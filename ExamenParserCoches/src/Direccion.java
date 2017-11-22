
public class Direccion {
	
	
	private String nombreCalle;
	private String localidad;
	
	public Direccion(String calle, String localidad) {
		
		this.nombreCalle = calle;
		this.localidad = localidad;
	}

	public String getNombreCalle() {
		return nombreCalle;
	}

	public void setNombreCalle(String nombreCalle) {
		this.nombreCalle = nombreCalle;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

}
