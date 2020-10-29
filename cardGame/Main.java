package cardGame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collections;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Main {

	public static void main(String[] args) {
		
		 //crear objeto atributo
		// crear objeto carta
		// crear objeto mazo
		//pasarlos por parametro a esa clase? y que me devuelva un mazo para poder armar el codigo?
		
		
		
		
		
		 Mazo nuevoMazo = armarMazo("./superheroes.json");
	
	     
	     Jugador j1 = new Jugador("juan");
	     Jugador j2 = new Jugador("Maria");
	     Juego juego = new Juego(5);
	   //  nuevoMazo.repartirMazo( j1, j2);
	     System.out.println(nuevoMazo.getCartas());
	     System.out.println(nuevoMazo.getCantCartas());
	     System.out.println("Repartio mazo");
	     
	 //    System.out.println(nuevoMazo.getCantCartas());
	   //  System.out.println(j1.getMazoJ().getCartas());
	    // System.out.println(j1.getMazoJ().getCantCartas());
	    // System.out.println("+++++++++++++++++++++++");
	   //  System.out.println(j2.getMazoJ().getCartas());
	   //  System.out.println(j2.getMazoJ().getCantCartas());
	       juego.repartirMazo(j1, j2,nuevoMazo);
	       juego.jugar(j1, j2);
	     
	     System.out.println(j1.getMazoJ().getCantCartas());
	     System.out.println(j2.getMazoJ().getCantCartas());
	     
	     
	}
	
	
	 public static Mazo armarMazo(String jsonFile) {
	        //URL url = getClass().getResource(jsonFile);
	        File jsonInputFile = new File(jsonFile);
	        InputStream is;
	        Mazo mazo = new Mazo();
	        try {
	        	 
	            is = new FileInputStream(jsonInputFile);
	            // Creo el objeto JsonReader de Json.
	            JsonReader reader = Json.createReader(is);
	            // Obtenemos el JsonObject a partir del JsonReader.
	            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
	            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
	                Carta cartax = new Carta();     
	               
	                cartax.setNombre(carta.getString("nombre"));
	               	
	                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
	                	                	                
	                	
	                for (String nombreAtributo:atributos.keySet()) 
	                	
	                {
	                	            
	               	    Atributo atributo = new Atributo();       	                
	                      
	               		           	
	                	
	                	atributo.setNombre(nombreAtributo);
	                	atributo.setValor(atributos.getInt(nombreAtributo));
	                
	                   
	                    cartax.agregarAtributo(atributo);                    
	                }
	             
	               		mazo.agregarCarta(cartax);
	            }
	            
	            reader.close();
	            return mazo;
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            return null ;
	        }
	    }

}
