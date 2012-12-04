/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiceDAO;


import Factory.FactoryD;
import InterfaceService.IAutorisationTonnageService;
import entites.AutorisationTonnagecl;
import java.util.List;

/**
 *
 * @author Cherif
 */
public class AutorisationTonnageServiceImpl extends FactoryD implements IAutorisationTonnageService{


    	private static AutorisationTonnageServiceImpl instance;
        
    private AutorisationTonnageServiceImpl()
    {
    }
    /**
		 * @return the instance
		 */
		public static AutorisationTonnageServiceImpl getInstance() {
			if(instance==null){
				instance = new AutorisationTonnageServiceImpl();
			}
			return instance;
		}


    public synchronized boolean creerAutorisationTonnage(AutorisationTonnagecl aut) 
    {
      AutorisationTonnagecl autARechercher = new AutorisationTonnagecl();
      
                        //verification insertion tonnage
			autARechercher.setAnneeAut(aut.getAnneeAut());
                        //autARechercher.setDepartement(aut.getDepartement());
                                               
			List<AutorisationTonnagecl> eqList = autorisationtonnageDao.findByValue(aut);
			return (eqList!=null && !eqList.isEmpty())?false:autorisationtonnageDao.save(aut);
    }

    public synchronized void saveListAutorisationTonnage(List<AutorisationTonnagecl> aut) 
    {
       for(AutorisationTonnagecl eq : aut)
       {
		creerAutorisationTonnage(eq);
       }
    }

    
    public synchronized boolean modifier(AutorisationTonnagecl aut) {
         AutorisationTonnagecl eqARechercher = new AutorisationTonnagecl();
         
        eqARechercher.setIdAuttonnage(aut.getIdAuttonnage());
        

			List<AutorisationTonnagecl> eqList = autorisationtonnageDao.findByValue(eqARechercher);
			return (eqList!=null && !eqList.isEmpty())?false:autorisationtonnageDao.update(aut);
    }

    public synchronized boolean supprimer(AutorisationTonnagecl aut) {
        return autorisationtonnageDao.delete(aut);
    }

    public synchronized AutorisationTonnagecl findByPrimaryKey(int pk)
    {
         return autorisationtonnageDao.findByPrimaryKey(pk);
    }


    public synchronized List<AutorisationTonnagecl> findAll() {
         return autorisationtonnageDao.findAll();
    }

    public synchronized List<AutorisationTonnagecl> findByValue(AutorisationTonnagecl aut) {
         return autorisationtonnageDao.findByValue(aut);
    }

   

}
