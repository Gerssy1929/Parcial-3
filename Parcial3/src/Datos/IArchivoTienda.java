/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Tienda;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author German
 */
public interface IArchivoTienda {
    public Tienda buscar(String cod) throws IOException;
    public List<Tienda> leer() throws IOException;
    public boolean escribir(Tienda cod) throws IOException;
}
