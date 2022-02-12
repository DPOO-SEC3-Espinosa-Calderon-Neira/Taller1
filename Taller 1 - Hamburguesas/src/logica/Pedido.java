package logica;

public class Pedido {

	private static int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;

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
