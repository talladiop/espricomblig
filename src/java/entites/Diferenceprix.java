/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;



public class Diferenceprix implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    private Integer idDifference;
   
    private int idProduit;
    
    private String typeProduit;
    
    private int diference;
   
    private int mois;
  
    private int annee;
    
    private Departement departement;
   
    private int etat;

    
    
    public Diferenceprix() 
    {
        this.idDifference = 0;
        this.idProduit = 0;
        this.typeProduit = "";
        this.diference = 0;
        this.mois = 0;
        this.annee = 0;
        this.departement = null;
        this.etat = 0;
        
        
    }
    
    

    public Diferenceprix(Integer idDifference) {
        this.idDifference = idDifference;
    }

    public Diferenceprix(Integer idDifference, int idProduit, String typeProduit, 
            int diference, int mois, int annee, Departement departement, int etat) {
        this.idDifference = idDifference;
        this.idProduit = idProduit;
        this.typeProduit = typeProduit;
        this.diference = diference;
        this.mois = mois;
        this.annee = annee;
        this.departement = departement;
        this.etat = etat;
    }

    
    
    
    public Diferenceprix(int idProduit, String typeProduit, int diference, int mois, int annee, 
            Departement departement, int etat) 
    {
       
        this.idProduit = idProduit;
        this.typeProduit = typeProduit;
        this.diference = diference;
        this.mois = mois;
        this.annee = annee;
        this.departement = departement;
        this.etat = etat;
    }
    
    
    
    public Integer getIdDifference() {
        return idDifference;
    }

    public void setIdDifference(Integer idDifference) {
        this.idDifference = idDifference;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getTypeProduit() {
        return typeProduit;
    }

    public void setTypeProduit(String typeProduit) {
        this.typeProduit = typeProduit;
    }

    public int getDiference() {
        return diference;
    }

    public void setDiference(int diference) {
        this.diference = diference;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

   
    
    
    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

   
}
