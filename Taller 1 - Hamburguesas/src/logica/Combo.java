package logica;

public class Combo implements Producto {

	private double descuento;
	private String nombreCombo;

	public Combo(double descuento, String nombreCombo) {
		this.descuento = descuento;
		this.nombreCombo = nombreCombo;
	}
	
	public void agregarItemACombo(Producto itemCombo) {
		String cambios = "CAMBIOS PRUEBA";
	}
	
	/*
	 * Los siguientes métodos son la implementación de los métodos
	 * en la clase Producto.
	 */

	public String getNombre() {

	}
	
	public int getPrecio() {

	}
	
	public String generarTextoFactura() {
		
	}
}
