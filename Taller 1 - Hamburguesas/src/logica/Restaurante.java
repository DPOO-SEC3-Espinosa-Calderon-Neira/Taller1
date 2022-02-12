package logica;

import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;

import uniandes.dpoo.taller0.modelo.Evento;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurante {

	private Pedido pedido;
	private Producto producto;
	private Ingrediente ingrediente;
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

	public static void cargarInfoRestaurante(String archivoIngredientes, String archivoMenu, String archivoCombos)
			throws IOException {
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
	}

	private static void cargarIngredientes(String archivoIngredientes) throws IOException {
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		File file = new File(archivoIngredientes);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null) {
			String[] partes = line.split(";");
			String nombreIngrediente = partes[0];
			int costoAdicional = Integer.parseInt(partes[1]);
			Ingrediente nuevoIngrediente = new Ingrediente(nombreIngrediente, costoAdicional);
			ingredientes.add(nuevoIngrediente);
		}

		br.close();

	}

	private static void cargarMenu(String archivoMenu) throws IOException {
		ArrayList<ProductoMenu> productosMenu = new ArrayList<ProductoMenu>();
		File file = new File(archivoMenu);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null) {
			String[] partes = line.split(";");
			String productoMenu = partes[0];
			int precioBase = Integer.parseInt(partes[1]);
			ProductoMenu nuevoProductoMenu = new ProductoMenu(productoMenu, precioBase);
			productosMenu.add(nuevoProductoMenu);

		}

		br.close();
	}

	private static void cargarCombos(String archivoCombos) throws IOException {

		File file = new File(archivoCombos);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null) {
			String[] partes = line.split(";");
			String nombreCombo = partes[0];
			String descuentoStr = partes[1];
			descuentoStr = descuentoStr.replace("%", "");
			double descuento = Double.parseDouble(descuentoStr) / 100;

			String productoMenu1 = partes[2];
			String productoMenu2 = partes[3];
			String productoMenu3 = partes[4];

			// Producto producto = nuevoProductoMenu;
		}

		br.close();
	}
}