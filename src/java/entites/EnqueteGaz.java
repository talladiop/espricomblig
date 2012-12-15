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

public class EnqueteGaz implements Serializable 

{
    private static final long serialVersionUID = 1L;
    
    private Integer idEnqueteGaz;
    
    private ProduitGaz produitgaz;
    
    private int prixCuGros;
    
    private int prixCuDetail;
    
    private int prixPeriGros;
    
    private int prixPeriDetail;
   
    private String dateEnquete;
   
    private Enqueteur enqueteur;
    private Departement departement;
    private String region;
    private int mois;
    private int annee;
    private String valider;
    private String validerfinale;
    
    

    public EnqueteGaz() 
    {
         this.idEnqueteGaz = 0;
        this.produitgaz = null;
        this.prixCuGros = 0;
        this.prixCuDetail = 0;
        this.prixPeriGros = 0;
        this.prixPeriDetail = 0;
        this.dateEnquete = "";
        this.enqueteur = null;
        this.departement = null;
        this.region = "";
        this.mois = 0;
        this.annee = 0;
        this.valider = "";
        this.validerfinale ="";
    }

    public EnqueteGaz(Integer idEnqueteGaz) {
        this.idEnqueteGaz = idEnqueteGaz;
    }

    public EnqueteGaz(Integer idEnqueteGaz, ProduitGaz produitgaz, int prixCuGros, int prixCuDetail, 
            int prixPeriGros, int prixPeriDetail, String dateEnquete, 
            Enqueteur enqueteur, Departement departement, String region, int mois, int annee) {
        this.idEnqueteGaz = idEnqueteGaz;
        this.produitgaz = produitgaz;
        this.prixCuGros = prixCuGros;
        this.prixCuDetail = prixCuDetail;
        this.prixPeriGros = prixPeriGros;
        this.prixPeriDetail = prixPeriDetail;
        this.dateEnquete = dateEnquete;
        this.enqueteur = enqueteur;
        this.departement = departement;
        this.region = region;
        this.mois = mois;
        this.annee = annee;
    }
    
    
    
     public EnqueteGaz(ProduitGaz produitgaz, int prixCuGros, int prixCuDetail, 
            int prixPeriGros, int prixPeriDetail, String dateEnquete, 
            Enqueteur enqueteur, Departement departement, String region, int mois, int annee) 
     {
        this.produitgaz = produitgaz;
        this.prixCuGros = prixCuGros;
        this.prixCuDetail = prixCuDetail;
        this.prixPeriGros = prixPeriGros;
        this.prixPeriDetail = prixPeriDetail;
        this.dateEnquete = dateEnquete;
        this.enqueteur = enqueteur;
        this.departement = departement;
         this.region = region;
        this.mois = mois;
        this.annee = annee;
    }

    public Integer getIdEnqueteGaz() {
        return idEnqueteGaz;
    }

    public void setIdEnqueteGaz(Integer idEnqueteGaz) {
        this.idEnqueteGaz = idEnqueteGaz;
    }

   

    public int getPrixCuGros() {
        return prixCuGros;
    }

    public void setPrixCuGros(int prixCuGros) {
        this.prixCuGros = prixCuGros;
    }

    public int getPrixCuDetail() {
        return prixCuDetail;
    }

    public void setPrixCuDetail(int prixCuDetail) {
        this.prixCuDetail = prixCuDetail;
    }

    public int getPrixPeriGros() {
        return prixPeriGros;
    }

    public void setPrixPeriGros(int prixPeriGros) {
        this.prixPeriGros = prixPeriGros;
    }

    public int getPrixPeriDetail() {
        return prixPeriDetail;
    }

    public void setPrixPeriDetail(int prixPeriDetail) {
        this.prixPeriDetail = prixPeriDetail;
    }

    public String getDateEnquete() {
        return dateEnquete;
    }

    public void setDateEnquete(String dateEnquete) {
        this.dateEnquete = dateEnquete;
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

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
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
