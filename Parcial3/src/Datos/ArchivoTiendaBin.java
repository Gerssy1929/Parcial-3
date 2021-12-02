/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Tienda;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author German
 */
public class ArchivoTiendaBin implements IArchivoTienda{
    private File archivo;
    private FileInputStream aLectura;
    private FileOutputStream aEscritura;

    public ArchivoTiendaBin() {
        this.archivo = new File("ReporteVentasBin.dat");
    }
    
    private void guardarList(ListaTiendas lista) throws IOException{
        
        this.aEscritura = new FileOutputStream(this.archivo);
        ObjectOutputStream escritor = new ObjectOutputStream(this.aEscritura);
        escritor.writeObject(lista);
        escritor.close();
        this.aEscritura.close();
    }
    
    private ListaTiendas leerLista()throws IOException{
        
        if(this.archivo.exists()){
            this.aLectura = new FileInputStream(this.archivo);
            ObjectInputStream lector = new ObjectInputStream(this.aLectura);
            try {
                ListaTiendas lista = (ListaTiendas)lector.readObject();
                return lista;
            } catch (ClassNotFoundException ex) {
                throw new IOException("Error en el contenido del achivo");
            }
            finally{
                lector.close();
                this.aLectura.close();
            }
        }
        else{
            return new ListaTiendas();
        }
        
    }
    
    

    @Override
    public Tienda buscar(String cod) throws IOException {
       ListaTiendas lista = this.leerLista();
       return lista.buscar(cod);
    }

    @Override
    public List<Tienda> leer() throws IOException {
        ListaTiendas lista = this.leerLista();
        return lista.leer();
    }

    @Override
    public boolean escribir(Tienda t) throws IOException {
        ListaTiendas lista = this.leerLista();
        lista.escribir(t);
        this.guardarList(lista);
        return true;
    }

    /**
     * @return the archivo
     */
    public File getArchivo() {
        return archivo;
    }

    /**
     * @param archivo the archivo to set
     */
    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    /**
     * @return the aLectura
     */
    public FileInputStream getaLectura() {
        return aLectura;
    }

    /**
     * @param aLectura the aLectura to set
     */
    public void setaLectura(FileInputStream aLectura) {
        this.aLectura = aLectura;
    }

    /**
     * @return the aEscritura
     */
    public FileOutputStream getaEscritura() {
        return aEscritura;
    }

    /**
     * @param aEscritura the aEscritura to set
     */
    public void setaEscritura(FileOutputStream aEscritura) {
        this.aEscritura = aEscritura;
    }
}
