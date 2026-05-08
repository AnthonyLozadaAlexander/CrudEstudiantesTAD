package tad;


public class TADVector<T> {
	
	private T[] vector;
	private String nombre;
	private int longitud;
	
	public TADVector(String nombre, int longitud) {
		this.nombre = nombre;
		this.longitud = longitud;
		vector = (T[]) new Object[longitud];
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getLongitud() {
		return longitud;
	}
	
	public T obtenerIndex(int index) {
		return vector[index];
	}
	
	public void imprimirDatos() {
		for (int i = 0; i < vector.length; i++) {
			// if(i==0) System.out.print("[");
			
			if(i <= vector.length - 2) {
			System.out.print(vector[i] + ", ");
			}else {
				System.out.print(vector[i]);
			}
			
			//if(i == vector.length - 1) {
				//System.out.print("]\n");
			//}
		}
	}
	
	public boolean insertarNotas(int index, T elemento) {
		boolean on = false;
		if(!(index >= 0 && index < longitud)) {
			System.out.println("Error: Indice Invalido");
		}
		if(vector[index] == null) {	
			vector[index] = elemento;
			on = true;
		}
		else {
			System.out.println("Posicion Ocupada, No Se Puede Insertar El Elemento");
		}
		return on;
		
	}
	
	public boolean EliminarNotas(int index) {
		boolean on = false;
		if(!(index >= 0 && index < longitud)) {
			System.out.println("Error: Indice Invalido");
		}
		
		if(vector[index] != null) {
			vector[index] = null;
			on = true;
		}else {
			System.out.println("Error: No hay elementos en dicha posicion");
		}
		
		return on;
	}
	
	public boolean modificarNotas(int index,T elemento) {
		boolean on = false;
		if(!(index >= 0 && index < longitud)) {
			System.out.println("Error: Indice Invalido");
		}
		
		if(vector[index] != null) {
			vector[index] = elemento;
			on = true;
		}else {
			System.out.println("Error: No hay elementos en esa posicion");
		}
		
		return on;
		
	}
	
	
	public int buscarNotas(T elemento) {
		int index = -1;
		
		for (int i = 0; i < vector.length; i++) {
			if(vector[i] != null && vector[i].equals(elemento)) {
				index = i;
				i = vector.length; // salida del bucle
			}
		}
		
		return index;
	}
	
	

}
