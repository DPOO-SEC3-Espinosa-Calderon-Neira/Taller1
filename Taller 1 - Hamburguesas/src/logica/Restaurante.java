package logica;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurante {
	
	private Pedido pedido;
	private Ingrediente ingrediente;
	
	public Restaurante() {
		
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		Pedido nuevoPedido = new Pedido(nombreCliente, direccionCliente);
	}
	
	public void cerrarYGuardarPedido() {
		
	}
	
	public Pedido getPedidoEnCurso() {
		return pedido;
	}
	
	public ArrayList<Producto> getMenuBase() {
		
	}
	
	public ArrayList<Ingrediente> getIngredientes() {
		
	}
	
	public void cargarInfoRestaurante(String archivoIngredientes, String archivoMenu,  String archivoCombos) {
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
	}
	
	private void cargarIngredientes(String archivoIngredientes) {
		
	}
	
	private void cargarMenu(String archivoMenu) {
		
	}

	private void cargarCombos(String archivoCombos) {
	
	}
}
