/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiceDAO;

import Factory.FactoryD;
import InterfaceService.IEnqueteGazService;
import entites.EnqueteGaz;
import java.util.List;


/**
 *
 * @author Talla
 */
public class EnqueteGazServiceImpl extends FactoryD implements IEnqueteGazService
{

private static EnqueteGazServiceImpl instance;
        /**
		 * @return the instance
		 */
		public synchronized static EnqueteGazServiceImpl getInstance() {
			if(instance==null){
				instance = new EnqueteGazServiceImpl();
			}
			return instance;
		}

		private EnqueteGazServiceImpl()
                {

		}




@Override
    public synchronized boolean save(EnqueteGaz pr)
    {
        EnqueteGaz prRechercher = new EnqueteGaz();

        // verification meme enquete
	prRechercher.setProduitgaz(pr.getProduitgaz());
        prRechercher.setDepartement(pr.getDepartement());
       // prRechercher.setPrixCuDetail(pr.getPrixCuDetail());
        // prRechercher.setPrixCuGros(pr.getPrixCuGros());
        //prRechercher.setPrixPeriDetail(pr.getPrixPeriDetail());
        //prRechercher.setPrixPeriGros(pr.getPrixPeriGros());
        prRechercher.setDateEnquete(pr.getDateEnquete());
       

	List<EnqueteGaz> ctList = enquetegazDao.findByValue(prRechercher);
	return (ctList!=null && !ctList.isEmpty())?false:enquetegazDao.save(pr);

    }


    @Override
    public synchronized boolean update(EnqueteGaz pr) {
        return enquetegazDao.update(pr);
    }

    @Override
    public synchronized boolean delete(EnqueteGaz pr) {
        return enquetegazDao.delete(pr);
    }

   
    @Override
    public EnqueteGaz findByPrimaryKey(int pk) {
        return enquetegazDao.findByPrimaryKey(pk);
    }

    @Override
    public List<EnqueteGaz> findAll() {
        return enquetegazDao.findAll();
    }

    @Override
    public List<EnqueteGaz> findByValue(EnqueteGaz pr) {
        return enquetegazDao.findByValue(pr);
    }

    public synchronized boolean ValiderEnquete(int pk) {
        return enquetegazDao.ValiderEnquete(pk);
    }

    public boolean ValiderEnqueteFinale(int pk) {
        return enquetegazDao.ValiderEnqueteFinale(pk);
    }


}
