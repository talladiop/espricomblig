/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceService;

import entites.Enqueteur;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface IEnqueteurService 
{
    public boolean creerEnqueteur(Enqueteur enqueteur);
	public void saveListEnqueteur(List<Enqueteur> eqList);
	public boolean modifier(Enqueteur enqueteur);
	public boolean supprimer(Enqueteur enqueteur);
	public Enqueteur findByPrimaryKey(int pk);
	public List <Enqueteur> findAll();
	public List <Enqueteur> findByValue(Enqueteur enqueteur);
        public  boolean activer(int pk);
        public  boolean desactiver(int pk);
    
}
