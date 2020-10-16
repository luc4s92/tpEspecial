package cardGame;

import java.util.ArrayList;

public class Mazo {
	ArrayList<Carta> cartas;
	
	
	public Mazo() {
		this.cartas = new ArrayList();
	}
	
	public void agregarCarta(Carta c) {
		this.cartas.add(c);
	}
	
}
