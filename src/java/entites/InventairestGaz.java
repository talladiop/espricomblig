/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;




public class InventairestGaz implements Serializable 
{
    private static final long serialVersionUID = 1L;
   
    private Integer idEnventairegaz;
    
    private ProduitGaz produitgaz;
   
    private int qt;
    
    private String dateEnr;
    
    private Enqueteur enqueteur;
   
    private Departement departement;
     private String region;
     
    private int mois;
    
    private int annee;
    
    private String valider;
    
    private String validerfinale;
    
    
    

    public InventairestGaz() 
    {
        
        this.idEnventairegaz = 0;
        this.produitgaz = null;
        this.qt = 0;
        this.dateEnr = "";
        this.enqueteur = null;
        this.departement = null;
        this.region = "";
        this.mois = 0;
        this.annee = 0;
        this.valider = "";
        
        this.validerfinale = "";
    }

    public InventairestGaz(Integer idEnventairegaz) {
        this.idEnventairegaz = idEnventairegaz;
    }

    public InventairestGaz(Integer idEnventairegaz, ProduitGaz produitgaz, int qt, String dateEnr, 
            Enqueteur enqueteur, Departement departement, 
            String region, int mois, int annee, String valider) {
        this.idEnventairegaz = idEnventairegaz;
        this.produitgaz = produitgaz;
        this.qt = qt;
        this.dateEnr = dateEnr;
        this.enqueteur = enqueteur;
        this.departement = departement;
         this.region = region;
        this.mois = mois;
        this.annee = annee;
        this.valider = valider;
    }
    
    
     public InventairestGaz(ProduitGaz produitgaz, int qt, String dateEnr, 
             Enqueteur enqueteur, Departement departement, String region, int mois, 
             int annee, String valider) 
     {
       
        this.produitgaz = produitgaz;
        this.qt = qt;
        this.dateEnr = dateEnr;
        this.enqueteur = enqueteur;
        this.departement = departement;
         this.region = region;
        this.mois = mois;
        this.annee = annee;
        this.valider = valider;
    }
    

    public Integer getIdEnventairegaz() {
        return idEnventairegaz;
    }

    public void setIdEnventairegaz(Integer idEnventairegaz) {
        this.idEnventairegaz = idEnventairegaz;
    }

    
    public int getQt() {
        return qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }

    public String getDateEnr() {
        return dateEnr;
    }

    public void setDateEnr(String dateEnr) {
        this.dateEnr = dateEnr;
    }

   

    public String getValider() {
        return valider;
    }

    public void setValider(String valider) {
        this.valider = valider;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Enqueteur getEnqueteur() {
        return enqueteur;
    }

    public void setEnqueteur(Enqueteur enqueteur) {
        this.enqueteur = enqueteur;
    }

    public ProduitGaz getProduitgaz() {
        return produitgaz;
    }

    public void setProduitgaz(ProduitGaz produitgaz) {
        this.produitgaz = produitgaz;
    }

    public String getValiderfinale() {
        return validerfinale;
    }

    public void setValiderfinale(String validerfinale) {
        this.validerfinale = validerfinale;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

   

  
    
    
}
