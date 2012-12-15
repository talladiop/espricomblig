/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;






public class EnqueteCl implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    private Integer idenqueteCl;
   
    private ProduitCl produitcl;
    
    private String typeCond;
   
    private int equivalantKgmin;
    
     private int equivalantKgmax;
    
    private int prixGros;
    
    private int prixDetail;
   
    private String dateEnquete;
    
    private String marchee;
    
    private Enqueteur enqueteur;
    private Departement departement;
    private String region;
    private int mois;
    private int annee;
    private String valider;
    private String validerfinale;
    
    

    public EnqueteCl() 
    {
        this.idenqueteCl = 0;
        this.produitcl = null;
        this.typeCond = "";
        this.equivalantKgmin = 0;
        this.equivalantKgmax = 0;
        this.prixGros = 0;
        this.prixDetail = 0;
        this.dateEnquete = "";
        this.marchee = "";
        this.enqueteur = null;
        this.departement = null;
        this.region = "";
        this.mois = 0;
        this.annee = 0;
        this.valider = "";
        this.validerfinale = "";
        
    }

    public EnqueteCl(Integer idenqueteCl) {
        this.idenqueteCl = idenqueteCl;
    }

    public EnqueteCl(Integer idenqueteCl, ProduitCl produitcl, String typeCond, 
            int equivalantKgmin, int equivalantKgmax, int prixGros, int prixDetail, 
            String dateEnquete, String marchee, Enqueteur enqueteur, Departement departement, 
             String region, int mois, int annee, String valider) {
        this.idenqueteCl = idenqueteCl;
        this.produitcl = produitcl;
        this.typeCond = typeCond;
        this.equivalantKgmin = equivalantKgmin;
        this.equivalantKgmax = equivalantKgmax;
        this.prixGros = prixGros;
        this.prixDetail = prixDetail;
        this.dateEnquete = dateEnquete;
        this.marchee = marchee;
        this.enqueteur = enqueteur;
        this.departement = departement;
        this.region = region;
        this.mois = mois;
        this.annee = annee;
        this.valider = valider;
    }
    
    
    
      public EnqueteCl(ProduitCl produitcl, String typeCond, 
            int equivalantKgmin, int equivalantKgmax, int prixGros, int prixDetail, 
            String dateEnquete, String marchee, Enqueteur enqueteur, Departement departement,
             String region, int mois, int annee, String valider) 
      {
       
        this.produitcl = produitcl;
        this.typeCond = typeCond;
        this.equivalantKgmin = equivalantKgmin;
        this.equivalantKgmax = equivalantKgmax;
        this.prixGros = prixGros;
        this.prixDetail = prixDetail;
        this.dateEnquete = dateEnquete;
        this.marchee = marchee;
        this.enqueteur = enqueteur;
        this.departement = departement;
        this.region = region;
        this.mois = mois;
        this.annee = annee;
        this.valider = valider;
    }
    
    

    public Integer getIdenqueteCl() {
        return idenqueteCl;
    }

    public void setIdenqueteCl(Integer idenqueteCl) {
        this.idenqueteCl = idenqueteCl;
    }

   

    public String getTypeCond() {
        return typeCond;
    }

    public void setTypeCond(String typeCond) {
        this.typeCond = typeCond;
    }

    public int getEquivalantKgmax() {
        return equivalantKgmax;
    }

    public void setEquivalantKgmax(int equivalantKgmax) {
        this.equivalantKgmax = equivalantKgmax;
    }

    public int getEquivalantKgmin() {
        return equivalantKgmin;
    }

    public void setEquivalantKgmin(int equivalantKgmin) {
        this.equivalantKgmin = equivalantKgmin;
    }

   

    public int getPrixGros() {
        return prixGros;
    }

    public void setPrixGros(int prixGros) {
        this.prixGros = prixGros;
    }

    public int getPrixDetail() {
        return prixDetail;
    }

    public void setPrixDetail(int prixDetail) {
        this.prixDetail = prixDetail;
    }

    public String getDateEnquete() {
        return dateEnquete;
    }

    public void setDateEnquete(String dateEnquete) {
        this.dateEnquete = dateEnquete;
    }

    public String getMarchee() {
        return marchee;
    }

    public void setMarchee(String marchee) {
        this.marchee = marchee;
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

    public ProduitCl getProduitcl() {
        return produitcl;
    }

    public void setProduitcl(ProduitCl produitcl) {
        this.produitcl = produitcl;
    }

    public String getValider() {
        return valider;
    }

    public void setValider(String valider) {
        this.valider = valider;
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
