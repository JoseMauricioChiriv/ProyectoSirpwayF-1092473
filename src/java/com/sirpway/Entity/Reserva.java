/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirpway.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name = "reservas")
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByIdReservas", query = "SELECT r FROM Reserva r WHERE r.idReservas = :idReservas"),
    @NamedQuery(name = "Reserva.findByTipoEvento", query = "SELECT r FROM Reserva r WHERE r.tipoEvento = :tipoEvento"),
    @NamedQuery(name = "Reserva.findByFechaReserva", query = "SELECT r FROM Reserva r WHERE r.fechaReserva = :fechaReserva"),
    @NamedQuery(name = "Reserva.findByNumeroPersona", query = "SELECT r FROM Reserva r WHERE r.numeroPersona = :numeroPersona"),
    @NamedQuery(name = "Reserva.findByEstadoReserva", query = "SELECT r FROM Reserva r WHERE r.estadoReserva = :estadoReserva")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idReservas")
    private Integer idReservas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipoEvento")
    private String tipoEvento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaReserva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroPersona")
    private int numeroPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "estadoReserva")
    private String estadoReserva;
    @JoinColumn(name = "mesas_idMesas", referencedColumnName = "idMesas")
    @ManyToOne(optional = false)
    private Mesa mesasidMesas;
    @JoinColumn(name = "comensales_idComensales", referencedColumnName = "idComensales")
    @ManyToOne(optional = false)
    private Comensal comensalesidComensales;

    public Reserva() {
    }

    public Reserva(Integer idReservas) {
        this.idReservas = idReservas;
    }

    public Reserva(Integer idReservas, String tipoEvento, Date fechaReserva, int numeroPersona, String estadoReserva) {
        this.idReservas = idReservas;
        this.tipoEvento = tipoEvento;
        this.fechaReserva = fechaReserva;
        this.numeroPersona = numeroPersona;
        this.estadoReserva = estadoReserva;
    }

    public Integer getIdReservas() {
        return idReservas;
    }

    public void setIdReservas(Integer idReservas) {
        this.idReservas = idReservas;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getNumeroPersona() {
        return numeroPersona;
    }

    public void setNumeroPersona(int numeroPersona) {
        this.numeroPersona = numeroPersona;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public Mesa getMesasidMesas() {
        return mesasidMesas;
    }

    public void setMesasidMesas(Mesa mesasidMesas) {
        this.mesasidMesas = mesasidMesas;
    }

    public Comensal getComensalesidComensales() {
        return comensalesidComensales;
    }

    public void setComensalesidComensales(Comensal comensalesidComensales) {
        this.comensalesidComensales = comensalesidComensales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservas != null ? idReservas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.idReservas == null && other.idReservas != null) || (this.idReservas != null && !this.idReservas.equals(other.idReservas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Reserva[ idReservas=" + idReservas + " ]";
    }
    
}
