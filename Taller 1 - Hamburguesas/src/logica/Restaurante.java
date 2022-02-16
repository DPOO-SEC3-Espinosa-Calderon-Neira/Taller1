package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import consola.Aplicacion;

public class Restaurante {

	private Pedido pedido;
	private Ingrediente ingrediente;
	private ProductoMenu productoMenu;

	ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	ArrayList<ProductoMenu> productosMenu = new ArrayList<ProductoMenu>();
	ArrayList<Combo> combos = new ArrayList<Combo>();

	public Pedido iniciarPedido(String nombreCliente, String direccionCliente) {
		return this.pedido = new Pedido(nombreCliente, direccionCliente);
	}

	public String cerrarYGuardarPedido() {
		return pedido.guardarFactura();
	}

	public HashMap<String, ArrayList<String>> getPedidoEnCurso(int id) {
		return Aplicacion.listaPedidos.get(id);
	}

	public ArrayList<ProductoMenu> getMenuBase() {
		return productosMenu;
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	
	public ArrayList<Combo> getCombos() {
		return combos;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public ProductoMenu getProductoMenu() {
		return productoMenu;
	}

	public void cargarInfoRestaurante(String archivoIngredientes, String archivoMenu, String archivoCombos)	throws IOException {

		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
	}

	private void cargarIngredientes(String archivoIngredientes) throws IOException {

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

	private void cargarMenu(String archivoMenu) throws IOException {

		File file = new File(archivoMenu);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;

		while ((line = br.readLine()) != null) {
			String[] partes = line.split(";");
			String nombreProducto = partes[0];
			int precioBase = Integer.parseInt(partes[1]);
			ProductoMenu nuevoProductoMenu = new ProductoMenu(nombreProducto, precioBase);
			productosMenu.add(nuevoProductoMenu);
		}
		
		br.close();
	}

	private void cargarCombos(String archivoCombos) throws IOException {

		File file = new File(archivoCombos);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;

		while ((line = br.readLine()) != null) {
			String[] partes = line.split(";");
			String nombreCombo = partes[0]+" ("+partes[2]+", "+partes[3]+", "+partes[4]+")";
			
			String descuentoStr = partes[1];
			descuentoStr = descuentoStr.replace("%", "");
			double descuento = Double.parseDouble(descuentoStr) / 100;
			String productoMenu1 = partes[2];
			String productoMenu2 = partes[3];
			String productoMenu3 = partes[4];
			
			double precio = 0;

			for (int i = 0; i < productosMenu.size(); i++) {
				ProductoMenu valor = productosMenu.get(i);
				
				if (valor.getNombre().equals(productoMenu1)) {
					precio += valor.getPrecio();
				} else if (valor.getNombre().equals(productoMenu2)) {
					precio += valor.getPrecio();
				} else if (valor.getNombre().equals(productoMenu3)) {
					precio += valor.getPrecio();
				}
			}

			descuento = descuento * precio;
			descuento = precio - descuento;
			Combo combo_descuento = new Combo(descuento, nombreCombo);
			combos.add(combo_descuento);
		}
		br.close();
	}
}