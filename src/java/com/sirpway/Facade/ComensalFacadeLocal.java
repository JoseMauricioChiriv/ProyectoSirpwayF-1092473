/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirpway.Facade;

import com.sirpway.Entity.Comensal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mauricio
 */
@Local
public interface ComensalFacadeLocal {

    void create(Comensal comensal);

    void edit(Comensal comensal);

    void remove(Comensal comensal);

    Comensal find(Object id);

    List<Comensal> findAll();

    List<Comensal> findRange(int[] range);

    int count();
    
}
