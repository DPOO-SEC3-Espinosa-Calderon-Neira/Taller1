package logica;


public class Combo implements Producto {

	private double descuento;
	private String nombreCombo;

	public Combo(double descuento, String nombreCombo) {
		this.setDescuento(descuento);
		this.nombreCombo = nombreCombo;
	}
	
	/*
	 * Los siguientes metodos son la implementacion de los metodos
	 * en la clase Producto.
	 */

	public String getNombre() {
		return nombreCombo;
	}
	
	public double getPrecio() {
		return descuento;
	}
	
	public String generarTextoFactura() {
		return nombreCombo;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
}