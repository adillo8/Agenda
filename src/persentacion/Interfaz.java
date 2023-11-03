package persentacion;
import dominio.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Interfaz {
    Libreta libreta = new Libreta();
    ArrayList<Contacto> contactos = new ArrayList<>();;
    boolean keepgoing = true;
    public boolean getState(){
        return this.keepgoing;
    }    

    public Interfaz(){
    ObjectInputStream obj;
    File file = new File("contactos.txt");
    try{
        obj = new ObjectInputStream(new FileInputStream(file));
        try{contactos = (ArrayList<Contacto>)obj.readObject();}catch(Exception e){System.out.println(e);}
        obj.close();
        System.out.println("leido");
    } catch(Exception e){
        System.out.println("no leido");
        contactos = new ArrayList<>();
    };

    }
    public void leer(String input){
        String [] split = input.split(" ");
        if(split[0].equalsIgnoreCase("list")){
            list();
        }
        else if(split[0].equalsIgnoreCase("add") && split[1].equalsIgnoreCase("contacto")){
            addContacto(input);
        }
        else if(split[0].equalsIgnoreCase("mod") && split[1].equalsIgnoreCase("contacto")){
            modContacto(input);
        }
        else if(split[0].equalsIgnoreCase("delete") && split[1].equalsIgnoreCase("contacto")){
            delContacto(input);
        }
        else if(split[0].equalsIgnoreCase("salir")){
            ObjectOutputStream obj;
                File file = new File("contactos.txt");
                try{
                    obj = new ObjectOutputStream(new FileOutputStream(file));
                    obj.writeObject(contactos);
                    obj.close();
                    System.out.println("Guardado");
                } catch(Exception e){
                System.out.println("Error al guardar");
                System.out.println(e);
                };

                this.keepgoing = false;
        }
    }
    public void addContacto(String input){
        String[] split = input.split(" ");
        String nombre = split[2];
        boolean existe = false;
        String num = split[3];
        for(int i = 0; i < contactos.size(); i++){
            if(contactos.get(i).getNombre().equalsIgnoreCase(nombre)){
                existe = true;
                System.out.println("Contacto ya existe.");
            }
        }
        if(existe == false){
            Contacto c = new Contacto(nombre, num);
            contactos.add(c);
            System.out.println("added");
        }
    }

    public void modContacto(String input){
        String[] split = input.split(" ");
        String nombre = split[2];
        String variable = split[3];
        boolean existe = false;
        if(variable.matches("(.*)[0-9](.*)")){
            Integer.parseInt(split[3]);
            for(int i = 0; i < contactos.size();i++){
                if(contactos.get(i).getNombre().equalsIgnoreCase(nombre)){
                    existe = true;
                    contactos.get(i).setNum(split[3]);
                }
            }
            if(existe == false){
                System.out.println("Contacto no existe.");
            }
        }else{
            for(int i = 0; i < contactos.size(); i ++ ){
                if(contactos.get(i).getNombre().equalsIgnoreCase(nombre)){
                    contactos.get(i).setNombre(split[3]);
                    existe = true;
                }
            }
            if(existe == false){
                System.out.println("Contacto no existe");
            }
        }
    }
    
    public void delContacto(String input){
        String[] split = input.split(" ");
        System.out.println("borro " + input);
        String nombre = split[2];
        if(contactos.size() == 0){System.out.println("La libreta esta vacia");}
        for(int i = 0; i < contactos.size(); i++){
            if(contactos.get(i).getNombre().equalsIgnoreCase(nombre)){
                contactos.remove(contactos.get(i));
            }
            else{System.out.println("No se ha encontrado el contacto");}
        }
    }

    public void list(){
        System.out.println("libreta size = "+ libreta.geContactos().size());
        System.out.println("contactos size = "+ contactos.size());
        libreta.setContactos(contactos);
        System.out.println(libreta.toString());
    }
}
                