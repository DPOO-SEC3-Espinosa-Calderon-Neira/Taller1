package logica;

import java.util.ArrayList;

public class ProductoAjustado implements Producto {
	
	private double precio;
	public static String nombre;

	public ArrayList<Ingrediente> ingredientesAgregados = new ArrayList<Ingrediente>();
	
	public ProductoAjustado(ProductoMenu base) {
		precio = base.getPrecio();
		nombre = base.getNombre();
	}
	
	/*
	 * Los siguientes metodos son la implementacion de los metodos
	 * en la clase Producto.
	 */
	
	public String getNombre() {
		return nombre;
		
	}
	
	public double getPrecio() {
		for (int i = 0; i < ingredientesAgregados.size(); i++) {
			precio += ingredientesAgregados.get(i).getCostoAdicional();
		}
		return precio;
	}
	
	public String generarTextoFactura() {
		return null;
	}
}
