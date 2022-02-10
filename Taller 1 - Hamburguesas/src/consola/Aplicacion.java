package consola;

import java.util.Scanner;

public class Aplicacion {

	public static void main(String[] args) {
		Aplicacion consola = new Aplicacion();
		consola.ejecutarOpcion();
	}

	public void ejecutarOpcion() {
		Scanner input = new Scanner(System.in);
		boolean continuar = true;
		while (continuar) {
			try {
				mostrarMenu();
				System.out.println("Por favor selecione una de las siguientes opciones");
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
					System.out.println("Saliendo de la aplicación...");
					continuar = false;
				} else
					System.out.println("Por favor seleccione una de las opciones");
			} catch (NumberFormatException e) {
				System.out.println("Debe seleccionar uno de los números de las opciones");
			}
		input.close();
		}
	}

	private void consultar_pedido() {

	}

	private void finalizar_pedido() {

	}

	private void agregar_elemento() {

	}

	private void iniciar_pedido() {

	}

	public void mostrarMenu() {
		System.out.println("\nOpciones ");
	}
}