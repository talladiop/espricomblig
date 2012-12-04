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

public class Localite implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    private Integer idLocalite;
    
    private String nomLocalite;
   
    private  Departement departement;
    

    public Localite() 
    {
        this.idLocalite = 0;
        this.nomLocalite = "";
        this.departement = null;
    }
    
    

    public Localite(Integer idLocalite) 
    {
        this.idLocalite = idLocalite;
    }

    
    public Localite(Integer idLocalite, String nomLocalite, Departement departement) {
        this.idLocalite = idLocalite;
        this.nomLocalite = nomLocalite;
        this.departement = departement;
    }
    
    
    
    public Localite(String nomLocalite, Departement departement)
    {
        this.nomLocalite = nomLocalite;
        this.departement = departement;
    }
    

    public Integer getIdLocalite() {
        return idLocalite;
    }

    public void setIdLocalite(Integer idLocalite) {
        this.idLocalite = idLocalite;
    }

    public String getNomLocalite() {
        return nomLocalite;
    }

    public void setNomLocalite(String nomLocalite) {
        this.nomLocalite = nomLocalite;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

   

    
}
