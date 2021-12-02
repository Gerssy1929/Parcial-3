/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;

/**
 *
 * @author German
 */
public class Tienda implements Serializable {
    private String codtienda;
    private String nametienda;
    private String ciudad;
    private String dpto;
    private String producto;
    private int subtotal;
    private int desc;
    private int total;
    
    public Tienda(String codtienda, String nametienda, String ciudad, String dpto, String producto, int subtotal, int desc, int total) {
        this.codtienda = codtienda;
        this.nametienda = nametienda;
        this.ciudad = ciudad;
        this.dpto = dpto;
        this.producto = producto;
        this.subtotal = subtotal;
        this.desc = desc;
        this.total = total;
        
    }

    public Tienda() {
    }

    public String getCodtienda() {
        return codtienda;
    }

    public void setCodtienda(String codtienda) {
        this.codtienda = codtienda;
    }

    public String getNametienda() {
        return nametienda;
    }

    public void setNametienda(String nametienda) {
        this.nametienda = nametienda;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

   
    

   
    public String getDatosFileText(){ 
        return this.codtienda+";"+
               this.nametienda+";"+ 
               this.ciudad+";"+ 
               this.dpto+";"+ 
               this.producto+";"+
               this.subtotal+";"+
               this.desc+";"+ 
               this.total; 
               
    }
    
    
}

