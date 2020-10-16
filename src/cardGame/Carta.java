package cardGame;

import java.util.ArrayList;

public class Carta {
	String nombre;
	ArrayList<Atributo> atributos;
	
	
	public Carta() {
		this.atributos = new ArrayList();
	}
	
	
	public void agregarAtributo(Atributo a) {
		this.atributos.add(a);
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre; 
	}
	
}
