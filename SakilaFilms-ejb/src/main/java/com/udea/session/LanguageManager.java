/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.modelo.Film;
import com.udea.modelo.Language;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author decho
 */
@Stateless

public class LanguageManager implements LanguageManagerLocal {

    @PersistenceContext(unitName = "com.udea_SakilaFilms-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    

    @Override
    public List<Language> getLanguages() {
        
    Query query=em.createNamedQuery("Language.findAll");
        return query.getResultList();
    }

   
    
    
    

    
}
