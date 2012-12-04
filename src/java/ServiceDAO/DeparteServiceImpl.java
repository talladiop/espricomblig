/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiceDAO;


import Factory.FactoryD;
import InterfaceService.IDeparte;
import entites.Departement;
import java.util.List;

/**
 *
 * @author Cherif
 */
public class DeparteServiceImpl extends FactoryD implements IDeparte{


    	private static DeparteServiceImpl instance;
    private DeparteServiceImpl(){}
    /**
		 * @return the instance
		 */
		public static DeparteServiceImpl getInstance() 
                {
			if(instance==null)
                        {
				instance = new DeparteServiceImpl();
			}
			return instance;
		}


    public boolean creerDepartement(Departement dp) {
      Departement dpRechercher = new Departement();
			//lcARechercher.setIdLocalite(localite.getIDdepartement());
                        dpRechercher.setNomdepartement(dp.getNomdepartement());
                        dpRechercher.setRegion(dp.getRegion());

			List<Departement> dpList = departeDao.findByValue(dpRechercher);
			return (dpList!=null && !dpList.isEmpty())?false:departeDao.save(dp);
    }

    public void saveListDepartement(List<Departement> dp) 
    {
       for(Departement lc : dp)
       {
		creerDepartement(lc);
  }
    }

    public boolean modifier(Departement dp) {
         Departement dpARechercher = new Departement();
        dpARechercher.setIDdepartement(dp.getIDdepartement());
                        //regionARechercher.setRegion(region.getRegion());
                        //regionARechercher.setIDpays(region.getIDpays());

			List<Departement> dpList = departeDao.findByValue(dpARechercher);
			return (dpList!=null && !dpList.isEmpty())?false:departeDao.save(dp);
    }

    public boolean supprimer(Departement dp) {
        return departeDao.delete(dp);
    }

    public Departement findByPrimaryKey(int pk)
    {
         return departeDao.findByPrimaryKey(pk);
    }


    public List<Departement> findAll() {
         return departeDao.findAll();
    }

    public List<Departement> findByValue(Departement dp) {
         return departeDao.findByValue(dp);
    }

}
