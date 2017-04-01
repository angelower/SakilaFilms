/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.NewSessionBean;
import com.udea.modelo.Film;
import com.udea.session.LanguageManagerLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import com.udea.modelo.Language;


/**
 *
 * @author ASANTAANA
 */
public class FilmMBean {

    @EJB
    private NewSessionBean newSessionBean;

    @EJB
    private LanguageManagerLocal languageManager;

    @EJB
    private com.udea.session.FilmManagerLocal filmManager;

    // Propiedades del modelo
    
    private Film film;//Para mostrar, actualizar o insertar en el formulario
    private List<Film> films;    
    
    public FilmMBean() { }
    
    //Retorna una lista de películas para mostrar en un datatable de JSF
    public List<Film> getFilms(){
        if ((films==null)||(films.isEmpty())){
            refresh();
        }
            
            return films;
    }
    
    //Retorna el detalle de cada película en el formulario
    public Film getDetails(){
        return film;
    }
    
    /**
     * Action handler - llamado  en una fila de la tabla se haga clic en ID
     * @param film
     * @return
     */
    
    public String showDetails(Film film){
        this.film = film;
        return "DETAILS";//Permite enlazar a FilmDetails.xml
    }
    
    /**
     * Action handler - Actualiza el modelo de Film en la Base de Datos.
     * Se llama cuando se presiona el botón update del formulario
     * @return
     */
    
    public String update(){
        System.out.println("###UPDATE###");
        return "SAVED"; //Para el caso navegacional
    }
    
    /**
     * Action handler - retorna hacia la vista lista de la películas 
     * @return
     */
    public String list(){
        System.out.println("###LIST###");
        return "LIST"; 
    }
    
    private void refresh(){
        films = filmManager.getAllFilms();
    }
    
    
    //Para cargar correctamente los combobox del formulario Detalles
    public javax.faces.model.SelectItem[] getLanguage(){
        SelectItem[] options = null;
        List<Language> languages = languageManager.getLanguages();
        if (languages != null && languages.size()>0){
            int i =0;
            options = new SelectItem[languages.size()];
            for (Language l : languages){
                options[i++] = new SelectItem(l.getLanguage(),
                        l.getLanguage() + " (" + l.getRate() + "%)");
            }
        }
        return options;
    }
    
}
