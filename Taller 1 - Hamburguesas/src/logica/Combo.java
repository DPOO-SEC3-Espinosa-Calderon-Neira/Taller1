package logica;

public class Combo implements Producto {

	private double descuento;
	private String nombreCombo;

	public Combo(double descuento, String nombreCombo) {
		this.descuento = descuento;
		this.nombreCombo = nombreCombo;
	}
	
	public void agregarItemACombo(Producto itemCombo) {
		
	}
	
	/*
	 * Los siguientes m�todos son la implementaci�n de los m�todos
	 * en la clase Combo.
	 */

	public String getNombre() {
		return nombreCombo;
	}
	
	public double getPrecio() {
		return descuento;
	}
	
	public String generarTextoFactura() {
		return "";
	}
}
