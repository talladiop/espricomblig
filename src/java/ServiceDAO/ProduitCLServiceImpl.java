/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiceDAO;

import Factory.FactoryD;
import InterfaceService.IProduitCLService;
import entites.ProduitCl;
import java.util.List;


/**
 *
 * @author Talla
 */
public class ProduitCLServiceImpl extends FactoryD implements IProduitCLService
{

private static ProduitCLServiceImpl instance;
        /**
		 * @return the instance
		 */
		public synchronized static ProduitCLServiceImpl getInstance() {
			if(instance==null){
				instance = new ProduitCLServiceImpl();
			}
			return instance;
		}

		private ProduitCLServiceImpl()
                {

		}




@Override
    public synchronized boolean save(ProduitCl pr)
    {
        ProduitCl prRechercher = new ProduitCl();

        // verification meme produit
	prRechercher.setNomProduitcl(pr.getNomProduitcl());
       

	List<ProduitCl> ctList = produitclDao.findByValue(prRechercher);
	return (ctList!=null && !ctList.isEmpty())?false:produitclDao.save(pr);

    }


    @Override
    public synchronized boolean update(ProduitCl pr) {
        return produitclDao.update(pr);
    }

    @Override
    public synchronized boolean delete(ProduitCl pr) {
        return produitclDao.delete(pr);
    }

   
    @Override
    public ProduitCl findByPrimaryKey(int pk) {
        return produitclDao.findByPrimaryKey(pk);
    }

    @Override
    public List<ProduitCl> findAll() {
        return produitclDao.findAll();
    }

    @Override
    public List<ProduitCl> findByValue(ProduitCl pr) {
        return produitclDao.findByValue(pr);
    }


}
