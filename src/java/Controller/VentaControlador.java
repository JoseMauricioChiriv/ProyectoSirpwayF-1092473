/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Venta;
import Facade.VentaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Mauricio
 */
@Named(value = "ventaControlador")
@SessionScoped
public class VentaControlador implements Serializable {

    @EJB
    private VentaFacadeLocal ventaLocal;
    private Venta venta;
    public VentaControlador() {
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    
    
    @PostConstruct
    public void init(){
        venta = new Venta();
    }
    
    public void registrarVenta(){
        ventaLocal.create(venta);
    }
    
    public List<Venta> listarVenta(){
        return ventaLocal.findAll();
    }
    
}
