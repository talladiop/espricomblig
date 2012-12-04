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

public class EnqueteEauxforet implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    private Integer idEnqueteEf;
    
    private ProduitCl produitcl;
    
    private int qtEntrer;
    
    private String dateEntrer;
    
    private int qtSortie;
    
    private String dateSortie;
    
    private String dateEnr;
    
    private Enqueteur enqueteur;
    
    private Eauxforet eauxforet;
    private String valider;
    
    

    public EnqueteEauxforet() 
    {
        this.idEnqueteEf = 0;
        this.produitcl = null;
        this.qtEntrer = 0;
        this.dateEntrer = "";
        this.qtSortie = 0;
        this.dateSortie = "";
        this.dateEntrer = "";
        this.enqueteur = null;
        this.eauxforet = null;
        this.valider = "";
        
    }

    public EnqueteEauxforet(Integer idEnqueteEf) {
        this.idEnqueteEf = idEnqueteEf;
    }

    public EnqueteEauxforet(Integer idEnqueteEf, ProduitCl produitcl, int qtEntrer, 
            String dateEntrer, int qtSortie, String dateSortie, 
            String dateEnr, Enqueteur enqueteur, Eauxforet eauxforet) {
        this.idEnqueteEf = idEnqueteEf;
        this.produitcl = produitcl;
        this.qtEntrer = qtEntrer;
        this.dateEntrer = dateEntrer;
        this.qtSortie = qtSortie;
        this.dateSortie = dateSortie;
        this.dateEnr = dateEnr;
        this.enqueteur = enqueteur;
        this.eauxforet = eauxforet;
    }

    
     public EnqueteEauxforet(ProduitCl produitcl, int qtEntrer, String dateEntrer, int qtSortie, 
             String dateSortie,  String dateEnr, Enqueteur enqueteur, Eauxforet eauxforet) 
     {
         this.produitcl = produitcl;
        this.qtEntrer = qtEntrer;
        this.dateEntrer = dateEntrer;
        this.qtSortie = qtSortie;
        this.dateSortie = dateSortie;
        this.dateEnr = dateEnr;
        this.enqueteur = enqueteur;
        this.eauxforet = eauxforet;
    }
    
    
    public Integer getIdEnqueteEf() {
        return idEnqueteEf;
    }

    public void setIdEnqueteEf(Integer idEnqueteEf) {
        this.idEnqueteEf = idEnqueteEf;
    }

    public int getQtEntrer() {
        return qtEntrer;
    }

    public void setQtEntrer(int qtEntrer) {
        this.qtEntrer = qtEntrer;
    }

    public String getDateEntrer() {
        return dateEntrer;
    }

    public void setDateEntrer(String dateEntrer) {
        this.dateEntrer = dateEntrer;
    }

    public int getQtSortie() {
        return qtSortie;
    }

    public void setQtSortie(int qtSortie) {
        this.qtSortie = qtSortie;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    public String getDateEnr() {
        return dateEnr;
    }

    public void setDateEnr(String dateEnr) {
        this.dateEnr = dateEnr;
    }

    public Eauxforet getEauxforet() {
        return eauxforet;
    }

    public void setEauxforet(Eauxforet eauxforet) {
        this.eauxforet = eauxforet;
    }

    

    public Enqueteur getEnqueteur() {
        return enqueteur;
    }

    public void setEnqueteur(Enqueteur enqueteur) {
        this.enqueteur = enqueteur;
    }

    public String getValider() {
        return valider;
    }

    public void setValider(String valider) {
        this.valider = valider;
    }

    public ProduitCl getProduitcl() {
        return produitcl;
    }

    public void setProduitcl(ProduitCl produitcl) {
        this.produitcl = produitcl;
    }

    
    
    
    
}
