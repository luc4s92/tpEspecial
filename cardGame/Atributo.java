package cardGame;

public class Atributo {
	String nombre;
	int valor;
	
	
	public Atributo() {
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getValor() {
		return valor;
	}
	


	public void setValor(int valor) {
		this.valor = valor;
	}
	
	@Override
	public boolean equals(Object o) {
		try {
			Atributo aux = (Atributo) o;
			return this.getNombre().equals(aux.getNombre());
			
		}
		
		catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return this.nombre + ": " + this.valor + ";";
	}
}
