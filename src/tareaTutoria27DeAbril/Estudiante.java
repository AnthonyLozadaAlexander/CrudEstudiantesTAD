package tareaTutoria27DeAbril;

public class Estudiante {
	
	private String nombre;
	private double Nota;
	
	Estudiante(String nombre,Double nota){
		this.nombre = nombre;
		this.Nota = nota;
	}
	
	void setNota(double nota) {
		this.Nota = nota;
	}
	
	double getNota() {
		return Nota;
	}
	@Override
	public String toString() {
		return 
	    "Nota: " + Nota + "\n";
	}

}
