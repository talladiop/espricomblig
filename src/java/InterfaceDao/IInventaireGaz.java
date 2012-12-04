/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDao;

import entites.InventairestGaz;
import java.util.List;

/**
 *
 * @author Talla
 */
public interface IInventaireGaz 
{
     public boolean update(InventairestGaz inv);
	public boolean save(InventairestGaz inv);
	public boolean delete(InventairestGaz inv);
	public InventairestGaz findByPrimaryKey(int pk);
	public List <InventairestGaz> findAll();
	public List <InventairestGaz> findByValue(InventairestGaz inv);
        public  boolean Valider(int pk);
        public  boolean ValiderFinale(int pk);
       
    
}
