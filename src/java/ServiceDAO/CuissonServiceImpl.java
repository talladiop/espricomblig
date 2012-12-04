/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiceDAO;

import Factory.FactoryD;
import InterfaceService.ICuissonService;
import entites.Cuisson;
import java.util.List;


/**
 *
 * @author Talla
 */
public class CuissonServiceImpl extends FactoryD implements ICuissonService
{

private static CuissonServiceImpl instance;
        /**
		 * @return the instance
		 */
		public synchronized static CuissonServiceImpl getInstance() {
			if(instance==null){
				instance = new CuissonServiceImpl();
			}
			return instance;
		}

		private CuissonServiceImpl()
                {

		}




@Override
    public synchronized boolean save(Cuisson pr)
    {
        Cuisson prRechercher = new Cuisson();

        // verification meme produit
	prRechercher.setNomCuisson(pr.getNomCuisson());
        //prRechercher.setDepartement(pr.getDepartement());
       

	List<Cuisson> ctList = cuissonDao.findByValue(prRechercher);
	return (ctList!=null && !ctList.isEmpty())?false:cuissonDao.save(pr);

    }


    @Override
    public synchronized boolean update(Cuisson pr) {
        return cuissonDao.update(pr);
    }

    @Override
    public synchronized boolean delete(Cuisson pr) {
        return cuissonDao.delete(pr);
    }

   
    @Override
    public Cuisson findByPrimaryKey(int pk) {
        return cuissonDao.findByPrimaryKey(pk);
    }

    @Override
    public List<Cuisson> findAll() {
        return cuissonDao.findAll();
    }

    @Override
    public List<Cuisson> findByValue(Cuisson pr) {
        return cuissonDao.findByValue(pr);
    }


}
