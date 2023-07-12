package portalDeDatosPúblicos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class DatosPrueba {
	
	/**
	 * pre: --- 
	 * Post: Este método crea un archivo con los datos recibidos.
	 */
	public static void pruebas(String leer, String escribir, int num) {
		int contador = 0;
		File file = new File(leer);
		try {
			Formatter salida = new Formatter(escribir);
			Scanner f = new Scanner(file);
			while (f.hasNextLine()) {
				contador++;
				String linea = f.nextLine();
				salida.format(linea + "\n");
				if (contador > num) {
					salida.close();
					break;
				}
			}
			System.out.print("Archivo " + escribir + " creado con exito!\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * pre: --- 
	 * Post: Este método llama al método pruebas para generar los archivos con diferentes datos.
	 */
	public static void main(String[] args) {
		String leer1 = "C:\\Users\\Salesianos\\Desktop\\1ºGS\\PROGRAMACIÓN\\PRACTICA3\\usos-16.csv";
		String escribir1 = "C:\\Users\\Salesianos\\Desktop\\1ºGS\\PROGRAMACIÓN\\PRACTICA3\\pruebas-10.csv";
		String leer2 = "C:\\Users\\Salesianos\\Desktop\\1ºGS\\PROGRAMACIÓN\\PRACTICA3\\usos-17.csv";
		String escribir2 = "C:\\Users\\Salesianos\\Desktop\\1ºGS\\PROGRAMACIÓN\\PRACTICA3\\pruebas-2000.csv";
		pruebas(leer1, escribir1, 9);
		pruebas(leer2, escribir2, 1999);
	}
}
