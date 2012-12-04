/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

public class EnqueteEquipement implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer idenquete;
    
    private Cuisson equipement;
    
    private String dateEnquete;
    
    private Departement depart;
   
    private Enqueteur enqueteur;
   
    private int prixAchat;
   
    private int prixVente;
   
    private int qte;
    
    private String valider;
    
    private String validerfinale;
    

    public EnqueteEquipement() {
        this.idenquete = 0;
        this.equipement= null;
        this.dateEnquete = "";
        this.depart=null;
        this.enqueteur = null;
        this.prixAchat = 0;
        this.prixVente = 0;
        this.qte = 0;
        this.valider= "";
        this.validerfinale = "";
        
    }

    public EnqueteEquipement(Integer idenquete) {
        this.idenquete = idenquete;
    }

    public EnqueteEquipement(Integer idenquete, Cuisson equipement, String dateEnquete, Departement depart, Enqueteur enqueteur, int prixAchat, int prixVente, int qte, String  valider) {
        this.idenquete = idenquete;
        this.equipement= equipement;
        this.dateEnquete = dateEnquete;
        this.depart=depart;
        this.enqueteur = enqueteur;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.qte = qte;
        this.valider= valider;
    }

    public EnqueteEquipement(Cuisson equipement, String dateEnquete, Departement depart, Enqueteur enqueteur, int prixAchat, int prixVente, int qte, String  valider) {
        
        this.equipement= equipement;
        this.dateEnquete = dateEnquete;
        this.depart= depart;
        this.enqueteur = enqueteur;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.qte = qte;
        this.valider= valider;
    }

    public Integer getIdenquete() {
        return idenquete;
    }

    public void setIdenquete(Integer idenquete) {
        this.idenquete = idenquete;
    }

     public String getDateEnquete() {
        return dateEnquete;
    }

    public void setDateEnquete(String dateEnquete) {
        this.dateEnquete = dateEnquete;
    }

    public Departement getDepart() {
        return depart;
    }

    public void setDepart(Departement depart) {
        this.depart = depart;
    }
    

    public int getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    public int getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(int prixVente) {
        this.prixVente = prixVente;
    }

    public Enqueteur getEnqueteur() {
        return enqueteur;
    }

    public void setEnqueteur(Enqueteur enqueteur) {
        this.enqueteur = enqueteur;
    }

    public Cuisson getEquipement() {
        return equipement;
    }

    public void setEquipement(Cuisson equipement) {
        this.equipement = equipement;
    }

   
    public String getValider() {
        return valider;
    }

    public void setValider(String valider) {
        this.valider = valider;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public String getValiderfinale() {
        return validerfinale;
    }

    public void setValiderfinale(String validerfinale) {
        this.validerfinale = validerfinale;
    }

    
    
    
}
