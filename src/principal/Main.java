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
		String nombreBuscar = "";
		String datos = "";
		String nombre = "";
		String opc = "";
		int n = 0;
		String cedula = "";
		String contrasenia = "";
		double nuevaNota = 0.0;
		double nota = 0.0;
		double suma = 0.0, promedio = 0.0;
		boolean on = false;

		do {
			try {
				System.out.println("--------------------------------------------");
				System.out.println("                BIENVENIDO                  ");
				System.out.println("--------------------------------------------");
				System.out.println("           Ingrese Su Cedula");
				System.out.println("--------------------------------------------");
				System.out.print("-> ");
				cedula = input.leerString();
				System.out.println("--------------------------------------------");
				System.out.println("          Ingrese Su Contrasenia            ");
				System.out.println("--------------------------------------------");
				System.out.print("-> ");
				contrasenia = input.leerString();
				System.out.println("--------------------------------------------");

				if (base.iniciarSesion(cedula, contrasenia) == null) {
					System.out.println("Error: Credenciales Ingresadas Son Incorrectas, Intente De nuevo");
				} else {
					System.out.println("\n      Sesion Iniciada Correctamente\n");
					datos = base.datosDocente(cedula);
					System.out.println(datos);
					on = true;
				}

			} catch (IOException e) {
				e.getMessage();
			}

		} while (!on);

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
				System.out.println(" 5. Eliminar Estudiante ");
				System.out.println(" 6. Buscar Estudiante ");
				System.out.println(" 7. Salir");
				System.out.println("-----------------------------------------------");
				opc = input.leerString("Ingrese Una Opcion: ");

				switch (opc) {
					case "1":
						System.out.println("Ingrese La Cantidad De Estudiantes");
						n = input.leerInt();
						vectorE = new TADVector<Estudiante>("Vector Estudiantes", n);

						for (int i = 0; i < n; i++) {
							try {
								System.out.println("Ingrese El Nombre[" + i + "]");
								nombre = input.leerString();
								System.out.println("Ingrese La Nota[" + i + "]");
								nota = input.leerDouble();
								vectorE.insertarNotas(i, new Estudiante(nombre, nota));

							} catch (NumberFormatException e) {
								i--;
								System.out.println("Error: Debe Ingresar Un Numero Valido Para La Nota");
							} catch (IOException e) {
								i--;
								e.getMessage();
							}
						}
						break;
					case "2":
						if (vectorE != null) {
							vectorE.imprimirDatos();
						} else {
							System.out.println("Error: No Hay Estudiantes En El Vector/n");
						}
						break;

					case "3":
						if (vectorE != null) {
							suma = Promedio(vectorE);
							promedio = suma / vectorE.getLongitud();
							System.out.println("El Promedio Total Del Curso Es: " + promedio);
						} else {
							System.out.println("No hay Estudiantes Aun En El Vector");
						}

						break;
					case "4":
						try {
							int index = input.leerInt("Ingrese el indice del estudiante a modificar: ");
							if (index >= 0 && index < vectorE.getLongitud() && vectorE != null) {

								index = index - 1;
								nuevaNota = input.leerDouble("Ingrese la nueva nota para el estudiante: ");
								Estudiante eNota = vectorE.obtenerIndex(index); // referencia para guardar el index de
																				// referencia
								eNota.setNota(nuevaNota);
								boolean result = vectorE.modificarNotas(index, eNota);

								if (result) {
									System.out.println("Nota Modificada Correctamente");
								} else {
									System.out.println(
											"Error: No se pudo modificar la nota del Estudiante[" + index + "]");
								}

							} else {
								System.out.println("Error: Indice Invalido");
							}
						} catch (NumberFormatException e) {
							System.out.println("Error: Debe Ingresar Un Numero Valido");
						}

						break;

					case "5":
						if (vectorE == null) {
							System.out.println("Error: No hay Estudiantes en el vector\n");
						} else {
							try {
								vectorE.imprimirDatos();
								int indexNota = input.leerInt("Ingrese el indice del estudiante a eliminar: ");
								if (indexNota >= 0 && indexNota < vectorE.getLongitud()) {
									boolean eliminarNota = vectorE.EliminarNotas(indexNota - 1);
									if (eliminarNota) {
										vectorE.imprimirEstudiante(indexNota - 1);
										System.out.println("Nota Eliminada Correctamente");
									}
								}
							} catch (NumberFormatException e) {
								System.out.println("Error: Debe Ingresar Un Numero Valido Para El Indice");
							} catch (IOException e) {
								e.getMessage();
							}

						}
						break;

					case "6":

						if (vectorE == null) {
							System.out.println("Error: No hay Estudiantes en el vector\n");
						} else {
							vectorE.imprimirDatos();
							nombreBuscar = input.leerString("Ingrese el nombre del estudiante a buscar: ");
							Estudiante estudianteBuscar;
							estudianteBuscar = new Estudiante(nombreBuscar, 0.0);
							int indexE = vectorE.buscarEstudiante(estudianteBuscar);

							if (indexE != -1) {
								System.out.println("Estudiante Encontrado: " + vectorE.obtenerIndex(indexE).toString());
							} else {
								System.out.println("Error: Estudiante no encontrado");
							}

						}
						break;

					case "7":
						System.out.println("Saliendo del Sistema...");
						on = true;
						break;

					default:
						System.out.println("Opcion Invalida, Intente De Nuevo");
						break;
				}

			} catch (IOException e) {
				e.getMessage();
			}
		} while (!on);

	}

	private static double Promedio(TADVector<Estudiante> Estudiantes) {
		double suma = 0;
		for (int i = 0; i < Estudiantes.getLongitud(); i++) {
			suma = suma + Estudiantes.obtenerIndex(i).getNota();
		}
		return suma / Estudiantes.getLongitud();
	}

}
