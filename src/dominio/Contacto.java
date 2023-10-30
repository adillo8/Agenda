package dominio;
public class Contacto{

    private String nombre;
    private int numeroDeTelefono;
    
    
    public void setNombre(String nombre)
    {this.nombre = nombre;}
    public void setNumeroDeTelefono(int numeroDeTelefono)
    {this.numeroDeTelefono = numeroDeTelefono;}
    
    public String getNombre()
    {return nombre;}
    public int getNumeroDeTelefono()
    {return numeroDeTelefono;}
   
    public Contacto(String nombre,int numeroDeTelefono)
    {
        this.nombre = nombre;
        this.numeroDeTelefono = numeroDeTelefono;
    }

    public String toString()
	{
		String result =  ( "El contacto llamado: " + this.nombre + "tiene el numero " + this. numeroDeTelefono );
		return result;
    }
	
}