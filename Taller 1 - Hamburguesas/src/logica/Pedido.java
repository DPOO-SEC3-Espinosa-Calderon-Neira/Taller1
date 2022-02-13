package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Esta clase encapsula la información sobre los pedidos y calcula algunas cosas
 * sobre aquellos.
 */
public class Pedido 
{
	// ************************************************************************
	// Atributos
	// ************************************************************************
	
	/**
	 * El número de pedidos. Se asume que ...
	 */
	private static int numeroPedidos;
	
	
	/**
	 * El id del pedido
	 */
	private int idPedido;
	
	
	/**
	 * El nombre del cliente.
	 */
	private String nombreCliente;
	
	
	/**
	 * La dirección del cliente. 
	 */
	private String direccionCliente;
	
	/**
	 * Una lista con las participaciones registradas para el atleta.
	 */
	private List<numeroPedidos> numeroPedidos;
	
	// ************************************************************************
	// Constructores
	// ************************************************************************

	/**
	 * Construye un nuevo pedido e inicializa sus atributos con la información de
	 * los parámetros. La lista del pedido se inicializa como una lista
	 * vacía.
	 * 
	 * @param idPedidos El id del pedido.
	 * @param elNombre El nombre del cliente.
	 * @param laDireccion La dirección del cliente.
	 */
	public Pedido(int idPedido, String elNombre, String laDireccion)
	{
		this.pedido = idPedido;
		this.nombre = elNombre;
		this.direccion = laDireccion;
		this.numeroPedidos = new ArrayList<>();
	}

	// ************************************************************************
		// Métodos para consultar los atributos
		// ************************************************************************

		/**
		 * Consulta el id del pedido
		 * 
		 * @return id
		 */
		public String darIdPedido()
		{
			return nombre;
		}

		/**
		 * Consulta el nombre
		 * 
		 * @return nombre
		 */
		public Genero darNombre()
		{
			return genero;
		}

		/**
		 * Consulta la dirección
		 * 
		 * @return dirección
		 */
		public Pais darDireccion()
		{
			return pais;
		}
		
		// ************************************************************************
		// Otros métodos
		// ************************************************************************

		/**
		 * Registra en la lista de pedidos un nuevo pedido
		 * 
		 * @param nuevoPedido 
		 */
		public void nuevoPedido(Pedido nuevoPedido)
		{
			pedido.add(nuevoPedido);
		}

		/**
		 * Compila la información 
		 * 
		 * @return Una lista de mapas con la información de los pedidos. 
		 * 			Cada registro queda en un mapa con tres llaves: "id", 
		 * 			"nombre" y "dirección.
		 */
		public List<Map<String, Object>> consultarPedidos()
		{
			List<Map<String, Object>> pedidos = new ArrayList<Map<String, Object>>();
			for (Pedidos pedidosNombre : pedidos)
			{
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
	public Pedido(String nombreCliente, String direccionCliente) {
		this.setNombreCliente(nombreCliente);
		this.direccionCliente = direccionCliente;
	}

	
	public int getIdPedido() {
		return idPedido;
	}

	public void agregarProducto(Producto nuevoItem) {
		
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

	public static int getNumeroPedidos() {
		return numeroPedidos;
	}

	public static void setNumeroPedidos(int numeroPedidos) {
		Pedido.numeroPedidos = numeroPedidos;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
}
