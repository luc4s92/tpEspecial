package cardGame;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
	ArrayList<Carta> cartas;

	public Mazo() {
		this.cartas = new ArrayList();
	}

	private boolean cumpleAtributos(Carta c) {
		
		ArrayList<String>atributos = cartas.get(0).getNombresAtributos();
		if(c.getCantAtr() != cartas.get(0).getCantAtr())
			return false;

		for(int i = 0 ; i < atributos.size(); i++) {
			if(! atributos.contains(c.getAtributos().get(i).getNombre())) {
				return false;
			}
			
		}
		return true;
	}
	
	
	public void agregarCarta(Carta c) {
		if (cartas.size() == 0) {
			this.cartas.add(c);
		} else {
				if(this.cumpleAtributos(c))
					cartas.add(c);
				
		}
	}

	public ArrayList<Carta> getCartas() {

		return new ArrayList<Carta>(cartas);
	}

	public int getCantCartas() {
		return cartas.size();
	}

	public void eliminarCarta() {
		cartas.remove(0);
	}

	public int getRandomAtr() {

		int atrAleatorio = (int) (Math.random() * ((getCartas().get(0).getCantAtr())));
		return atrAleatorio;
	}



	public Carta getCarta(int carta) {
		return cartas.get(carta);
	}

}
