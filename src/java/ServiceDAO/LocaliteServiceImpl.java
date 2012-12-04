/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiceDAO;


import Factory.FactoryD;
import InterfaceService.ILocaliteService;
import entites.Localite;
import java.util.List;

/**
 *
 * @author Cherif
 */
public class LocaliteServiceImpl extends FactoryD implements ILocaliteService{


    	private static LocaliteServiceImpl instance;
    private LocaliteServiceImpl(){

		}
    /**
		 * @return the instance
		 */
		public static LocaliteServiceImpl getInstance() {
			if(instance==null){
				instance = new LocaliteServiceImpl();
			}
			return instance;
		}


    public boolean creerLocalite(Localite localite) {
      Localite lcARechercher = new Localite();
			//lcARechercher.setIdLocalite(localite.getIDdepartement());
                        lcARechercher.setNomLocalite(localite.getNomLocalite());
                        lcARechercher.setDepartement(localite.getDepartement());

			List<Localite> lcList = localiteDao.findByValue(lcARechercher);
			return (lcList!=null && !lcList.isEmpty())?false:localiteDao.save(localite);
    }

    public void saveListLocalite(List<Localite> locaList) 
    {
       for(Localite lc : locaList)
       {
		creerLocalite(lc);
  }
    }

    public boolean modifier(Localite localite) {
         Localite localiteARechercher = new Localite();
        localiteARechercher.setIdLocalite(localite.getIdLocalite());
                        //regionARechercher.setRegion(region.getRegion());
                        //regionARechercher.setIDpays(region.getIDpays());

			List<Localite> localiteList = localiteDao.findByValue(localiteARechercher);
			return (localiteList!=null && !localiteList.isEmpty())?false:localiteDao.update(localite);
    }

    public boolean supprimer(Localite localite) {
        return localiteDao.delete(localite);
    }

    public Localite findByPrimaryKey(int pk)
    {
         return localiteDao.findByPrimaryKey(pk);
    }


    public List<Localite> findAll() {
         return localiteDao.findAll();
    }

    public List<Localite> findByValue(Localite localite) {
         return localiteDao.findByValue(localite);
    }

}
