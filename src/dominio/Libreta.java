package dominio;
import java.util.ArrayList;
import java.io.Serializable;

public class Libreta implements Serializable{
    ArrayList <Contacto> contactos = new ArrayList<>();

    public ArrayList<Contacto> geContactos(){
        return this.contactos;
    }
    public Libreta(){
        this.contactos = new ArrayList<Contacto>();
    }

    public void setContactos(ArrayList<Contacto> contactos){
        this.contactos = contactos; 
    }

    public void addContacto(Contacto c){
        this.contactos.add(c);
    }
    public String toString(){
        String res = "La libreta tiene " + this.contactos.size() + " contactos: ";
        for(Contacto c : contactos){
            res = res + " " + c.toString();
        }
        return res;
    }
    public static void main(String[] args) {
        Libreta l = new Libreta();
        Contacto c1 = new Contacto("Pablo", "1");
        Contacto c2 = new Contacto("Palbo", "2");
        l.addContacto(c1);
        l.addContacto(c2);
        System.out.println(l.toString());
    }
}
        









