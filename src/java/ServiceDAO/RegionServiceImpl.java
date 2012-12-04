/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiceDAO;


import Factory.FactoryD;
import InterfaceService.IRegionService;
import entites.Region;
import java.util.List;

/**
 *
 * @author Cherif
 */
public class RegionServiceImpl extends FactoryD implements IRegionService{

    	private static RegionServiceImpl instance;
    private RegionServiceImpl(){

		}
    /**
		 * @return the instance
		 */
		public static RegionServiceImpl getInstance() {
			if(instance==null){
				instance = new RegionServiceImpl();
			}
			return instance;
		}


    public boolean creerRegion(Region region) {
      Region regionARechercher = new Region();
			regionARechercher.setIDregion(region.getIDregion());
                        regionARechercher.setNomregion(region.getNomregion());
                       

			List<Region> regionList = regionDao.findByValue(regionARechercher);
			return (regionList!=null && !regionList.isEmpty())?false:regionDao.save(region);
    }

    public void saveListRegion(List<Region> regionList) {
       for(Region region : regionList){
				creerRegion(region);
			}
    }

    public boolean modifier(Region region) {
         Region regionARechercher = new Region();
        regionARechercher.setIDregion(region.getIDregion());
                        //regionARechercher.setRegion(region.getRegion());
                        //regionARechercher.setIDpays(region.getIDpays());

			List<Region> regionList = regionDao.findByValue(regionARechercher);
			return (regionList!=null && !regionList.isEmpty())?false:regionDao.save(region);
    }

    public boolean supprimer(Region region) {
        return regionDao.delete(region);
    }

    public Region findByPrimaryKey(int pk) {
         return regionDao.findByPrimaryKey(pk);
    }
    

    public List<Region> findAll() {
         return regionDao.findAll();
    }

    public List<Region> findByValue(Region region) {
         return regionDao.findByValue(region);
    }

}
