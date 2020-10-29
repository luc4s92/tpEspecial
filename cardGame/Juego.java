package cardGame;

import java.util.ArrayList;


public class Juego {
	private int rondas;

	public Juego(int rondas) {

		this.rondas = rondas;

	}
	
	
	public void repartirMazo(Jugador j1, Jugador j2, Mazo m) {
		// Reparte el mazo y saca la carta que no va
		ArrayList<Carta> cartas = m.getCartas();
		
		for(int i = 0; i< cartas.size(); i++) {
			if ((i%2) == 0) {
				j1.getMazoJ().agregarCarta(cartas.get(i));
			}
			else {
				j2.getMazoJ().agregarCarta(cartas.get(i));
			}
				
		}
	}
	
	
	
	
	

	private void ganadorSeQuedaCarta(Jugador ganador, Jugador perdedor, int i) {
		ganador.getMazoJ().agregarCarta(perdedor.getMazoJ().getCarta(i)); // forma interna
		perdedor.getMazoJ().eliminarCarta(); // metodo que pase una posicion y remueva en el mazo
	}
	
	public void jugar(Jugador j1, Jugador j2) {
		int turno = 1;
		int atr = j1.getMazoJ().getRandomAtr();
		int i = 0;
//		for (int i = 0; i < this.rondas; i++) { //cambiar por un ciclo while
			while( i < rondas && ( j1.getMazoJ().getCantCartas()!= 0) && ( j2.getMazoJ().getCantCartas())!= 0) {
//	if (( j1.getMazoJ().getCantCartas()!= 0) && ( j2.getMazoJ().getCantCartas())!= 0) {

				if (j1.getMazoJ().getCarta(i).getAtributo(atr).equals(j2.getMazoJ().getCarta(i).getAtributo(atr))) // preguntar
																													// si
																													// es
																													// necesaria
																													// esta
																													// linea
					if (j1.getMazoJ().getCarta(i).getAtributo(atr).getValor() > j2.getMazoJ().getCarta(i)
							.getAtributo(atr).getValor()) {

						System.out.println("--------- Ronda " + turno + "--------");
						System.out.println(
								"El jugador " + j1.getNombre() + " es " + j1.getMazoJ().getCarta(i).getNombreCarta()
										+ " con " + j1.getMazoJ().getCarta(i).getAtributo(atr));
						System.out.println(
								"El jugador " + j2.getNombre() + " es " + j2.getMazoJ().getCarta(i).getNombreCarta()
										+ " con " + j2.getMazoJ().getCarta(i).getAtributo(atr));
						System.out.println("gana la ronda " + j1.getNombre());

						ganadorSeQuedaCarta(j1, j2, i);
						System.out.println(j1.getMazoJ().getCantCartas());
						atr = j1.getMazoJ().getRandomAtr();
						turno++;

					} else {
						System.out.println("--------- Ronda " + turno + "--------");
						System.out.println(
								"El jugador " + j2.getNombre() + " es " + j2.getMazoJ().getCarta(i).getNombreCarta()
										+ " con " + j2.getMazoJ().getCarta(i).getAtributo(atr));
						System.out.println(
								"El jugador " + j1.getNombre() + " es " + j1.getMazoJ().getCarta(i).getNombreCarta()
										+ " con " + j1.getMazoJ().getCarta(i).getAtributo(atr));
						System.out.println("gana la ronda " + j2.getNombre());

						ganadorSeQuedaCarta(j2, j1, i);
						System.out.println(j2.getMazoJ().getCantCartas());
						atr = j2.getMazoJ().getRandomAtr();
						turno++;
					}
				i++;
			}
			
			// aca deberia devolver quien es el ganador
	//	}

	}

}
