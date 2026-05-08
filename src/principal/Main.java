package principal;
import base.Docente;
import base.Estudiante;
import tad.TADTeclado;
import tad.TADVector;

import java.io.IOException;

import base.Autenticacion;


public class Main {
	public static void main(String[] args) {
		 Autenticacion base = new Autenticacion(); 
		 TADTeclado input = new TADTeclado();
		 TADVector<Estudiante> vectorE = null;
		 String datos = "";
		 String nombre = "";
		 String opc = "";
		 int n = 0;
		 String cedula = "";
		 String contrasenia = "";
		 double nota = 0;
		 double suma = 0, promedio = 0;
		 boolean on = false;
		 
		 do {
			 try {
			 System.out.println("--------------------------------------------");
			 System.out.println("                BIENVENIDO                  ");
			 System.out.println("--------------------------------------------");
			 System.out.println("           Ingrese Su Cedula");
			 System.out.println("--------------------------------------------");
			 System.out.print("-> "); cedula = input.leerString();
			 System.out.println("--------------------------------------------");
			 System.out.println("          Ingrese Su Contrasenia            ");
			 System.out.println("--------------------------------------------");
			 System.out.print("-> "); contrasenia = input.leerString();
			 System.out.println("--------------------------------------------");
			 
			 if(base.iniciarSesion(cedula, contrasenia) == null) {
				 System.out.println("Error: Credenciales Ingresadas Son Incorrectas, Intente De nuevo");
			 }else {
				 System.out.println("\n      Sesion Iniciada Correctamente\n");
				 datos = base.datosDocente(cedula);
				 System.out.println(datos);
				 on = true;
			 }
			 
			 }catch(IOException e) {
				 e.getMessage();
			 }
			 
		 }while(!on);
		 
		 on = false;
		 
		 do {
			 
		try {
			
		 System.out.println("-----------------------------------------------");
		 System.out.println(" BIENVENIDO AL SISTEMA DE NOTAS DE ESTUDIANTES ");
		 System.out.println("-----------------------------------------------");
		 System.out.println(" 1. Ingresar Notas De Estudiantes  ");
		 System.out.println(" 2. Mostrar Estudiantes y Notas ");
		 System.out.println(" 3. Mostrar Promedio Total Del Curso ");
		 System.out.println(" 4. Modificar Nota De Un Estudiante ");
		 System.out.println(" 5. Eliminar Nota Estudiante ");
		 System.out.println(" 6. Buscar Estudiante ");
		 System.out.println(" 7. Salir");
		 System.out.println("-----------------------------------------------");
		 opc = input.leerString("Ingrese Una Opcion: ");
		 
		 switch(opc) {
		 case "1":
			 System.out.println("Ingrese La Cantidad De Estudiantes");
			 n = input.leerInt();
			 vectorE = new TADVector<Estudiante>("Vector Estudiantes", n);
			 
			 for (int i = 0; i < n; i++) {
				 try {
				System.out.println("Ingrese El Nombre["+i+"]");
				nombre = input.leerString();
				System.out.println("Ingrese La Nota["+i+"]");
				nota = input.leerDouble();
				vectorE.insertarNotas(i, new Estudiante(nombre, nota));
				
				 }catch(IOException e) {
					 i--;
					 e.getMessage();
				 }
			}
			 break;
		 case "2":
			 if(vectorE != null) {
			 vectorE.imprimirDatos();
			 }
			 break;
			 
		 case "3":
			 
			 break;
			 
			 default:
				 System.out.println("Opcion Invalida, Intente De Nuevo");
				 break;
		 }
		 
		 
		 
		 suma = sumaNotas(vectorE);
		 promedio = suma / vectorE.getLongitud();
		 
		 System.out.println("El Promedio Total Del Curso Es: " + promedio);
		 }catch(IOException e) {
			 e.getMessage();
		 }
		 }while(!on);
		 
		 
	 }
	 
	 private static double sumaNotas(TADVector<Estudiante> Estudiantes) {
		 double suma = 0;
		 for (int i = 0;i  < Estudiantes.getLongitud(); i++) {
			 suma = suma + Estudiantes.obtenerIndex(i).getNota();
		}
			
		 return suma;
	 }
	

}
