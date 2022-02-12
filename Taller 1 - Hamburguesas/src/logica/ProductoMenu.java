package logica;

public class ProductoMenu implements Producto {
	
	private String nombre;
	private int precioBase;
	
	public ProductoMenu(String nombre, int precioBase) {
		this.nombre = nombre;
		this.precioBase = precioBase;
	}
	
	/*
	 * Los siguientes métodos son la implementación de los métodos
	 * en la clase Producto.
	 */
	
	public String getNombre() {
		return nombre;
	}
	
	public double getPrecio() {
		return precioBase;
	}
	
	public String generarTextoFactura() {
		return "";
	}
}
