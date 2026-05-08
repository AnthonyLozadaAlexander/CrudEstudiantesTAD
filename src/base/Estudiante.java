package base;

public class Estudiante {
	
	private String nombre;
	private double Nota;
	
	public Estudiante(String nombre,Double nota){
		this.nombre = nombre;
		this.Nota = nota;
	}
	
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	protected void setNota(double nota) {
		this.Nota = nota;
	}
	
	public double getNota() {
		return Nota;
	}
	@Override
	public String toString() {
		return "       Datos Del Estudiante\n" +
	           "Nombre: " + nombre + "\n" +
	           "Nota: " + Nota + "\n";
	}

}
