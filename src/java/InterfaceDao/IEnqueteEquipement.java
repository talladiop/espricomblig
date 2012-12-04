/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDao;

import entites.EnqueteEquipement;
import java.util.List;

/**
 *
 * @author souleymane
 */
public interface IEnqueteEquipement {
    
     public boolean update(EnqueteEquipement enqueteEquipement);
	public boolean save(EnqueteEquipement EnqueteEquipement);
	public boolean delete(EnqueteEquipement EnqueteEquipement);
	public EnqueteEquipement findByPrimaryKey(int pk);
	public List <EnqueteEquipement> findAll();
	public List <EnqueteEquipement> findByValue(EnqueteEquipement EnqueteEquipement);
        public  boolean Valider(int pk);
        public  boolean ValiderFinale(int pk);
    
}
