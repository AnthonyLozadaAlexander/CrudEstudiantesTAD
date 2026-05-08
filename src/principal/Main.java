package principal;
import base.Docente;
import base.Estudiante;
import tad.TADTeclado;
import tad.TADVector;
import base.Autenticacion;

import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		TADVector<Estudiante> vectorE;
		 String nombre = "";
		 int n = 0;
		 double nota = 0;
		 double suma = 0, promedio = 0;
		 
		 System.out.println("-----------------------------------------------");
		 System.out.println(" BIENVENIDO AL SISTEMA DE NOTAS DE ESTUDIANTES ");
		 System.out.println("-----------------------------------------------");
		 
		 System.out.println("Ingrese La Cantidad De Estudiantes");
		 n = input.nextInt();
		 vectorE = new TADVector<Estudiante>("Vector Estudiantes", n);
		 input.nextLine();
		 
		 for (int i = 0; i < n; i++) {
			System.out.println("Ingrese El Nombre["+i+"]");
			nombre = input.nextLine();
			System.out.println("Ingrese La Nota["+i+"]");
			nota = input.nextDouble();
			input.nextLine();
			vectorE.insertarNotas(i, new Estudiante(nombre, nota));
		}
		 suma = sumaNotas(vectorE);
		 promedio = suma / vectorE.getLongitud();
		 
		 System.out.println("El Promedio Total Del Curso Es: " + promedio);
		 
		 input.close();
		 
	 }
	 
	 private static double sumaNotas(TADVector<Estudiante> Estudiantes) {
		 double suma = 0;
		 for (int i = 0;i  < Estudiantes.getLongitud(); i++) {
			 suma = suma + Estudiantes.obtenerIndex(i).getNota();
		}
			
		 return suma;
	 }
	

}
