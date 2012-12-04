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

public class ProduitGaz implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    private Integer idProduitgaz;
    
    private String nomProduitgaz;
  
   // private Departement departement;
    
    

    public ProduitGaz() 
    {
         this.idProduitgaz = 0;
        this.nomProduitgaz = "";
       // this.departement = null;
        
    }

    public ProduitGaz(Integer idProduitgaz) {
        this.idProduitgaz = idProduitgaz;
    }

    public ProduitGaz(Integer idProduitgaz, String nomProduitgaz) {
        this.idProduitgaz = idProduitgaz;
        this.nomProduitgaz = nomProduitgaz;
        //this.departement = departement;
    }
    
    
    
    public ProduitGaz(String nomProduitgaz) 
    {
        
        this.nomProduitgaz = nomProduitgaz;
        //this.departement = departement;
    }
    
    

    public Integer getIdProduitgaz() {
        return idProduitgaz;
    }

    public void setIdProduitgaz(Integer idProduitgaz) {
        this.idProduitgaz = idProduitgaz;
    }

    public String getNomProduitgaz() {
        return nomProduitgaz;
    }

    public void setNomProduitgaz(String nomProduitgaz) {
        this.nomProduitgaz = nomProduitgaz;
    }


   
   
    
    
}
