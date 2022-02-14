package logica;

import java.util.ArrayList;
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
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;

	ArrayList<Producto> productosPedido = new ArrayList<Producto>();

	// ************************************************************************
	// Constructores
	// ************************************************************************

	public Pedido(String nombreCliente, String direccionCliente) {
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
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

	public List<Map<String, Object>> consultarPedidos() {
		List<Map<String, Object>> pedidos = new ArrayList<Map<String, Object>>();
		for (Pedidos pedidosNombre : pedidos) {
			int id = pedidosNombre.darNombre().darDireccion();
			String nombre = pedidosNombre.darNombre().darDireccion();
			Map<String, Object> registro = new HashMap<String, Object>();
			registro.put("id", id);
			registro.put("nombre", nombre);
			registro.put("direccion", direccion);
			pedidosNombre.add(registro);
		}
		return pedidosNombre;
	}


	public void agregarProducto(Producto nuevoItem) {
		productosPedido.add(nuevoItem);
	}

	private int getPrecioNetoPedido() {
		return idPedido;

	}

	private int getPrecioTotalPedido() {
		return idPedido;

	}

	private int getPrecioIVAPedido() {
		return idPedido;

	}

	private String generarTextoFactura() {
		return direccionCliente;

	}

	public void guardarFactura(String archivo) {

	}
}
