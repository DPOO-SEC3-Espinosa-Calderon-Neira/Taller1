package logica;

public class ProductoMenu implements Producto {
	
	private String nombre;
	private int precioBase;
	
	public ProductoMenu(String nombre, int precioBase) {
		this.nombre = nombre;
		this.precioBase = precioBase;
	}
	
	/*
	 * Los siguientes m�todos son la implementaci�n de los m�todos
	 * en la clase Producto.
	 */
	
	public String getNombre() {
		return nombre;
	}
	
	public int getPrecio() {
		return precioBase;
	}
	
	public String generarTextoFactura() {
		
	}
}
