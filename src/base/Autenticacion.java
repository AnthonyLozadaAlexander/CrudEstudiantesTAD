package base;

public class Autenticacion {
     private Docente[] docentesRegistrados;
     
     public Autenticacion() {
    	 docentesRegistrados = new Docente[3];
    	 docentesRegistrados[0] = new Docente("09784576", "23A5", "ING Juan", "Juan@edu.ec");
    	 docentesRegistrados[1] = new Docente("098567114", "35C7", "ING Pedro", "Pedro@edu.ec");
    	 docentesRegistrados[2] = new Docente("099134567", "64B9", "ING Toni", "Toni@edu.ec");
     }
     
     public Docente iniciarSesion(String cedula, String contrasenia) {
    	 for (int i = 0; i < docentesRegistrados.length; i++) {
			Docente doc = docentesRegistrados[i]; // instancia que toma el arreglo docentes registrados
			
			if(doc.getCedula().equals(cedula) && doc.getContrasenia().equals(contrasenia)) {
				return doc; // Encontro al docente
			}
		}
    	 
    	 return null; // Datos Ingresados Incorrectos
     }
}
