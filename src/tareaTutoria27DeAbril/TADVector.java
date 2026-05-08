package tareaTutoria27DeAbril;


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
	
	public void imprimirVector() {
		for (int i = 0; i < vector.length; i++) {
			if(i==0) System.out.print("[");
			if(i <= vector.length - 2) {
			System.out.print(vector[i] + ", ");
			}else {
				System.out.print(vector[i]);
			}
			if(i == vector.length - 1) {
				System.out.print("]\n");
			}
		}
	}
	
	public boolean insertarElemento(int index, T elemento) {
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
	
	

}
