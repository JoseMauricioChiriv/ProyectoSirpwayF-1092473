/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirpway.Facade;

import com.sirpway.Entity.Tiposolicitud;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mauricio
 */
@Local
public interface TiposolicitudFacadeLocal {

    void create(Tiposolicitud tiposolicitud);

    void edit(Tiposolicitud tiposolicitud);

    void remove(Tiposolicitud tiposolicitud);

    Tiposolicitud find(Object id);

    List<Tiposolicitud> findAll();

    List<Tiposolicitud> findRange(int[] range);

    int count();
    
}
