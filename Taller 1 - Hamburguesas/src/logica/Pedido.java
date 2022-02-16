package logica;

import java.util.ArrayList;
import java.util.HashMap;
import consola.Aplicacion;

/**
 * Esta clase encapsula la informacion sobre los pedidos y calcula algunas cosas
 * sobre aquellos.
 */
public class Pedido {

	// ************************************************************************
	// Atributos
	// ************************************************************************

	private static int numeroPedidos = 0;
	public static int idPedido = -1;
	private String nombreCliente;
	private String direccionCliente;
	public double precioTotal = 0.0;

	private HashMap<String, ArrayList<String>> mapPedido = new HashMap<String, ArrayList<String>>();
	private ArrayList<String> listaProductos = new ArrayList<String>();
	private ArrayList<String> listaPrecios = new ArrayList<String>();

	// ************************************************************************
	// Constructores
	// ************************************************************************

	public Pedido(String nombreCliente, String direccionCliente) {
		
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		ArrayList<String> nombre = new ArrayList<String>();
		ArrayList<String> direccion = new ArrayList<String>();
		nombre.add(nombreCliente);
		direccion.add(direccionCliente);
		mapPedido.put("Nombre cliente", nombre);
		mapPedido.put("Direccion cliente", direccion);
		Aplicacion.listaPedidos.add(mapPedido);
		
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
		this.precioTotal += precioItem;
		System.out.println("precio ajustado Pedido: " + precioItem);
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
		String mensaje = generarTextoFactura();
		return mensaje; 
	}

	public boolean contains(int id) {
		if (Aplicacion.listaPedidos.size() > id)
			return true;
		else
			return false;
	}
}