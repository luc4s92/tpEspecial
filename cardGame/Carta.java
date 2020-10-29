package cardGame;

import java.util.ArrayList;

public class Carta {
	String nombre;
	ArrayList<Atributo> atributos;
	
	
	public Carta() {
		atributos = new ArrayList();
		
	}
	
	
	public void agregarAtributo(Atributo a) {
		this.atributos.add(a);
	}
	
	public String getNombreCarta() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre; 
	}
	
	public ArrayList<Atributo> getAtributos() {
		ArrayList<Atributo> aux = new ArrayList();
		for(int i = 0; i < this.atributos.size(); i++) {
			aux.add(this.atributos.get(i));
		}
				
		return aux;
	}
	
	public Atributo getAtributo(int atributo) {
		return atributos.get(atributo);
	}
	
	public int getCantAtr() {
		return atributos.size();
	}
	
	public boolean comparaCarta(Carta c) {
		Atributo auxA = new Atributo();
		if (! (this.getCantAtr() == c.getCantAtr()) ) {
			return false;
		}
		else
			for(int i = 0; i < this.atributos.size(); i++) {
				auxA = c.getAtributos().get(i);        
				if(! this.atributos.contains(auxA))   //revisar si sin el for funciona
					return false;
			}
				
		return true;
	}
	
	public ArrayList<String> getNombresAtributos(){
		ArrayList<String> aux = new ArrayList();
		for(int i = 0; i < this.atributos.size(); i++) {
			aux.add(this.atributos.get(i).getNombre());
		}
		return aux;
	}
	
	
	@Override
	
	public String toString() {
		
		return this.nombre + " " +this.getAtributos();
	}
	
	
	
	
}
