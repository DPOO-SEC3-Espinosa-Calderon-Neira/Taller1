package logica;

import java.util.ArrayList;

import consola.Aplicacion;

public class ProductoAjustado implements Producto {
	
	private Aplicacion aplicacion;
	private double precio = 0.0;
	//
	public ArrayList<Ingrediente> ingredientesAgregados = new ArrayList<Ingrediente>();
	
	public ProductoAjustado(ProductoMenu base) {
		precio = base.getPrecio();
		System.out.println("precio ajustado: " + precio);
		for (int i = 0; i < ingredientesAgregados.size(); i++) {
			precio += ingredientesAgregados.get(i).getCostoAdicional();
			System.out.println("precio ajustado: " + precio);
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
