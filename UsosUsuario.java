package portalDeDatosPúblicos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class UsosUsuario {
	
	/**
	 * pre: --- 
	 * Post: Este metodo recibe todos los usos y los usuarios unicos, trata de contar los usos que 
	 * realiza cada usaurio añadiendo cada uno dependiendo del tipo que sea. Una vez contados,
	 * los ordena de mayor a menor por numero de usos.
	 */
	public static ArrayList<UsuarioBizi> obtenerUsosPorUsuarios(ArrayList<Usobici> usos, ArrayList<UsuarioBizi> usuarios) {
		for(int i = 0; i < usuarios.size(); i++) { //Bucle que se ejecuta por cada usuario
			for(int j = 0; j < usos.size(); j++) { //Bucle que compara cada uso
				if (usos.get(j).getIDUsuario() == usuarios.get(i).getIDUsuario()) {
					usuarios.get(i).setTotal(usuarios.get(i).getTotal()+1);
					if (usos.get(j).getRetiroEstacion() == usos.get(j).getAnclajeEstacion()) {
						usuarios.get(i).setCircular(usuarios.get(i).getCircular()+1);
					}else {
						usuarios.get(i).setTraslados(usuarios.get(i).getTraslados()+1);
					}
				}
			}
			System.out.println("\nUsuario " + (i + 1) + " recopilado");
		}
		Collections.sort(usuarios);
		return usuarios;
	}
	
	/**
	 * pre: --- 
	 * Post: Este metodo alamacena en un ArrayList los usuarios sin repetirlos, es decir,
	 * conseguimos un ArrayList con todos los usuarios que han usado el servicio de bici
	 */
	public static ArrayList<UsuarioBizi> contarUsuarios(UsuarioBizi usu, ArrayList<UsuarioBizi> usuarios) {
		int contador = 0;
		boolean encontrado = false;
		for (int z = 0; z < usuarios.size(); z++) {
			if (usu.getIDUsuario() == usuarios.get(z).getIDUsuario()) {
				contador++;
				encontrado = true;
				break;
			}
		}
		if (encontrado == false) {
			usuarios.add(usu);
		}
		return usuarios;
	}
	
	/**
	 * pre: --- 
	 * Post: Este metodo lee el fichero, crea todos los usos y todos los usuarios, llama a los metodos
	 * necesarios por orden y muestra por pantalla los usuariosBizi con todos sus atributos.
	 */
	public static void leer(String nombre) {
		ArrayList<UsuarioBizi> usuarios = new ArrayList<UsuarioBizi>(); // Creamos un ArrayList de tipo 
																		// UsuarioBizi para almacenar los usuarios unicos
		ArrayList<Usobici> usos = new ArrayList<Usobici>();// Creamos un ArrayList de tipo 
														   // Usobici para almacenar todos los usos del archivo
		int contador = 0;	
		int mostrar = 1;
		File file = new File(nombre);
		try {
			Scanner f = new Scanner(file);
			System.out.println();
			while (f.hasNextLine()) {
				String linea = f.nextLine();
				if (contador > 0) {
					String[] lineaSeparada = linea.split(";");
					Usobici uso = new Usobici(Integer.parseInt(lineaSeparada[0]), lineaSeparada[1], 
							Integer.parseInt(lineaSeparada[2]), lineaSeparada[3], Integer.parseInt(lineaSeparada[4]));
					// Creamos un objeto de clase Usobici por cada linea que leemos.
					usos.add(uso);
					UsuarioBizi usuario = new UsuarioBizi(Integer.parseInt(lineaSeparada[0]));
					usuarios = contarUsuarios(usuario, usuarios);
				}else {
					contador ++;
				}
				System.out.println("\nLineas leidas: " + mostrar);
				mostrar++;
			}
			usuarios = obtenerUsosPorUsuarios(usos,usuarios);
			System.out.println("\n-----------------------------------------------------------------------");
			System.out.println("\nNombre del fichero: " + nombre);
			System.out.println("\nNúmero de usuarios distintos: " + usuarios.size());
			System.out.println("\nUsuario " + "Traslados " + "Circular " + "Total");
			System.out.println("======= ========= ======= ======= ");
			if (usuarios.size() > 14) { // Si tiene mas de 15 usuarios muestra los 15 con mas usos.
				for(int i = 0; i < 14; i++) {
					System.out.println(usuarios.get(i));
				}
			}else {
				for(int i = 0; i < usuarios.size(); i++) { // Si tiene menos de 15 usuarios muestra todos.
					System.out.println(usuarios.get(i));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * pre: --- 
	 * Post: Este metodo pide una ruta para leer y llama al metodo leer() pasandole la ruta
 	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Escriba el nombre de un fichero de usos del sistema bizi: ");
		String fichero =  entrada.nextLine();
		leer(fichero);
	}
}
