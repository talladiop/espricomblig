/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiceDAO;

import Factory.FactoryD;
import InterfaceService.IProduitGazService;
import entites.ProduitGaz;
import java.util.List;


/**
 *
 * @author Talla
 */
public class ProduitGazServiceImpl extends FactoryD implements IProduitGazService
{

private static ProduitGazServiceImpl instance;
        /**
		 * @return the instance
		 */
		public synchronized static ProduitGazServiceImpl getInstance() {
			if(instance==null){
				instance = new ProduitGazServiceImpl();
			}
			return instance;
		}

		private ProduitGazServiceImpl()
                {

		}




@Override
    public synchronized boolean save(ProduitGaz pr)
    {
        ProduitGaz prRechercher = new ProduitGaz();

        // verification meme produit
	prRechercher.setNomProduitgaz(pr.getNomProduitgaz());
       

	List<ProduitGaz> ctList = produitgazDao.findByValue(prRechercher);
	return (ctList!=null && !ctList.isEmpty())?false:produitgazDao.save(pr);

    }


    @Override
    public synchronized boolean update(ProduitGaz pr) {
        return produitgazDao.update(pr);
    }

    @Override
    public synchronized boolean delete(ProduitGaz pr) {
        return produitgazDao.delete(pr);
    }

   
    @Override
    public ProduitGaz findByPrimaryKey(int pk) {
        return produitgazDao.findByPrimaryKey(pk);
    }

    @Override
    public List<ProduitGaz> findAll() {
        return produitgazDao.findAll();
    }

    @Override
    public List<ProduitGaz> findByValue(ProduitGaz pr) {
        return produitgazDao.findByValue(pr);
    }


}
