
package com.sirpway.Controller;

import com.sirpway.Entity.Venta;
import com.sirpway.Facade.VentaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.convert.DateTimeConverter;


@Named(value = "ventaControlador")
@SessionScoped
public class VentaControlador implements Serializable {

    @EJB
    private VentaFacadeLocal ventaLocal;
    private Venta venta;
    
    private int idVenta;
    private DateTimeConverter fechaVenta;
    private int ivaVenta;
    private int meseros_IdMeseros;
    private int sucursales_IdSucursales;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }
       
    public DateTimeConverter getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(DateTimeConverter fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getIvaVenta() {
        return ivaVenta;
    }

    public void setIvaVenta(int ivaVenta) {
        this.ivaVenta = ivaVenta;
    }

    public int getMeseros_IdMeseros() {
        return meseros_IdMeseros;
    }

    public void setMeseros_IdMeseros(int meseros_IdMeseros) {
        this.meseros_IdMeseros = meseros_IdMeseros;
    }

    public int getSucursales_IdSucursales() {
        return sucursales_IdSucursales;
    }

    public void setSucursales_IdSucursales(int sucursales_IdSucursales) {
        this.sucursales_IdSucursales = sucursales_IdSucursales;
    }
    
    
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
