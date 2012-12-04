/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceDAO;

//import com.rc.entity.EnqueteEquipement;
import Factory.FactoryD;
//import FactoryService.FactoryService;
import InterfaceService.IEnqueteEquipementService;
import entites.EnqueteEquipement;
import java.util.List;

/**
 *
 * @author souleymane
 */
public class EnqueteEquipementServiceImpl extends FactoryD implements IEnqueteEquipementService{
    private static EnqueteEquipementServiceImpl instance;
    private EnqueteEquipementServiceImpl(){

		}
    /**
		 * @return the instance
		 */
		public static EnqueteEquipementServiceImpl getInstance() {
			if(instance==null){
				instance = new EnqueteEquipementServiceImpl();
			}
			return instance;
		}

    @Override
    public boolean creerEnqueteEquipement(EnqueteEquipement enqueteequipement) {
                        EnqueteEquipement enqueteequipementARechercher = new EnqueteEquipement();
			
                        enqueteequipementARechercher.setIdenquete(enqueteequipement.getIdenquete());
                        enqueteequipementARechercher.setEnqueteur(enqueteequipement.getEnqueteur());
                        enqueteequipementARechercher.setEquipement(enqueteequipement.getEquipement());
                        
                        enqueteequipementARechercher.setQte(enqueteequipement.getQte());
                        enqueteequipementARechercher.setDateEnquete(enqueteequipement.getDateEnquete());
                        enqueteequipementARechercher.setPrixAchat(enqueteequipement.getPrixAchat());
                        
                        enqueteequipementARechercher.setPrixVente(enqueteequipement.getPrixVente());
                        enqueteequipementARechercher.setValider(enqueteequipement.getValider());
			 enqueteequipementARechercher.setDepart(enqueteequipement.getDepart());
                         
                        List<EnqueteEquipement> enqueteequipementList = enqueteequipementDao.findByValue(enqueteequipementARechercher);
			return (enqueteequipementList!=null && !enqueteequipementList.isEmpty())?false:enqueteequipementDao.save(enqueteequipement);
     }

    @Override
    public void saveListEnqueteEquipement(List<EnqueteEquipement> enqueteequipementList) {
         for(EnqueteEquipement enqCl : enqueteequipementList){
				creerEnqueteEquipement(enqCl);
			}
    }

    @Override
    public boolean modifier(EnqueteEquipement enqueteequipement) {
       EnqueteEquipement enqueteequipementARechercher = new EnqueteEquipement();
        enqueteequipementARechercher.setIdenquete(enqueteequipement.getIdenquete());
                       List<EnqueteEquipement> enqueteequipementList = enqueteequipementDao.findByValue(enqueteequipementARechercher);
			return (enqueteequipementList!=null && !enqueteequipementList.isEmpty())?false:enqueteequipementDao.save(enqueteequipement);
   
    } 

    @Override
    public boolean supprimer(EnqueteEquipement enqueteequipement) {
        return enqueteequipementDao.delete(enqueteequipement);
    }

    @Override
    public EnqueteEquipement findByPrimaryKey(int pk) {
        return enqueteequipementDao.findByPrimaryKey(pk);
    }

    @Override
    public List<EnqueteEquipement> findAll() {
         return enqueteequipementDao.findAll();
    }

    @Override
    public List<EnqueteEquipement> findByValue(EnqueteEquipement enqueteequipement) {
        return enqueteequipementDao.findByValue(enqueteequipement);
    }

    public boolean Valider(int pk) {
        return enqueteequipementDao.Valider(pk);
    }

    public boolean ValiderFinale(int pk) {
        return enqueteequipementDao.ValiderFinale(pk);
    }
    
}
