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

public class Enqueteur implements Serializable 
{
    private static final long serialVersionUID = 1L;
   
    private Integer idenqueteur;
    
    private String nomenqueteur;
   
    private String prenomenqueteur;
   
    private String tel;
    
    private String email;
    private  Departement departement;
    private  String login;
    private  String pwd;
    private  int profile;
    private  String etatcompte;
   
    

    public Enqueteur() 
    {
        this.idenqueteur = 0;
         this.nomenqueteur = "";
        this.prenomenqueteur = "";
        this.tel = "";
        this.email = "";
        this.departement = null;
        this.login = "";
        this.pwd = "";
        this.profile = 0;
        this.etatcompte = "";
    }
    

    public Enqueteur(Integer idenqueteur) {
        this.idenqueteur = idenqueteur;
    }

    public Enqueteur(Integer idenqueteur, String nomenqueteur, 
            String prenomenqueteur, String tel, String email, 
            Departement departement, String login, String pwd, 
            int profile, String etatcompte) {
        this.idenqueteur = idenqueteur;
        this.nomenqueteur = nomenqueteur;
        this.prenomenqueteur = prenomenqueteur;
        this.tel = tel;
        this.email = email;
        this.departement = departement;
         this.login = login;
        this.pwd = pwd;
        this.profile = profile;
        this.etatcompte = etatcompte;
    }

    
    public Enqueteur(String nomenqueteur, String prenomenqueteur, String tel, 
            String email, Departement departement, String login, String pwd, 
            int profile, String etatcompte) 
    {
      
        this.nomenqueteur = nomenqueteur;
        this.prenomenqueteur = prenomenqueteur;
        this.tel = tel;
        this.email = email;
        this.departement = departement;
        this.login = login;
        this.pwd = pwd;
        this.profile = profile;
        this.etatcompte = etatcompte;
    }
    
    
    public Integer getIdenqueteur() {
        return idenqueteur;
    }

    public void setIdenqueteur(Integer idenqueteur) {
        this.idenqueteur = idenqueteur;
    }

    public String getNomenqueteur() {
        return nomenqueteur;
    }

    public void setNomenqueteur(String nomenqueteur) {
        this.nomenqueteur = nomenqueteur;
    }

    public String getPrenomenqueteur() {
        return prenomenqueteur;
    }

    public void setPrenomenqueteur(String prenomenqueteur) {
        this.prenomenqueteur = prenomenqueteur;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEtatcompte() {
        return etatcompte;
    }

    public void setEtatcompte(String etatcompte) {
        this.etatcompte = etatcompte;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

   
    

  
}
