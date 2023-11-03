package dominio;
import java.io.Serializable;

public class Contacto implements Serializable{
    String nombre;
    String num_tel;

    public boolean equals(Object obj){
        Contacto c = (Contacto)obj;
        return nombre.equals((c.nombre));
    }

    public Contacto(String nombre, String num_tel){
        this.nombre = nombre;
        this.num_tel = num_tel;
    }
    public Contacto(){
        this.nombre = "Predeterminado";
        this.num_tel = "";
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setNum(String num){
        this.num_tel = num;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getNum(){
        return this.num_tel;
    }
    public String toString(){
        return "El contacto " + this.nombre + " tiene el numero " + this.num_tel;
}
}