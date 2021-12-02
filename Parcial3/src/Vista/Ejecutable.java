/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Entidades.Tienda;
import Logica.Consolidados;
import java.io.IOException;

/**
 *
 * @author German
 */
public class Ejecutable {
    public static void main(String[] args) {
        Consolidados consol = new Consolidados();
        Tienda t1 = new Tienda("01", "galeria", "Valledupar", "Cesar", "Lavadora", 50000, 10000, 40000);
        Tienda t2 = new Tienda("01", "galeria", "Valledupar", "Cesar", "Televisor", 70000, 15000, 55000);
        try{
            consol.escribir(t1);
            consol.escribir(t2);
        }catch(IOException ioe){
            System.out.println(ioe);
        }   
           
    Consultas  Ventana = new Consultas(null, true);
    
    }
    
}
