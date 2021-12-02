/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Tienda;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author German
 */
public class ArchivoTiendaTexto implements IArchivoTienda{
    private File archivo;
    private FileWriter aEscritura;
    private Scanner aLectura;

    public ArchivoTiendaTexto() {
        this.archivo = new File("ReporteVentas.dat");
    }
    
    public ArchivoTiendaTexto(String cod){
        this.archivo = new File(cod);
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
     * @return the aEscritura
     */
    public FileWriter getaEscritura() {
        return aEscritura;
    }

    /**
     * @param aEscritura the aEscritura to set
     */
    public void setaEscritura(FileWriter aEscritura) {
        this.aEscritura = aEscritura;
    }

    /**
     * @return the aLectura
     */
    public Scanner getaLectura() {
        return aLectura;
    }

    /**
     * @param aLectura the aLectura to set
     */
    public void setaLectura(Scanner aLectura) {
        this.aLectura = aLectura;
    }
    
    public Tienda leerTienda(String linea[]){
        Tienda t = new Tienda();
        
        t.setCodtienda(linea[0]);
        t.setNametienda(linea[1]);
        t.setCiudad(linea[2]);
        t.setDpto(linea[3]);
        t.setProducto(linea[4]);
        t.setSubtotal(Integer.valueOf(linea[5]));
        t.setDesc(Integer.valueOf(linea[6]));
        t.setTotal(Integer.valueOf(linea[7]));
        
        return t;
        
    }
    
    
    
    @Override
    public Tienda buscar(String cod) throws IOException{
        Tienda buscado = null;
        try {
            this.aLectura = new Scanner(this.archivo);
            while(this.aLectura.hasNext()){
                String linea[] = this.aLectura.nextLine().split(";");
                Tienda t = this.leerTienda(linea);
                if(t.getCodtienda().equals(cod)){
                    buscado = t;
                    break;
                }
            }
            return buscado;
            
        } catch (FileNotFoundException ex) {
                throw new IOException("EL archivo no se encuentra o no pueder ser leido");
        }
        finally{
            if(this.aLectura!=null)
                this.aLectura.close();
        }
    }
    
    @Override
    public List<Tienda> leer() throws IOException{
       List<Tienda> lista = null;
        try {
            
            this.aLectura = new Scanner(this.archivo);
            lista = new ArrayList();
            while(this.aLectura.hasNext()){
                String linea[] = this.aLectura.nextLine().split(";");
                Tienda t = this.leerTienda(linea);
                lista.add(t);
            }
            
            return lista;
            
        } catch (FileNotFoundException ex) {
                throw new IOException("EL archivo no se encuentra o no pueder ser leido");
        }
        finally{
            if(this.aLectura!=null)
                this.aLectura.close();
        }
        
    }
    
    @Override
    public boolean escribir(Tienda t) throws IOException{
        PrintWriter escritor = null;
        try{
            this.aEscritura = new FileWriter(this.archivo,true); // edicio
            escritor = new PrintWriter(this.aEscritura);
            escritor.println(t.getDatosFileText());
            return true;
        }catch(IOException ioe){
            throw new IOException("Error al abrir el archivo para escritura...");
           
        }
        finally{
            if(escritor!=null)
                escritor.close();
            
            if(this.aEscritura!=null){
                 this.aEscritura.close();
            }    
        }
    }
}
