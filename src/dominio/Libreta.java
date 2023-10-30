package dominio;
import java.util.ArrayList;

public class Libreta{

    private String nombreContacto;
    
    private ArrayList <Libreta> libreta = new ArrayList<>();
	public Libreta (String nombre){
		this.nombreContacto = nombreContacto;
    }

    public Libreta addContacto (Libreta lib){
		libreta.add(lib);
		return this;
		}
	
    public String toString (){
		String cad = "Sus contactos son: " + nombreContacto ;
		for (Libreta lib: libreta)
		cad+= (lib + "\n");
		return cad;
       }
        









}