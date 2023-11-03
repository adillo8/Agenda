package aplicacion;
import java.util.Scanner;

import persentacion.Interfaz;

public class Principal {
    public static void main(String[] args) {
        Interfaz i = new Interfaz();
        Scanner sc = new Scanner(System.in);
        String input;
        do{
            System.out.println("Que desea hacer?");
            input = sc.nextLine();
            i.leer(input);
        }while(i.getState());
        sc.close();
    }
}