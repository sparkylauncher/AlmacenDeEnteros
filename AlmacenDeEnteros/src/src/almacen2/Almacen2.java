package src.almacen2;
import java.util.Arrays;

/*
 * Implementar un almac�n de enteros mediante una tabla de huecos
 * se supone que no puede contener el valor 0 ya que indica posiciones libre.
 */
public class Almacen2 {

	static private final int LIBRE = 0;
	// Array con los valores almacenados
	private int tvalores[];
	private int valoresAlmacenados = 0;
	
	// Constructores sin par�metros creo una tabla de 10 elementos
	public Almacen2(){
		this(10);  // Llamo al constructor con par�metros
	}

	// Constructor donde se fija tama�o m�ximo del Almac�n
	public Almacen2( int tamanio){
		tvalores = new int [tamanio];
		init();
	}
	
	// Pone todas las posiciones a LIBRES
	public void init (){
		for (int i = 0; i < tvalores.length; i++) {
			tvalores[i] = Almacen2.LIBRE;
		}
		valoresAlmacenados = 0;
	}
	
	// Muestra una cadena con los valores de la tabla
	public String toString (){
		StringBuilder cadena = new StringBuilder();
		cadena.append("[");
		for (int i = 0; i < this.tvalores.length; i++) {
			cadena.append(Integer.toString(this.tvalores[i]) + " ");	 
		}
		cadena.append("]");
		return cadena.toString();
	}
	
	// Devuelve el n�meros de posiciones libres
	public int numPosicionesLibres(){
		return this.tvalores.length - this.valoresAlmacenados;
	}
	
	// Devuelve el n�mero de posiones ocupadas
	public int numPosicionesOcupadas(){
		return this.valoresAlmacenados;
	}
	
	// Devuelve verdadero o falso si est� almacenado el valor en la tabla
	public boolean estaValor ( int num){
		return Arrays.stream(this.tvalores).anyMatch(x -> x == num);
	}
	
	// Almacena el valor el la tabla, devuelve false sin no puede almacenarlo
	public boolean ponValor (int num){
		if(this.estaLleno()) return false;
		int pos = Arrays.binarySearch(this.tvalores,0,this.valoresAlmacenados,num);
		if (pos < 0) pos = pos * -1 - 1;
		for (int i = this.valoresAlmacenados; i > pos; i--) {
			this.tvalores[i] = this.tvalores[i - 1];
		}
		this.tvalores[pos] = num;
		this.valoresAlmacenados++;
		return true;
	}
	
	// Elimina el elemento de la tabla, si no esta devuelve false
	public boolean sacarValor (int num){
		if (this.valoresAlmacenados == 0) return false;
		if (Arrays.binarySearch(this.tvalores, num) < 0) return false;
		else {
			int cantidad = 0, pos = -1;
			for (int i = 0; i< this.valoresAlmacenados; i++) {
				if (this.tvalores[i] == num) {
					if(pos == -1) pos = i;
					cantidad++;
				}else if(cantidad > 0) {
					for (int j = pos + cantidad; j < this.valoresAlmacenados; j++) {
						this.tvalores[pos] = this.tvalores[j];
						pos++;
					}
				}
				
			}
			this.valoresAlmacenados = this.valoresAlmacenados - cantidad;
			for (int i = this.valoresAlmacenados; i < this.valoresAlmacenados + cantidad; i++)
				this.tvalores[i]=0;
		}

		return true;
	}
      // Indica si el almac�n esta lleno
	public boolean estaLleno (){	
		return this.valoresAlmacenados == this.tvalores.length;
	}
}