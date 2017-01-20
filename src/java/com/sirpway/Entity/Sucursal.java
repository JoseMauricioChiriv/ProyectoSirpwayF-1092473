/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirpway.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name = "sucursales")
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s"),
    @NamedQuery(name = "Sucursal.findByIdsucursales", query = "SELECT s FROM Sucursal s WHERE s.idsucursales = :idsucursales"),
    @NamedQuery(name = "Sucursal.findByNombreSucursal", query = "SELECT s FROM Sucursal s WHERE s.nombreSucursal = :nombreSucursal"),
    @NamedQuery(name = "Sucursal.findByUbicacionSucursal", query = "SELECT s FROM Sucursal s WHERE s.ubicacionSucursal = :ubicacionSucursal"),
    @NamedQuery(name = "Sucursal.findByTelefono", query = "SELECT s FROM Sucursal s WHERE s.telefono = :telefono"),
    @NamedQuery(name = "Sucursal.findByCorreoElectronico", query = "SELECT s FROM Sucursal s WHERE s.correoElectronico = :correoElectronico")})
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsucursales")
    private Integer idsucursales;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "nombreSucursal")
    private String nombreSucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "ubicacionSucursal")
    private String ubicacionSucursal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correoElectronico")
    private String correoElectronico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursalesIdsucursales")
    private List<Venta> ventaList;

    public Sucursal() {
    }

    public Sucursal(Integer idsucursales) {
        this.idsucursales = idsucursales;
    }

    public Sucursal(Integer idsucursales, String nombreSucursal, String ubicacionSucursal, int telefono, String correoElectronico) {
        this.idsucursales = idsucursales;
        this.nombreSucursal = nombreSucursal;
        this.ubicacionSucursal = ubicacionSucursal;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    public Integer getIdsucursales() {
        return idsucursales;
    }

    public void setIdsucursales(Integer idsucursales) {
        this.idsucursales = idsucursales;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getUbicacionSucursal() {
        return ubicacionSucursal;
    }

    public void setUbicacionSucursal(String ubicacionSucursal) {
        this.ubicacionSucursal = ubicacionSucursal;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsucursales != null ? idsucursales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.idsucursales == null && other.idsucursales != null) || (this.idsucursales != null && !this.idsucursales.equals(other.idsucursales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Sucursal[ idsucursales=" + idsucursales + " ]";
    }
    
}
