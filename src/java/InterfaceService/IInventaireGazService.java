/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceService;

import entites.InventairestGaz;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface IInventaireGazService 
{
     public boolean creer(InventairestGaz inv);
	public boolean modifier(InventairestGaz inv);
	public boolean supprimer(InventairestGaz inv);
	public InventairestGaz findByPrimaryKey(int pk);
	public List <InventairestGaz> findAll();
	public List <InventairestGaz> findByValue(InventairestGaz inv);
        public  boolean Valider(int pk);
        public  boolean ValiderFinale(int pk);
    
}
