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
public class ProduitCl implements Serializable 
{
    private static final long serialVersionUID = 1L;
   
    private Integer idProduitcl;
    
    private String nomProduitcl;
    
    //private String typeCondition;
    
    //private String unitemesure;
    
   // private int prixunitaire;
    // private Departement departement;
    
    

    public ProduitCl() 
    {
        this.idProduitcl = 0;
        this.nomProduitcl = "";
        //this.typeCondition = "";
        //this.unitemesure = "";
        //this.prixunitaire = 0;
        //this.departement = null;
        
    }

    public ProduitCl(Integer idProduitcl) {
        this.idProduitcl = idProduitcl;
    }

    public ProduitCl(Integer idProduitcl, String nomProduitcl) {
        this.idProduitcl = idProduitcl;
        this.nomProduitcl = nomProduitcl;
        //this.typeCondition = typeCondition;
        //this.unitemesure = unitemesure;
        //this.prixunitaire = prixunitaire;
        //this.departement = departement;
    }

    
     public ProduitCl(String nomProduitcl) 
     {
       
        this.nomProduitcl = nomProduitcl;
        //this.typeCondition = typeCondition;
        //this.unitemesure = unitemesure;
        //this.prixunitaire = prixunitaire;
       // this.departement = departement;
    }
    
     
    public Integer getIdProduitcl() {
        return idProduitcl;
    }

    public void setIdProduitcl(Integer idProduitcl) {
        this.idProduitcl = idProduitcl;
    }

    public String getNomProduitcl() {
        return nomProduitcl;
    }

    public void setNomProduitcl(String nomProduitcl) {
        this.nomProduitcl = nomProduitcl;
    }

   
    

    
    
    
}
