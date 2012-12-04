/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceDAO;

import Factory.FactoryD;
import InterfaceService.IEauetforetService;
import entites.Eauxforet;
import java.util.List;



/**
 *
 * @author Talla
 */
public class EauetforetServiceImpl  extends FactoryD implements IEauetforetService
{
    
    private static EauetforetServiceImpl instance;
        /**
		 * @return the instance
		 */
		public synchronized static EauetforetServiceImpl getInstance() {
			if(instance==null){
				instance = new EauetforetServiceImpl();
			}
			return instance;
		}

		private EauetforetServiceImpl()
                {

		}


    
    

    @Override
    public synchronized boolean update(Eauxforet ea) 
    {
         Eauxforet emplARechercher = new Eauxforet();
         emplARechercher.setIdEauxforet(ea.getIdEauxforet());
         List<Eauxforet> eaList = eauetforetDao.findByValue(emplARechercher);
	 return (eaList!=null && !eaList.isEmpty())?eauetforetDao.update(ea):false;
    }

    
    
    @Override
    public synchronized boolean save(Eauxforet ea) 
    {
         Eauxforet eaRechercher = new Eauxforet();

        //recherche meme eauetforet
	eaRechercher.setNomPoste(ea.getNomPoste());
	eaRechercher.setDepartement(ea.getDepartement());
        
        
	List<Eauxforet> empList = eauetforetDao.findByValue(eaRechercher);
	return (empList!=null && !empList.isEmpty())?false:eauetforetDao.save(ea);
    }

    
    
    @Override
    public synchronized  boolean delete(Eauxforet ea) {
        return eauetforetDao.delete(ea);
    }

    @Override
    public synchronized Eauxforet findByPrimaryKey(int pk) {
        return eauetforetDao.findByPrimaryKey(pk);
    }

    @Override
    public synchronized List<Eauxforet> findAll() {
        return eauetforetDao.findAll();
    }

    @Override
    public synchronized List<Eauxforet> findByValue(Eauxforet ea) {
       return eauetforetDao.findByValue(ea);
    }

    
    
    
    
}
