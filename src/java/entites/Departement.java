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

public class Departement implements Serializable 
{
    private static final long serialVersionUID = 1L;
   
    private Integer iDdepartement;
    
    private Region region;
    
    private String nomdepartement;
    

    public Departement() 
    {
    this.iDdepartement = 0;  
    this.region = null;
    this.nomdepartement = "";
    
        
    }

    
    
    public Departement(Integer iDdepartement) {
        this.iDdepartement = iDdepartement;
    }

    public Departement(Integer iDdepartement, Region region, String nomdepartement) {
        this.iDdepartement = iDdepartement;
        this.region = region;
        this.nomdepartement = nomdepartement;
    }

    public Integer getIDdepartement() {
        return iDdepartement;
    }

    public void setIDdepartement(Integer iDdepartement) {
        this.iDdepartement = iDdepartement;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

   

    public String getNomdepartement() {
        return nomdepartement;
    }

    public void setNomdepartement(String nomdepartement) {
        this.nomdepartement = nomdepartement;
    }

    
    
}
