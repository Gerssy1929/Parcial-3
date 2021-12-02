/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.*;
import Entidades.Tienda;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author German
 */
public class Consolidados {
    private IArchivoTienda data;

    public Consolidados() {
        //this.data = new ArchivoTiendaTexto();
        this.data = new ArchivoTiendaBin();
        
    }

    public IArchivoTienda getData() {
        return data;
    }

    public void setData(IArchivoTienda data) {
        this.data = data;
    }

    
    public Tienda buscar(String cod) throws IOException{
        return this.data.buscar(cod);
    }
    public List<Tienda> leer() throws IOException{
        return this.data.leer();
    }
    
    public boolean escribir(Tienda t) throws IOException{
            
        return this.data.escribir(t);
    }
}
