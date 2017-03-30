/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.modelo.Film;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author decho
 */
@Stateless
@LocalBean
public class FilmManager implements FilmManagerLocal {
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Film update(Film film) {
        return null;
    }

    @Override
    public List<Film> getAllFilms() {
        return null;
    }  
       
    
}
