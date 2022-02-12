package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import logica.Pedido;
import logica.Restaurante;

public class Aplicacion {
	
	private Restaurante restaurante = new Restaurante();
	
	public static void main(String[] args) throws IOException {
		Aplicacion consola = new Aplicacion();
		consola.cargarArchivos();
		consola.ejecutarOpcion();
		
	}
	
	public void cargarArchivos() throws IOException {
		restaurante.cargarInfoRestaurante
				("C:\\Users\\danie\\OneDrive\\Documentos\\GitHub\\Taller1\\Taller 1 - Hamburguesas\\data\\ingredientes.txt", 
				"C:\\Users\\danie\\OneDrive\\Documentos\\GitHub\\Taller1\\Taller 1 - Hamburguesas\\data\\menu.txt",
				"C:\\Users\\danie\\OneDrive\\Documentos\\GitHub\\Taller1\\Taller 1 - Hamburguesas\\data\\combos.txt");
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
			//input.close();
		}
	}
	
	public void mostrarMenu() {
		System.out.println("\nOpciones ");
		System.out.println("1. Iniciar un pedido");
		System.out.println("2. Agregar elemento ");
		System.out.println("3. Finalizar pedido");
		System.out.println("4. Condsultar pedido");
		System.out.println("5. Salir");
		System.out.println("\nOpciones ");
		
	}
	
	private void iniciar_pedido() {
		String nombreCliente = input("Por favor ingrese su nombre");
		String direccionCliente = input("Por favor ingrese su direccion");
		Pedido pedido = new Pedido(nombreCliente, direccionCliente);
		System.out.println("\n---------- MENU ----------\n");
		System.out.println("1. Ver productos");
		System.out.println("2. Ver combos\n");
		int productosCombo = Integer.parseInt(input("Ingrese 1 para ver los productos y 2 para ver los combos"));
		if (productosCombo == 1) {
			System.out.println("\n---------- PRODUCTOS ----------\n");
			
			int numProducto = Integer.parseInt(input("Ingrese el numero del producto que desea agregar"));
		}
		else {
			System.out.println("\n---------- COMBOS ----------\n");
			int numProducto = Integer.parseInt(input("Ingrese el numero del producto que desea agregar"));
		}
		
	}
	
	private void agregar_elemento() {

	}
	
	private void finalizar_pedido() {

	}

	private void consultar_pedido() {

	}
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

}