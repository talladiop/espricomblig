/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceService;

import entites.EnqueteEquipement;
import java.util.List;

/**
 *
 * @author souleymane
 */
public interface IEnqueteEquipementService {
    public boolean creerEnqueteEquipement(EnqueteEquipement enqueteequipement);
	public void saveListEnqueteEquipement(List<EnqueteEquipement> enqueteequipementList);
	public boolean modifier(EnqueteEquipement enqueteequipement);
	public boolean supprimer(EnqueteEquipement enqueteequipement);
	public EnqueteEquipement findByPrimaryKey(int pk);
	public List <EnqueteEquipement> findAll();
	public List <EnqueteEquipement> findByValue(EnqueteEquipement enqueteequipement);
        public  boolean Valider(int pk);
        public  boolean ValiderFinale(int pk);

    
}
