/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiceDAO;

import Factory.FactoryD;
import InterfaceService.IDifferencePrixService;
import InterfaceService.IEnqueteGazService;
import entites.Diferenceprix;
import java.util.List;


/**
 *
 * @author Talla
 */
public class DifferencePrixServiceImpl extends FactoryD implements IDifferencePrixService
{

private static DifferencePrixServiceImpl instance;
        /**
		 * @return the instance
		 */
		public synchronized static DifferencePrixServiceImpl getInstance() {
			if(instance==null){
				instance = new DifferencePrixServiceImpl();
			}
			return instance;
		}

		private DifferencePrixServiceImpl()
                {

		}




@Override
    public synchronized boolean save(Diferenceprix pr)
    {
        Diferenceprix prRechercher = new Diferenceprix();

        // verification meme enquete
	prRechercher.setIdProduit(pr.getIdDifference());
        prRechercher.setDiference(pr.getDiference());
        prRechercher.setMois(pr.getMois());
        prRechercher.setAnnee(pr.getAnnee());
        prRechercher.setDepartement(pr.getDepartement());
       

	List<Diferenceprix> ctList = differenceprixDao.findByValue(prRechercher);
	return (ctList!=null && !ctList.isEmpty())?false:differenceprixDao.save(pr);

    }


    @Override
    public synchronized boolean update(Diferenceprix pr) {
        return differenceprixDao.update(pr);
    }

    @Override
    public synchronized boolean delete(Diferenceprix pr) {
        return differenceprixDao.delete(pr);
    }

   
    @Override
    public Diferenceprix findByPrimaryKey(int pk) {
        return differenceprixDao.findByPrimaryKey(pk);
    }

    @Override
    public List<Diferenceprix> findAll() {
        return differenceprixDao.findAll();
    }

    @Override
    public List<Diferenceprix> findByValue(Diferenceprix pr) {
        return differenceprixDao.findByValue(pr);
    }

    public synchronized boolean DesactiverEtat(int pk) {
        return differenceprixDao.DesactiverEtat(pk);
    }

   


}
