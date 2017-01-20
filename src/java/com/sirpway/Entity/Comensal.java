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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "comensales")
@NamedQueries({
    @NamedQuery(name = "Comensal.findAll", query = "SELECT c FROM Comensal c"),
    @NamedQuery(name = "Comensal.findByIdComensales", query = "SELECT c FROM Comensal c WHERE c.idComensales = :idComensales"),
    @NamedQuery(name = "Comensal.findByObservaciones", query = "SELECT c FROM Comensal c WHERE c.observaciones = :observaciones"),
    @NamedQuery(name = "Comensal.findByQuejasReclamo", query = "SELECT c FROM Comensal c WHERE c.quejasReclamo = :quejasReclamo")})
public class Comensal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idComensales")
    private Integer idComensales;
    @Size(max = 100)
    @Column(name = "observaciones")
    private String observaciones;
    @Size(max = 45)
    @Column(name = "quejasReclamo")
    private String quejasReclamo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comensalesidComensales")
    private List<Reserva> reservaList;
    @JoinColumn(name = "personas_idPersona", referencedColumnName = "idPersona")
    @ManyToOne(optional = false)
    private Persona personasidPersona;

    public Comensal() {
    }

    public Comensal(Integer idComensales) {
        this.idComensales = idComensales;
    }

    public Integer getIdComensales() {
        return idComensales;
    }

    public void setIdComensales(Integer idComensales) {
        this.idComensales = idComensales;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getQuejasReclamo() {
        return quejasReclamo;
    }

    public void setQuejasReclamo(String quejasReclamo) {
        this.quejasReclamo = quejasReclamo;
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    public Persona getPersonasidPersona() {
        return personasidPersona;
    }

    public void setPersonasidPersona(Persona personasidPersona) {
        this.personasidPersona = personasidPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComensales != null ? idComensales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comensal)) {
            return false;
        }
        Comensal other = (Comensal) object;
        if ((this.idComensales == null && other.idComensales != null) || (this.idComensales != null && !this.idComensales.equals(other.idComensales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Comensal[ idComensales=" + idComensales + " ]";
    }
    
}
