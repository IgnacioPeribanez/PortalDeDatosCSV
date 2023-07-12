package portalDeDatosPúblicos;

import java.util.Scanner;

public class Main {
	
	/**
	 * pre: --- 
	 * Post: Este metodo actúa como menú en nuestro programa.
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("¡Bienvenidos al portal de datos del Ayutamiento de Zaragoza!");
		System.out.print(
				"------------------------------------------------------------------------------------------------------");
		while (true) {
			System.out.println("");
			System.out.println("0.- Apagar programa");
			System.out.println("1.- Generar los archivos de prueba");
			System.out.println("2.- Contar usos");
			System.out.println("3.- Usos por usuario");
			System.out.print("\n¿Que opcion deseas ejecutar?: ");
			int numero = entrada.nextInt();
			System.out.println("");
			if (numero > 3 || numero < 0) { // Mostramos el error en caso de introducir una opcion inexistente
				System.out.println("Error, elija una de las opciones validas");
			} else if (numero == 0) { // Paramos el programa al introducir 0
				System.out.print("Has apagado el programa");
				break;
			} else if (numero == 1) { // Llamamos al medodo DatosPrueba.main(args) si el numero es 1
				DatosPrueba.main(args);
			} else if (numero == 2) { // Llamamos al metodo ContarUsos.main(args) si el numero es 2
				ContarUsos.main(args);
			} else if (numero == 3) { // Llamamos al metodo UsosUsuario.main(args) si el numero es 3 
				UsosUsuario.main(args);
			} 
		}
	}
}
