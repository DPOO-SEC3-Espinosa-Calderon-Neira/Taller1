package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import logica.Combo;
import logica.Ingrediente;
import logica.Pedido;
import logica.ProductoMenu;
import logica.ProductoAjustado;
import logica.Restaurante;

public class Aplicacion {
	
	public static ArrayList<HashMap<String, ArrayList<String>>> listaPedidos = new ArrayList<HashMap<String, ArrayList<String>>>();
	private Restaurante restaurante = new Restaurante();
	private Pedido pedido;
	private String modificacion = "";
	
	public static void main(String[] args) throws IOException {
		Aplicacion consola = new Aplicacion();
		System.out.println("\n   ---------------------------       BIENVENIDO       ---------------------------   ");
		System.out.println("\nPide tu comida a traves de nuestra App y disfrutalo desde la comodidad de tu casa.");
		System.out.println("\nIngresa 1 para iniciar tu pedido.");
		consola.cargarArchivos();
		consola.ejecutarOpcion();
	}
	
	public void cargarArchivos() throws IOException {
		 /*	
		restaurante.cargarInfoRestaurante("C:\\Users\\neira\\Desktop\\Eclipse\\Taller1\\Taller 1 - Hamburguesas\\data\\ingredientes.txt",
				"C:\\Users\\neira\\Desktop\\Eclipse\\Taller1\\Taller 1 - Hamburguesas\\data\\menu.txt", 
				"C:\\Users\\neira\\Desktop\\Eclipse\\Taller1\\Taller 1 - Hamburguesas\\data\\combos.txt");
		*/
   
		restaurante.cargarInfoRestaurante
		("./data/ingredientes.txt", 
				"./data//menu.txt",
				"./data/combos.txt");

	}

	public void ejecutarOpcion() {
		boolean iniciado = false;
		boolean agregado = false;
		boolean finalizado = false;
		boolean continuar = true;
		int enProgreso = 0;
		while (continuar) {
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("\nPor favor seleciona una opcion"));
				if (opcion_seleccionada == 1) {
					if (enProgreso == 1) {
						System.out.print("\nDebes finalizar tu pedido antes de poder iniciar uno nuevo");
					}
					else {
						iniciado = true;
						enProgreso = 1;
						iniciar_pedido();
					}
				}
				else if (opcion_seleccionada == 2) {
					if (iniciado) {
						agregar_elemento();
						agregado = true;
					}
					else
						System.out.print("\nDebes iniciar un pedido antes de ver el menu.");
				}
				else if (opcion_seleccionada == 3) {
					if (iniciado) {
						if (agregado) {
							finalizar_pedido();
							finalizado = true;
							iniciado = false;
							agregado = false;
						}
						else
							System.out.print("\nDebes ver el menu y ordenar algun producto antes de finalizar tu pedido.");
					}
					else
						System.out.print("\nNo puedes finalizar tu pedido antes de iniciarlo.");
				}				
				else if (opcion_seleccionada == 4)
					
					if (finalizado)
							consultar_pedido();
					else
							System.out.print("\nDebes finalizar tu pedido antes de poder consultarlo.");
					
				else if (opcion_seleccionada == 5) {
					System.out.println("\nSaliendo de la aplicacion...");
					continuar = false;
				} 
				else
					System.out.println("\nDebes seleccionar uno de los numeros de las opciones");
			}
			catch (NumberFormatException e)
			{
				System.out.println("\nDebes seleccionar uno de los numeros de las opciones");
			}
		}
	}
	
	public void mostrarMenu() {
		System.out.println("\n\nOpciones ");
		System.out.println("1. Iniciar pedido ");
		System.out.println("2. Ver menu ");
		System.out.println("3. Finalizar mi pedido");
		System.out.println("4. Consultar mi pedido");
		System.out.println("5. Salir");	
	}
	
	private void iniciar_pedido() {
		String nombreCliente = input("\nPor favor ingresa tu nombre");
		String direccionCliente = input("Por favor ingresa la direccion de envio");
		Pedido.idPedido += 1;
		
		this.pedido = restaurante.iniciarPedido(nombreCliente, direccionCliente);
		System.out.println("\nHola " + nombreCliente + ", recuerda que el ID de tu pedido es: " + Pedido.idPedido + ".");
		System.out.println("Selecciona la opcion 2 para ver el menu.");
	}
	
	private void agregar_elemento() {
		System.out.println("\n-------------------- MENU --------------------\n");
		System.out.println("1. VER PRODUCTOS");
		System.out.println("2. VER COMBOS\n");
		boolean continuar = true;
		while (continuar) {
			try {
				int menu = Integer.parseInt(input("Ingresa 1 para ver los productos y 2 para ver los combos"));
				//input = 1 -> Agregar productos
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
						try {
							int numProducto = Integer.parseInt(input("\nIngresa el numero del producto que deseas agregar"));
							if (numProducto > productosMenu.size()) //verificar que ingrese un numero dentro de la lista
								System.out.println("\nPor favor ingresa una opcion valida.\n");
							else {
								continuarP = false;
								ProductoMenu valorP = productosMenu.get(numProducto-1);
								
								//Agregar o quitar ingrediente
								boolean continuar0 = true;
								
								while (continuar0) {
									try {
										int modificar = Integer.parseInt(input("\nPara agregar o quitar algun ingrediente ingresa 1. De lo contrario ingresa 0"));
										//input = 1 -> modificar
										if (modificar == 1){
											ProductoAjustado valorPA = new ProductoAjustado(valorP);
											continuar0 = false;
											boolean continuar1 = true;
											while (continuar1) {
												try {
													System.out.println("\n--------------- INGREDIENTES ---------------\n");
													ArrayList<Ingrediente> ingredientes = restaurante.getIngredientes();
													for (int i = 0; i < ingredientes.size(); i++) {
														Ingrediente valorI = ingredientes.get(i);
														System.out.println((i+1) + ". " + valorI.getNombre() + " ----------------- $" + valorI.getCostoAdicional());
													}
													
													boolean continuarI = true;
													while (continuarI) {
														try {
															int numIngrediente = Integer.parseInt(input("\nIngresa el numero del ingrediente que deseas agregar o quitar"));
															if (numIngrediente > ingredientes.size()) //verificar que ingrese un numero dentro de la lista
																System.out.println("\nPor favor ingresa una opcion valida.\n");
															else {
																continuarI = false;
																Ingrediente valorI = ingredientes.get(numIngrediente-1);
																
																boolean continuar12 = true;
																while (continuar12) {
																	try {
																		int accionIngrediente = Integer.parseInt(input("\nIngresa 1 para agregar el ingrediente o 0 para quitarlo"));
																		//input = 1 -> agregar
																		if (accionIngrediente == 1) {
																			modificacion += " con " + valorI.getNombre();
																			
																			valorPA.ingredientesAgregados.add(valorI);
																			continuar1 = false;
																			continuar12 = false;
																		}
																		//input = 0 -> quitar
																		else if (accionIngrediente == 0) {
																			
																			modificacion += " sin " + valorI.getNombre(); 
																			//quitar ingrediente
																			continuar1 = false;
																			continuar12 = false;
																		}
																		else
																			System.out.println("\nPor favor ingresa una opcion valida.\n");
																	}
																	catch (NumberFormatException e)
																	{
																		System.out.println("\nPor favor ingresa una opcion valida.\n");
																	}
																}
																boolean continuar2 = true;
																while (continuar2) {
																	try {
																		int seguir = Integer.parseInt(input("Para seguir modificando los ingredientes del producto " + valorP.getNombre() + " ingresa 1. De lo contrario ingresa 0"));
																		//input = 1 -> seguir modificando el producto
																		if (seguir == 1){
																			continuar1 = true;
																			continuar2 = false;
																		}
																		//input = 0 -> agregar el producto
																		else if (seguir == 0) {
																			
																			pedido.agregarProducto(valorPA);
																			System.out.println("\nEl producto " + valorP.getNombre() + modificacion + " se agrego correctamente a tu pedido.");
																			System.out.println("\nTotal: $" + pedido.precioTotal);
																			System.out.println("Para seguir agregando elementos selecciona la opcion 2.");
																			continuar2 = false;
																		}
																		else
																			System.out.println("\nPor favor ingresa una opcion valida.\n");
																	}
																	catch (NumberFormatException e)
																	{
																		System.out.println("\nPor favor ingresa una opcion valida.\n");
																	}
																}
															}
														}
														catch (NumberFormatException e)
														{
															System.out.println("\nPor favor ingresa una opcion valida.\n");
														}
													}
													
												}
												catch (NumberFormatException e)
												{
													System.out.println("\nPor favor ingresa una opcion valida.\n");
												}
											}
										}
										//input = 0 -> NO modificar
										else if (modificar == 0) {
											continuar0 = false;
											pedido.agregarProducto(valorP);
											System.out.println("\nEl producto " + valorP.getNombre() + " se agrego correctamente a tu pedido.");
											System.out.println("\nTotal: $" + pedido.precioTotal);
											System.out.println("Para seguir agregando elementos selecciona la opcion 2. Para finalizar tu pedido ingresa 3.");
										}
										else 
											System.out.println("\nPor favor ingresa una opcion valida.\n");
									}
									catch (NumberFormatException e)
									{
										System.out.println("\nPor favor ingresa una opcion valida.\n");
									}
								}
							}
						}
						catch (NumberFormatException e)
						{
							System.out.println("\nPor favor ingresa una opcion valida.\n");
						}
					}
				}
				//input = 2 -> Agregar combo
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
							System.out.println("\nPor favor ingresa una opcion valida.\n");
						else {
							continuarC = false;
							Combo valorC = combos.get(numCombo-1);
							pedido.agregarProducto(valorC);
							System.out.println("\nEl " + valorC.getNombre() + " se agrego correctamente a tu pedido.");
							System.out.println("\nTotal: $" + pedido.precioTotal);
							System.out.println("Para seguir agregando elementos selecciona la opcion 2. Para finalizar tu pedido ingresa 3.");
						}
					}
				}
				else
					System.out.println("\nPor favor ingresa una opcion valida.\n");
			}
			catch (NumberFormatException e)
			{
				System.out.println("\nPor favor ingresa una opcion valida.\n");
			}
		}
	}
	
	private void finalizar_pedido() {
		System.out.println(restaurante.cerrarYGuardarPedido());
		System.out.println("Gracias por comprar con nosotros.");
	}

	private void consultar_pedido() 
		{
		boolean continuarC = true;
		while (continuarC) 
			{
			int id = Integer.parseInt(input("Ingrese el ID de su pedido"));
			if (pedido.contains(id))
			{
				continuarC = false;
				HashMap<String, ArrayList<String>> pedido = restaurante.getPedidoEnCurso(id);
				ArrayList<String> nombre = pedido.get("Nombre cliente");
				System.out.println("Nombre del cliente: " + nombre);
				ArrayList<String> direccion = pedido.get("Direccion cliente");
				System.out.println("Direccion de envío: " + direccion);
				ArrayList<String> productos = pedido.get("Productos");
				System.out.println("Orden: " + productos);
			}
			else {
				System.out.println("\nPor favor ingresa una opcion valida.\n");
			 	}
			}
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