/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;


/**
 *
 * @author Talla
 */

public class Cuisson implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    private Integer idCuisson;
    
    private String nomCuisson;
    
    //private int prixAchat;
    
    //private int prixVente;
    
    //private Departement departement;
    
    

    public Cuisson() 
    {
        this.idCuisson = 0;
        this.nomCuisson = "";
        //this.prixAchat = 0;
        //this.prixVente = 0;
        //this.departement = null;
        
    }

    public Cuisson(Integer idCuisson) {
        this.idCuisson = idCuisson;
    }

    public Cuisson(Integer idCuisson, String nomCuisson) {
        this.idCuisson = idCuisson;
        this.nomCuisson = nomCuisson;
        //this.prixAchat = prixAchat;
        //this.prixVente = prixVente;
        //this.departement = departement;
    }

    
    public Cuisson(String nomCuisson)
    {
        
        this.nomCuisson = nomCuisson;
        //this.prixAchat = prixAchat;
        //this.prixVente = prixVente;
       // this.departement = departement;
    }
    
    public Integer getIdCuisson() {
        return idCuisson;
    }

    public void setIdCuisson(Integer idCuisson) {
        this.idCuisson = idCuisson;
    }

    public String getNomCuisson() {
        return nomCuisson;
    }

    public void setNomCuisson(String nomCuisson) {
        this.nomCuisson = nomCuisson;
    }

   

   

   

    
}
