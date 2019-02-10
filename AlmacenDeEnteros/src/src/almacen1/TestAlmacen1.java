package src.almacen1;
// Clase de prueba COMPLETAR EL C�DIGO DEL M�TODO procesar Opci�n
import java.util.Scanner;

public class TestAlmacen1 {

	static public void main(String[] argv) {

		Almacen1 prueba = new Almacen1();
		Scanner sc = new Scanner(System.in);
		int opcion;

		mostrarMenu();
		opcion = sc.nextInt();
		while (opcion != 0) {
			procesarOpcion(opcion, prueba);
			mostrarMenu();
			opcion = sc.nextInt();
		}
		sc.close();
		
	}

	static void mostrarMenu() {
		System.out.println("--- MEN� DE  CONTROL DEL ALMAC�N -----");
		System.out.println(" 1.- Mostrar contenido del Almac�n");
		System.out.println(" 2.- Poner un Valor  ");
		System.out.println(" 3.- Buscar un Valor ");
		System.out.println(" 4.- Borrar un Valor");
		System.out.println(" 5.- Contar posiciones ocupadas.");
		System.out.println(" 6.- Contar posiciones libres.");
		System.out.println(" 0.- Terminar");
            System.out.print(" Introduzca una opci�n:[1-6]:");
	}

	// Procesa la opci�n introducida operando sobre el objeto Almacen1
	static void procesarOpcion(int opcion, Almacen1 parAlmacen) {
		Scanner sc1 = new Scanner(System.in);
		int valor = 0;

		switch (opcion) {
		case 1: 
			System.out.println(parAlmacen.toString());
			break;
		case 2:
			System.out.println("introduzca el valor a a�adir: ");
			valor = sc1.nextInt();
			if (parAlmacen.ponValor(valor))
				System.out.println("el valor se ha a�adido correctamente");
			else
				System.out.println("el valor no ha podido ser a�adido");
			break;
		case 3:
			System.out.println("introduzca el valor a buscar: ");
			valor = sc1.nextInt();
			if (parAlmacen.estaValor(valor))
				System.out.println("el valor est� en el almacen");
			else
				System.out.println("el valor no est� en el almacen");
			break;
		case 4:
			System.out.println("introduzca el valor a borrar: ");
			valor = sc1.nextInt();
			if (parAlmacen.sacarValor(valor))
				System.out.println("el valor se ha borrado correctamente");
			else
				System.out.println("el valor no estaba en el almac�n");
			break;
		case 5:
			System.out.println("Posiciones ocupadas " + parAlmacen.numPosicionesOcupadas());
			break;
		case 6:
		  System.out.println(" Posiciones libres = " + parAlmacen.numPosicionesLibres());
		}
		

	}

}
