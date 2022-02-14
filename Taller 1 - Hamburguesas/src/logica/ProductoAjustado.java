package logica;

import consola.Aplicacion;

public class ProductoAjustado implements Producto {
	
	private Aplicacion apliacion;
	private double precio;
	
	public ProductoAjustado(ProductoMenu base) {
		precio = base.getPrecio();
		for (int i = 0; i < apliacion.ingredientesAgregados.size(); i++) {
			precio += apliacion.ingredientesAgregados.get(i).getCostoAdicional();
		}
		
	}
	
	/*
	 * Los siguientes m�todos son la implementaci�n de los m�todos
	 * en la clase Producto.
	 */
	
	public String getNombre() {
		return null;
		
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public String generarTextoFactura() {
		return null;
		
	}
}
