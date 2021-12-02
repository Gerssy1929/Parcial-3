/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Tienda;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author German
 */
public class ListaTiendas implements IArchivoTienda, Serializable {
    private List<Tienda> lista;

    public ListaTiendas() {
        this.lista = new ArrayList();
    }
    
    
    

    @Override
    public Tienda buscar(String cod) throws IOException {
        
        for(Tienda t : this.lista){
            if(t.getCodtienda().equals(cod)){
                return t;
            }
        }
        return null;
    }

    @Override
    public List<Tienda> leer() throws IOException {
        return this.lista;
    }

    @Override
    public boolean escribir(Tienda t) throws IOException {
        
        return this.lista.add(t);
    }
}
