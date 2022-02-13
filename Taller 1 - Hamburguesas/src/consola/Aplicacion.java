package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import logica.Combo;
import logica.Ingrediente;
import logica.Pedido;
import logica.ProductoMenu;
import logica.Restaurante;

public class Aplicacion {
	
	private Restaurante restaurante = new Restaurante();
	private Pedido pedido;
	private double total = 0;
	
	public static void main(String[] args) throws IOException {
		Aplicacion consola = new Aplicacion();
		System.out.println("\n   ---------------------------       BIENVENIDO       ---------------------------   ");
		System.out.println("\nCrea tu perdido a través de nuestra App y disfrutalo desde la comodidad de tu casa.");
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
		boolean continuar = true;
		while (continuar) {
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("\nPor favor seleciona una opción"));
				if (opcion_seleccionada == 1)
					iniciar_pedido();
				else if (opcion_seleccionada == 2)
					agregar_elemento();
				else if (opcion_seleccionada == 3)
					finalizar_pedido();
				else if (opcion_seleccionada == 4)
					consultar_pedido();
				else if (opcion_seleccionada == 5) {
					System.out.println("\nSaliendo de la aplicación...");
					continuar = false;
				} 
				else
					System.out.println("\nDebes seleccionar uno de los números de las opciones");
			}
			catch (NumberFormatException e)
			{
				System.out.println("\nDebes seleccionar uno de los números de las opciones");
			}
		}
	}
	
	public void mostrarMenu() {
		System.out.println("\nOpciones ");
		System.out.println("1. Iniciar un pedido");
		System.out.println("2. Agregar elemento ");
		System.out.println("3. Finalizar pedido");
		System.out.println("4. Consultar pedido");
		System.out.println("5. Salir");	
	}
	
	private void iniciar_pedido() {
		String nombreCliente = input("\nPor favor ingresa su nombre");
		String direccionCliente = input("Por favor ingresa su direccion");
		pedido = new Pedido(nombreCliente, direccionCliente);
		System.out.println("\nHola " + nombreCliente + ", selecciona la opción 2 para ver el menu y agregar elementos a tu pedido.");
	}
	
	private void agregar_elemento() {
		System.out.println("\n-------------------- MENU --------------------\n");
		System.out.println("1. VER PRODUCTOS");
		System.out.println("2. VER COMBOS\n");
		boolean continuar = true;
		while (continuar) {
			int menu = Integer.parseInt(input("Ingresa 1 para ver los productos y 2 para ver los combos"));
			//Agregar productos
			if (menu == 1) {
				continuar = false;
				System.out.println("\n--------------- PRODUCTOS ---------------\n");
				ArrayList<ProductoMenu> productosMenu = restaurante.getMenuBase();
				for (int i = 0; i < productosMenu.size(); i++) {
					ProductoMenu valorP = productosMenu.get(i);
					System.out.println((i+1) + ". " + valorP.getNombre() + " ----------------- $" + valorP.getPrecio());
				}
				boolean continuarP = true;
				while (continuarP) {
					int numProducto = Integer.parseInt(input("\nIngresa el numero del producto que deseas agregar"));
					if (numProducto > productosMenu.size())
						System.out.println("\nPor favor ingresa una opción válida.\n");
					else {
						continuarP = false;
						ProductoMenu valorP = productosMenu.get(numProducto-1);
						
						//Agregar o quitar ingrediente
						boolean continuar0 = true;
						while (continuar0) {
							int modificar = Integer.parseInt(input("\nPara agregar o quitar algún ingrediente ingresa 1. De lo contrario ingresa 0"));
							//modificar
							if (modificar == 1){
								continuar0 = false;
								boolean continuar1 = true;
								while (continuar1) {
									System.out.println("\n--------------- INGREDIENTES ---------------\n");
									ArrayList<Ingrediente> ingredientes = restaurante.getIngredientes();
									for (int i = 0; i < ingredientes.size(); i++) {
										Ingrediente valorI = ingredientes.get(i);
										System.out.println((i+1) + ". " + valorI.getNombre() + " ----------------- $" + valorI.getCostoAdicional());
									}
									int numIngrediente = Integer.parseInt(input("\nIngresa el numero del ingrediente que deseas agregar o quitar"));
									Ingrediente valorI = ingredientes.get(numIngrediente-1);
									boolean continuar12 = true;
									while (continuar12) {
										int accionIngrediente = Integer.parseInt(input("\nIngresa 1 para agregar el ingrediente o 0 para quitarlo"));
										if (accionIngrediente == 1) {
											//agregar ingrediente y producto modificado
											
											//modificar precio
											total += valorI.getCostoAdicional();
											continuar1 = false;
											continuar12 = false;
										}
										else if (accionIngrediente == 0) {
											//quitar ingrediente
											continuar1 = false;
											continuar12 = false;
										}
										else
											System.out.println("\nPor favor ingresa una opción válida.\n");
									}
									boolean continuar2 = true;
									while (continuar2) {
										int seguir = Integer.parseInt(input("Para seguir agregando o quitando ingredientes del producto " + valorP.getNombre() + " ingresa 1. De lo contrario ingresa 0"));
										if (seguir == 1){
											continuar1 = true;
											continuar2 = false;
										}
										else if (seguir == 0) {
											//pedido.agregarProducto(valorP);
											total += valorP.getPrecio();
											System.out.println("\nEl producto " + valorP.getNombre() + " se agregó correctamente a tu pedido.");
											System.out.println("\nTotal: $" + total);
											System.out.println("Para seguir agregando elementos selecciona la opción 2.");
											continuar2 = false;
										}
										else
											System.out.println("\nPor favor ingresa una opción válida.\n");
									}
								}
							}
							//NO modificar
							else if (modificar == 0) {
								continuar0 = false;
								pedido.agregarProducto(valorP);
								total += valorP.getPrecio();
								System.out.println("\nEl producto " + valorP.getNombre() + " se agregó correctamente a tu pedido.");
								System.out.println("\nTotal: $" + total);
								System.out.println("Para seguir agregando elementos selecciona la opción 2.");
							}
							else 
								System.out.println("\nPor favor ingresa una opción válida.\n");
						}
					}
				}
			}
			//Agregar combo
			else if (menu == 2){
				continuar = false;
				System.out.println("\n--------------- COMBOS ---------------\n");
				ArrayList<Combo> combos = restaurante.getCombos();
				for (int i = 0; i < combos.size(); i++) {
					Combo valorC = combos.get(i);
					System.out.println((i+1) + ". " + valorC.getNombre() + " ----------------- $" + valorC.getPrecio());
				}
				boolean continuarC = true;
				while (continuarC) {
					int numCombo = Integer.parseInt(input("\nIngresa el numero del combo que deseas agregar"));
					if (numCombo > combos.size())
						System.out.println("\nPor favor ingresa una opción válida.\n");
					else {
						continuarC = false;
						Combo valorC = combos.get(numCombo-1);
						pedido.agregarProducto(valorC);
						total += valorC.getPrecio();
						System.out.println("\nEl combo " + valorC.getNombre() + " se agregó correctamente a tu pedido.");
						System.out.println("\nTotal: $" + total);
						System.out.println("Para seguir agregando elementos selecciona la opción 2.");
					}
				}
			}
			else
				System.out.println("\nPor favor ingresa una opción válida.\n");
		}
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