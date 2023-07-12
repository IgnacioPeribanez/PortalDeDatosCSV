 	package portalDeDatosPúblicos;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContarUsos {
	
	/**
	 * pre: --- 
	 * Post: Este método se encarga de contar el número de usos según su tipo .
	 */
	public static void contar(String nombre) {
		int contador = 0;
		int traslado = 0;
		int circular = 0;
		int usos = 0;	
		File file = new File(nombre);
		try {
			Scanner f = new Scanner(file);
			System.out.println();
			while (f.hasNextLine()) {
				String linea = f.nextLine();
				if (contador > 0) {
					usos++;
					String[] lineaSeparada = linea.split(";");
					Usobici uso = new Usobici(Integer.parseInt(lineaSeparada[0]), lineaSeparada[1], 
							Integer.parseInt(lineaSeparada[2]), lineaSeparada[3], Integer.parseInt(lineaSeparada[4]));
					// Creamos un objeto de clase Usobici por cada linea que leemos.
					if (uso.getRetiroEstacion() == uso.getAnclajeEstacion()) { 
						circular++;
					}else {
						traslado++;
					}
				}else {
					contador ++;
				}
			}
			System.out.println("Número de usos como traslado: " + traslado);
			System.out.println("Número de usos circulares: " + circular);
			System.out.println("Número total de usos: " + usos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * pre: --- 
	 * Post: Este método llama a contar enviandole el nombre de un fichero.
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Escriba el nombre de un fichero de usos del sistema bizi: ");
		String fichero = entrada.nextLine();
		contar(fichero);
	}
}
