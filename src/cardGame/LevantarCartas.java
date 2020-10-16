package cardGame;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;


public class LevantarCartas {
	
	
	private String jsonFile;
	
	private String cartita;
	private String atr;
	private int atrValor;
	
	public LevantarCartas() {
		
		
		
	}
	
	  public  void armarMazo(String jsonFile) {
	        //URL url = getClass().getResource(jsonFile);
	        File jsonInputFile = new File(jsonFile);
	        InputStream is;
	        try {
	            is = new FileInputStream(jsonInputFile);
	            // Creo el objeto JsonReader de Json.
	            JsonReader reader = Json.createReader(is);
	            // Obtenemos el JsonObject a partir del JsonReader.
	            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
	            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
	                String nombreCarta = carta.getString("nombre");	             
	                	this.cartita = carta.getString("nombre");
	               // cartaAux.nombre = nombreCarta;
	                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
	                String atributosStr = "";
	                for (String nombreAtributo:atributos.keySet()) 
	                	this.atr = nombreAtributo;
	                	this.atrValor = atributos.getInt(nombreAtributo);
	                  //  atributosStr = atributosStr + nombreAtributo + ": " +
	                    //        atributos.getInt(nombreAtributo) + "; ";
	                    // 
	                	// aca crearia los objetos y le pasaria las variables para seterselo
	                	Atributo atributo = new Atributo(); 
	                	atributo.setNombre(atr);
	                	atributo.setValor(atrValor);
	                	Carta cartax = new Carta();
	                    cartax.setNombre(cartita); 
	                    cartax.agregarAtributo(atributo);
	                    //this.cartaAux.agregarAtributo(atr);
	                
	                Mazo mazito = new Mazo();
	                mazito.agregarCarta(cartax);
	                
	            }

	            reader.close();

	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }

	
	  
	  
}
