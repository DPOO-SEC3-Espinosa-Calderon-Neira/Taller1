package logica;

import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurante {

	private Pedido pedido;
	private ArrayList<Producto> productos;
	private ArrayList<Ingrediente> ingredientes;
	private ProductoMenu productoMenu;
	private Combo combo;

	public Restaurante() {
		
	}

	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		Pedido nuevoPedido = new Pedido(nombreCliente, direccionCliente);
	}

	public void cerrarYGuardarPedido() {

	}

	public Pedido getPedidoEnCurso() {
		return pedido;
	}

	public ArrayList<Producto> getMenuBase() {

	}

	public ArrayList<Ingrediente> getIngredientes() {

	}

	public static void cargarInfoRestaurante(String archivoIngredientes, String archivoMenu, String archivoCombos) throws IOException {
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
	}

	private static void cargarIngredientes(String archivoIngredientes) throws IOException {
		
		File file = new File(archivoIngredientes);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while((line = br.readLine()) != null){
		    //process the line
			String[] partes = line.split(";");
		    
		}

		br.close();
		
	}

	private static void cargarMenu(String archivoMenu) throws IOException {
		
		File file = new File(archivoMenu);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while((line = br.readLine()) != null){
		    //process the line
			String[] partes = line.split(";");
			String productoMenu = partes[0];
			int precioBase = Integer.parseInt(partes[1]);
			ProductoMenu nuevoProductoMenu = new ProductoMenu(productoMenu, precioBase);
			
			
			
		}

		br.close();
	}

	private static void cargarCombos(String archivoCombos) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(archivoCombos));
		String linea = br.readLine();
		while(linea != null) {
			String[] partes = linea.split(";");
			
		}

		br.close();
	}
}