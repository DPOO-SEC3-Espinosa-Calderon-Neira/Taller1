package logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase encapsula la informacion sobre los pedidos y calcula algunas cosas
 * sobre aquellos.
 */
public class Pedido {

	// ************************************************************************
	// Atributos
	// ************************************************************************

	private static int numeroPedidos;
	public int idPedido = 0;
	private String nombreCliente;
	private String direccionCliente;
	public double precioTotal = 0.0;

	ArrayList<HashMap<String, ArrayList<String>>> listaPedidos = new ArrayList<HashMap<String, ArrayList<String>>>();
	HashMap<String, ArrayList<String>> mapPedido = new HashMap<>();
	ArrayList<String> listaProductos = new ArrayList<String>();
	ArrayList<String> listaPrecios = new ArrayList<String>();

	// ************************************************************************
	// Constructores
	// ************************************************************************

	public Pedido(String nombreCliente, String direccionCliente) {

		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		listaPedidos.add(mapPedido);
		ArrayList<String> listaCliente = (ArrayList<String>) Arrays.asList(new String[] {nombreCliente});
		ArrayList<String> listaDireccion = (ArrayList<String>) Arrays.asList(new String[] {direccionCliente});
		mapPedido.put("Nombre cliente", listaCliente);
		mapPedido.put("Direccion cliente", listaDireccion);
	}

	// ************************************************************************
	// Metodos para consultar los atributos
	// ************************************************************************

	public int getIdPedido() {
		return idPedido;
	}

	public String getNombre() {
		return nombreCliente;
	}

	public String getDireccion() {
		return direccionCliente;
	}
	
	public static int getNumeroPedidos() {
		return numeroPedidos;
	}

	// ************************************************************************
	// Otros metodos
	// ************************************************************************

	/**
	 * Registra en la lista de pedidos un nuevo pedido
	 * 
	 * @param nuevoPedido
	 */

	/**
	 * Compila la informacion
	 * 
	 * @return Una lista de mapas con la informacion de los pedidos. Cada registro
	 *         queda en un mapa con tres llaves: "id", "nombre" y "direccion.
	 */

	public void agregarProducto(Producto nuevoItem) {
		
		listaProductos.add(nuevoItem.getNombre());
		double precioItem = nuevoItem.getPrecio();
		String precioItemStr = Double.toString(precioItem);
		listaPrecios.add(precioItemStr);
		mapPedido.put("Productos", listaProductos);
		mapPedido.put("Precios", listaPrecios);
		this.precioTotal += nuevoItem.getPrecio();
	}

	private double getPrecioNetoPedido() {
		return precioTotal;
	}

	private double getPrecioTotalPedido() {
		
		double precioTotal = (getPrecioNetoPedido() * 0.19) + getPrecioNetoPedido();
		return precioTotal;
	}

	private double getPrecioIVAPedido() {
		
		double precioIva = getPrecioNetoPedido() * 0.19;
		return precioIva;
	}

	private String generarTextoFactura() {
		
		String neto = String.valueOf(getPrecioNetoPedido());
		String total = String.valueOf(getPrecioTotalPedido());
		String iva = String.valueOf(getPrecioIVAPedido());
		String mensaje = "El valor neto de su pedido es: " + neto + ". El valor total de su pedido es: " + total + ". El IVA es su pedido es: " + iva;
		return mensaje;
	}

	public String guardarFactura() {
		return generarTextoFactura(); 
	}
}
