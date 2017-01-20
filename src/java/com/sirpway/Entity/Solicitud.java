/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirpway.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "solicitudes")
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s"),
    @NamedQuery(name = "Solicitud.findByIdSolicitud", query = "SELECT s FROM Solicitud s WHERE s.idSolicitud = :idSolicitud"),
    @NamedQuery(name = "Solicitud.findByFechaHoraPqrs", query = "SELECT s FROM Solicitud s WHERE s.fechaHoraPqrs = :fechaHoraPqrs"),
    @NamedQuery(name = "Solicitud.findByObservacion", query = "SELECT s FROM Solicitud s WHERE s.observacion = :observacion")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSolicitud")
    private Integer idSolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaHoraPqrs")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraPqrs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "observacion")
    private String observacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudesidSolicitud")
    private List<Respuesta> respuestaList;
    @JoinColumn(name = "tipoSolicitudes_idTipoSolicitud", referencedColumnName = "idTipoSolicitud")
    @ManyToOne(optional = false)
    private Tiposolicitud tipoSolicitudesidTipoSolicitud;
    @JoinColumn(name = "personas_idPersona", referencedColumnName = "idPersona")
    @ManyToOne(optional = false)
    private Persona personasidPersona;
    @JoinColumn(name = "administradores_idAdministrador", referencedColumnName = "idAdministrador")
    @ManyToOne(optional = false)
    private Administrador administradoresidAdministrador;

    public Solicitud() {
    }

    public Solicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Solicitud(Integer idSolicitud, Date fechaHoraPqrs, String observacion) {
        this.idSolicitud = idSolicitud;
        this.fechaHoraPqrs = fechaHoraPqrs;
        this.observacion = observacion;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Date getFechaHoraPqrs() {
        return fechaHoraPqrs;
    }

    public void setFechaHoraPqrs(Date fechaHoraPqrs) {
        this.fechaHoraPqrs = fechaHoraPqrs;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public List<Respuesta> getRespuestaList() {
        return respuestaList;
    }

    public void setRespuestaList(List<Respuesta> respuestaList) {
        this.respuestaList = respuestaList;
    }

    public Tiposolicitud getTipoSolicitudesidTipoSolicitud() {
        return tipoSolicitudesidTipoSolicitud;
    }

    public void setTipoSolicitudesidTipoSolicitud(Tiposolicitud tipoSolicitudesidTipoSolicitud) {
        this.tipoSolicitudesidTipoSolicitud = tipoSolicitudesidTipoSolicitud;
    }

    public Persona getPersonasidPersona() {
        return personasidPersona;
    }

    public void setPersonasidPersona(Persona personasidPersona) {
        this.personasidPersona = personasidPersona;
    }

    public Administrador getAdministradoresidAdministrador() {
        return administradoresidAdministrador;
    }

    public void setAdministradoresidAdministrador(Administrador administradoresidAdministrador) {
        this.administradoresidAdministrador = administradoresidAdministrador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.idSolicitud == null && other.idSolicitud != null) || (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Solicitud[ idSolicitud=" + idSolicitud + " ]";
    }
    
}
