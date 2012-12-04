/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;



public class AutorisationTonnagecl implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    private Integer idAuttonnage;
    
    private int qt;
    
    private int anneeAut;
    
    private Departement departement;
    
    

    public AutorisationTonnagecl()
    {
        this.idAuttonnage = 0;
        this.qt = 0;
        this.anneeAut = 0;
        this.departement = null;
    }

    public AutorisationTonnagecl(Integer idAuttonnage) {
        this.idAuttonnage = idAuttonnage;
    }

    public AutorisationTonnagecl(Integer idAuttonnage, int qt, int anneeAut, Departement departement) {
        this.idAuttonnage = idAuttonnage;
        this.qt = qt;
        this.anneeAut = anneeAut;
        this.departement = departement;
    }

    
     public AutorisationTonnagecl(int qt, int anneeAut, Departement departement) 
     {
        
        this.qt = qt;
        this.anneeAut = anneeAut;
        this.departement = departement;
    }
    
    
    
    public Integer getIdAuttonnage() {
        return idAuttonnage;
    }

    public void setIdAuttonnage(Integer idAuttonnage) {
        this.idAuttonnage = idAuttonnage;
    }

    public int getQt() {
        return qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }

    public int getAnneeAut() {
        return anneeAut;
    }

    public void setAnneeAut(int anneeAut) {
        this.anneeAut = anneeAut;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

   
}
