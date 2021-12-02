/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Entidades.Tienda;
import Logica.Consolidados;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author German
 */
public class Consultas extends JDialog implements ActionListener {
     private Container contenedor;
    private JPanel panelFiltro, panelBase;
    private JScrollPane panelResultado;
    private JButton btnbusqueda;
    private JTable tabla;
    private DefaultTableModel modelo;
    private String titulos[]={"Cod Tienda", "Nombre Tienda", "Ciudad", "Departamento", "Producto", "Subtotal", "Descuento", "Total"};
    private Consolidados logica;
    
    public Consultas(JFrame frame, boolean bln) {
        super(frame, bln);
        this.logica = new Consolidados();
        this.setTitle("Consulta de Consolidados - Punto Market");
        this.iniciarComponentes();
        //this.pack(); 
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //this.buscar();
        this.setVisible(true);
    }
    
    public void iniciarComponentes(){
        this.contenedor = this.getContentPane();
        this.panelBase = new JPanel();
        this.panelBase.setLayout(new BorderLayout());
        this.panelBase.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.iniciarPanelFiltro();
        this.iniciarPanelResultado();
        this.contenedor.add(this.panelBase);
    }
    
    public void iniciarPanelFiltro(){
        this.panelFiltro = new JPanel();
        this.panelFiltro.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        this.btnbusqueda = new JButton("Cargar Reporte Ventas");
        this.btnbusqueda.addActionListener(this);
        
        
        this.panelFiltro.add(this.btnbusqueda);
        
        this.panelBase.add(this.panelFiltro, BorderLayout.NORTH);
        
       
    }
    
    public void iniciarPanelResultado(){
        
        this.panelResultado = new JScrollPane();
        
        this.tabla = new JTable();
        this.modelo = new DefaultTableModel(null, this.titulos);
        this.tabla.setModel(modelo);
        this.panelResultado.setViewportView(this.tabla);
        
        this.panelBase.add(this.panelResultado, BorderLayout.CENTER);
    
    }
    
    public void buscar(){
        try {
            List<Tienda> lista = this.logica.leer();
            this.modelo.setNumRows(0);
            for(Tienda t: lista){
                String fila[]={t.getCodtienda(), t.getNametienda(), t.getCiudad(), t.getDpto(), t.getProducto(), String.valueOf(t.getSubtotal()), String.valueOf(t.getDesc()), String.valueOf(t.getTotal())};
                    this.modelo.addRow(fila);
                }
               
            }catch (IOException ex) {
           VentanaAux.mostrarMsg(this, "Error", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==this.btnbusqueda){
            buscar();
        }
    }
    
}

