package base;

public class Docente {
	
	private String cedula;
	private String contrasenia;
	private String correoElectronico;
	private String nombre;
	
	public Docente(String cedula, String contrasenia, String nombre, String correoElectronico) {
		this.cedula = cedula;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
	}
	
	public String getCedula() {
		return cedula;
	}
	
	public String getContrasenia(){
		return contrasenia;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return "        Datos Del Docente\n" +
			   "Nombre: " + nombre + 
			   "\nCedula: " + cedula +
			   "\nContrasenia: " + contrasenia + "\n";
	}

}
