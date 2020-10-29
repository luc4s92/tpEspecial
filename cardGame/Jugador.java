package cardGame;

import java.util.ArrayList;

public class Jugador {
	private String nombre;
	 Mazo mazoJ;
	
	
	
	public Jugador (String nombre) {
		this.mazoJ = new Mazo();
		this.nombre = nombre;
		
	}
	
	public Mazo getMazoJ() {
		
		return this.mazoJ;
		
		
		
	}
	
	

	
	public String getNombre() {
		return nombre;
	}
}
