package tareaTutoria27DeAbril;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		 String nombre = "";
		 int n = 0;
		 double nota = 0;
		 double suma = 0, promedio = 0;
		 Estudiante[] vectorE;
		 
		 System.out.println("Ingrese La Cantidad De Estudiantes");
		 n = input.nextInt();
		 vectorE = new Estudiante[n];
		 input.nextLine();
		 
		 for (int i = 0; i < vectorE.length; i++) {
			System.out.println("Ingrese El Nombre["+i+"]");
			nombre = input.nextLine();
			System.out.println("Ingrese La Nota["+i+"]");
			nota = input.nextDouble();
			input.nextLine();
			vectorE[i] = new Estudiante(nombre,nota);
		}
		 suma = sumaNotas(vectorE);
		 promedio = suma / vectorE.length;
		 
		 System.out.println("El Promedio Total Del Curso Es: " + promedio);
		 
		 input.close();
		 
	 }
	 
	 static double sumaNotas(Estudiante[] vector) {
		 double suma = 0;
		 for (int i = 0;i  < vector.length; i++) {
			 suma = suma + vector[i].getNota();
		}
			
		 return suma;
	 }
	

}
