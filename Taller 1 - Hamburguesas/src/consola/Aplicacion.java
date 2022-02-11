package consola;

import java.io.IOException;
import java.util.Scanner;
import logica.Restaurante;

public class Aplicacion {
	
	private Restaurante restaurante;
	
	public static void main(String[] args) throws IOException {
		Aplicacion consola = new Aplicacion();
		consola.ejecutarOpcion();
		consola.cargarArchivos();
	}
	
	public void cargarArchivos() throws IOException {
		Restaurante.cargarInfoRestaurante
				("C:\\Users\\danie\\OneDrive\\Documentos\\GitHub\\Taller1\\Taller 1 - Hamburguesas\\data\\combos.txt", 
				"C:\\Users\\danie\\OneDrive\\Documentos\\GitHub\\Taller1\\Taller 1 - Hamburguesas\\data\\ingredientes.txt",
				"C:\\Users\\danie\\OneDrive\\Documentos\\GitHub\\Taller1\\Taller 1 - Hamburguesas\\data\\menu.txt");
	}

	public void ejecutarOpcion() {
		
		Scanner input = new Scanner(System.in);
		boolean continuar = true;
		while (continuar) {
			try {
				mostrarMenu();
				System.out.println("Por favor selecione una de las siguientes opciones: ");
				int opcion_seleccionada = input.nextInt();
				if (opcion_seleccionada == 1)
					iniciar_pedido();
				else if (opcion_seleccionada == 2)
					agregar_elemento();
				else if (opcion_seleccionada == 3)
					finalizar_pedido();
				else if (opcion_seleccionada == 4)
					consultar_pedido();
				else if (opcion_seleccionada == 5) {
					System.out.println("Saliendo de la aplicaci�n...");
					continuar = false;
				} 
				else
					System.out.println("Por favor seleccione una de las opciones");
			} catch (NumberFormatException e) {
				System.out.println("Debe seleccionar uno de los n�meros de las opciones");
			}
			input.close();
		}
	}
	
	public void mostrarMenu() {
		System.out.println("\nOpciones ");
		System.out.println("1. Hacer un pedido");
		System.out.println("2. Agregar elemento ");
		System.out.println("3. Finalizar pedido");
		System.out.println("4. Condsultar pedido");
		System.out.println("5. Salir");
		System.out.println("\nOpciones ");
		
	}
	
	private void consultar_pedido() {

	}

	private void finalizar_pedido() {

	}

	private void agregar_elemento() {

	}

	private void iniciar_pedido() {

	}
}