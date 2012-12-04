/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceService;

import entites.EnqueteEauxforet;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface IEnqueteEauxForetService 
{
    public boolean creerEnqueteAuxForet(EnqueteEauxforet eq);
	public void saveListEnqueteur(List<EnqueteEauxforet> eqList);
	public boolean modifier(EnqueteEauxforet eq);
	public boolean supprimer(EnqueteEauxforet eq);
	public EnqueteEauxforet findByPrimaryKey(int pk);
	public List <EnqueteEauxforet> findAll();
	public List <EnqueteEauxforet> findByValue(EnqueteEauxforet eq);
        public  boolean ValiderEnquete(int pk);
    
}
