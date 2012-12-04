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

public class Eauxforet implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    private Integer idEauxforet;
   
    private String nomPoste;
    
    private String tel;
   
    private Departement departement;
    

    public Eauxforet() 
    {
        this.idEauxforet = 0;
        this.nomPoste = "";
        this.tel = "";
        this.departement = null;
        
    }

    
    public Eauxforet(Integer idEauxforet) 
    {
        this.idEauxforet = idEauxforet;
    }

    
    
    public Eauxforet(Integer idEauxforet, String nomPoste, String tel, Departement departement) {
        this.idEauxforet = idEauxforet;
        this.nomPoste = nomPoste;
        this.tel = tel;
        this.departement = departement;
    }
    
     public Eauxforet(String nomPoste, String tel, Departement departement) {
        this.nomPoste = nomPoste;
        this.tel = tel;
        this.departement = departement;
    }
    

    public Integer getIdEauxforet() {
        return idEauxforet;
    }

    public void setIdEauxforet(Integer idEauxforet) {
        this.idEauxforet = idEauxforet;
    }

    public String getNomPoste() {
        return nomPoste;
    }

    public void setNomPoste(String nomPoste) {
        this.nomPoste = nomPoste;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    

    
}
